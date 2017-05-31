package cn.crm.dao.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.crm.dao.CustomerDAO;
import cn.crm.entity.CommunicateRecord;
import cn.crm.entity.CustLinkMan;
import cn.crm.entity.Customer;
import cn.crm.entity.Orders;
import cn.crm.entity.OrdersLine;

public class CustomerDAOImpl extends HibernateDaoSupport implements CustomerDAO{

	//实现添加客户的功能
	public void add(Customer customer) {
		this.getHibernateTemplate().save(customer);
	}

	//客户列表功能
	@SuppressWarnings("unchecked")
	public List<Customer> findAll() {
		return (List<Customer>) this.getHibernateTemplate().find("from Customer");
	}

	//根据id查询
	public Customer findOne(String cust_no) {
		
		return this.getHibernateTemplate().get(Customer.class, cust_no);
	}

	//删除功能
	public void delete(Customer customer) {
		customer.setCust_flag(0);
		this.getHibernateTemplate().update(customer);
	}

	//修改功能
	public boolean update(Customer customer) {
		boolean flag = false;
		try {
			this.getHibernateTemplate().update(customer);
			this.getHibernateTemplate().flush();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return flag;
	}

	//查询记录数
	@SuppressWarnings("unchecked")
	public int findCount() {
		//调用hibernateTemplate里面的find方法
		List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from Customer where cust_flag = 1");
		
		//从list中把值得到
		if (list != null && list.size() != 0) {
			Object object = list.get(0);
			Long lobj = (Long) object;
			int count = lobj.intValue();
			return count;
		}
		return 0;
	}

	//分页查询操作
	@SuppressWarnings("unchecked")
	public List<Customer> findPage(int begin, int pageSize) {
		//第一种 使用hibernate底层代码实现（了解）
		
		//得到sessionFactory
//		SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
//		//得到session对象
//		Session session = sessionFactory.getCurrentSession();
//		//设置分页信息
//		Query query = session.createQuery("from Customer");
//		query.setFirstResult(begin);
//		query.setMaxResults(pageSize);
//		List<Customer> list = query.list();
		
		
		//第二种 使用离线对象和hibernateTemplate的方法实现
		//1 创建离线对象，设置对哪个实体类进行操作
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		criteria.add(Restrictions.eq("cust_flag", 1));
		
		//也可以通过离线对象实现查询记录总数的功能
//		criteria.setProjection(Projections.rowCount());
		
		//2 调用hibernateTemplate的方法实现
		
//		第一个是离线对象
//		第二个是开始位置
//		第三个是每页记录数
		List<Customer> list = 
				(List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		
		return list;
	}

	//条件查询
	@SuppressWarnings("unchecked")
	public List<Customer> findCondition(Customer customer) {
		//第一种方式：
		//得到sessionFactory
//		SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
//		//得到session对象
//		Session session = sessionFactory.getCurrentSession();
//		
//		Query query = session.createQuery("from Customer where cust_name like ?");
//		query.setParameter(0, "%"+customer.getCust_name()+"%");
//		List<Customer> list = query.list();
		
		//第二种方式：调用hibernateTemplate中的find方法实现
//		List<Customer> list = (List<Customer>) this.getHibernateTemplate().//
//				find("from Customer where cust_name like ?", "%"+customer.getCust_name()+"%");
		
		//第三种方式：
		//1 创建离线对象，设置对哪个实体类进行操作
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		
		//2 设置对实体类中的那个属性进行限制
		criteria.add(Restrictions.like("cust_name", "%"+customer.getCust_name()+"%"));
		
		//3 调用hibernateTemplate里面的方法得到list集合
		List<Customer> list = 
				(List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);
		
		return list;
	}

	//使用离线对象方式实现多条件组合查询
	@SuppressWarnings("all")
	public List<Customer> findMoreCondition(Customer customer) {
		//创建离线对象，指定对哪个实体类进行操作
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		
		//判断条件值是否为空
		//客户名称
		if (customer.getCust_name() != null && !"".equals(customer.getCust_name())) {
			criteria.add(Restrictions.eq("cust_name", customer.getCust_name()));
		}
		//客户编号
		if (customer.getCust_no() != null && !"".equals(customer.getCust_no())) {
			criteria.add(Restrictions.eq("cust_no", customer.getCust_no()));
		}
		//客户地区
		if (customer.getCust_region() != 0) {
			criteria.add(Restrictions.eq("cust_region", customer.getCust_region()));
		}
		//客户经理/负责人
		if (customer.getCust_manager_name() != null && !"".equals(customer.getCust_manager_name())) {
			criteria.add(Restrictions.eq("cust_manager_name", customer.getCust_manager_name()));
		}
		//客户等级
		if (customer.getCust_level() != 0) {
			criteria.add(Restrictions.eq("cust_level", customer.getCust_level()));
		}
		return (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);
	}

	//根据客户地区统计
	public List findCountManager() {
		//因为要写复杂SQL语句，建议直接调用底层SQL实现
		//SQLquery对象
		//1 得到SessionFactory对象
//		this.getHibernateTemplate().getSessionFactory();或者
		Session session = this.getSessionFactory().getCurrentSession();
		//2 创建SQLQuery对象
		SQLQuery sqlQuery = session.createSQLQuery(
				"SELECT COUNT(*) as num, cust_manager_name FROM cust_customer GROUP BY cust_manager_name");
		
		/*
		 * 因为返回值有两个字段，一个字段是id，一个是名称，
		 * 所以把返回数据转换成map结构
		 */
		sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		
		//调用方法得到结果
		//返回list，默认每部分是数组形式
		List list = sqlQuery.list();
		return list;
	}

	
	
	//根据客户级别统计
	public List findCountLevel() {
		//获取session对象
		Session session = this.getSessionFactory().getCurrentSession();
		//创建SQLQuery对象
		SQLQuery sqlQuery = session.createSQLQuery(
				"SELECT b.basi_item, c.num FROM (SELECT cust_level, COUNT(*) num FROM cust_customer GROUP BY cust_level) c, basic_dictionary b WHERE c.cust_level = b.basi_value AND b.basi_type='企业客户等级'");
		//得到结果
		//转换map结构
		sqlQuery.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		List list = sqlQuery.list();
		return list;
	}

	@SuppressWarnings("all")
	public int findMultiQueryCount(Customer customer) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		criteria.add(Restrictions.eq("cust_flag", 1));
		if (customer.getCust_name() != null && !"".equals(customer.getCust_name())) {
			criteria.add(Restrictions.like("cust_name", customer.getCust_name()));
		}
		if (customer.getCust_no() != null && !"".equals(customer.getCust_no())) {
			criteria.add(Restrictions.like("cust_no", customer.getCust_no()));
		}
		if (customer.getCust_region() != 0 && !"".equals(customer.getCust_region())) {
			criteria.add(Restrictions.eq("cust_region", customer.getCust_region()));
		}
		if (customer.getCust_manager_name() != null && !"".equals(customer.getCust_manager_name())) {
			criteria.add(Restrictions.like("cust_manager_name", customer.getCust_manager_name()));
		}
		if (customer.getCust_level() != 0 && !"".equals(customer.getCust_level())) {
			criteria.add(Restrictions.eq("cust_level", customer.getCust_level()));
		}
		
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria);
		if (list != null && list.size() != 0) {
			int count = list.size();
			return count;
		}
		return 0;
	}

	@SuppressWarnings("all")
	public List<Customer> multiQuery(Customer customer, int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Customer.class);
		criteria.add(Restrictions.eq("cust_flag", 1));
		if (customer.getCust_name() != null && !"".equals(customer.getCust_name())) {
			criteria.add(Restrictions.like("cust_name", customer.getCust_name()));
		}
		if (customer.getCust_no() != null && !"".equals(customer.getCust_no())) {
			criteria.add(Restrictions.like("cust_no", customer.getCust_no()));
		}
		if (customer.getCust_region() != 0 && !"".equals(customer.getCust_region())) {
			criteria.add(Restrictions.eq("cust_region", customer.getCust_region()));
		}
		if (customer.getCust_manager_name() != null && !"".equals(customer.getCust_manager_name())) {
			criteria.add(Restrictions.like("cust_manager_name", customer.getCust_manager_name()));
		}
		if (customer.getCust_level() != 0 && !"".equals(customer.getCust_level())) {
			criteria.add(Restrictions.eq("cust_level", customer.getCust_level()));
		}
		
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		
		return list;
	}

	
	public CustLinkMan findLinkMans(String cust_no, String link_no) {
		Customer customer = findOne(cust_no);
		
		Set<CustLinkMan> set = customer.getCustLinkMans();
		
		CustLinkMan linkMan = null;
		for (CustLinkMan custLinkMan : set) {
			if (custLinkMan.getLink_no().equals(link_no)) {
				linkMan = custLinkMan;
			}
		}
		
		return linkMan;
	}

	@Override
	public void deleteLinkMan(String cust_no, String link_no) {
		
		Customer customer = findOne(cust_no);
		
		Set<CustLinkMan> set = customer.getCustLinkMans();
		
		for (CustLinkMan custLinkMan : set) {
			if (custLinkMan.getLink_no().equals(link_no)) {
				custLinkMan.setLink_flag(0);
				this.getHibernateTemplate().update(custLinkMan);
			}
		}
		
	}

	@Override
	public CommunicateRecord findCommunicateRecord(String cust_no, String comm_no) {
		Customer customer = findOne(cust_no);
		
		Set<CommunicateRecord> setCommunicateRecords = customer.getCommunicateRecords();
		
		CommunicateRecord communicateRecord = null;
		for (CommunicateRecord communicateRecord1 : setCommunicateRecords) {
			if (communicateRecord1.getComm_no().equals(comm_no)) {
				communicateRecord = communicateRecord1;
			}
		}
		
		return communicateRecord;
	}

	@Override
	public void deleteCommunicateRecord(String cust_no, String comm_no) {
		
		Customer customer = findOne(cust_no);
		
		Set<CommunicateRecord> setRecords = customer.getCommunicateRecords();
		
		for (CommunicateRecord communicateRecord : setRecords) {
			if (communicateRecord.getComm_no().equals(comm_no)) {
				communicateRecord.setComm_flag(0);
				this.getHibernateTemplate().update(communicateRecord);
			}
		}
	}

	@Override
	public Orders findOrder(String cust_no, Integer orde_no) {
		Customer customer = findOne(cust_no);
		
		Set<Orders> orders = customer.getOrders();
		
		Orders orders2 = null;
		for (Orders orders3 : orders) {
			if (orders3.getOrde_no().equals(orde_no)) {
				orders2 = orders3;
			}
		}
		return orders2;
	}

	@Override
	public Double getTotalMoney(String cust_no, Integer orde_no) {
		
		Double totalMoney = 0.0;
		
		Customer customer = findOne(cust_no);
		Set<Orders> setOrders = customer.getOrders();
		Orders entityOrders = null;
		for (Orders orders : setOrders) {
			if (orders.getOrde_no().equals(orde_no)) {
				entityOrders = orders;
			}
		}
		
		Set<OrdersLine> ordersLines = entityOrders.getOrdersLines();
		for (OrdersLine ordersLine : ordersLines) {
			totalMoney += Double.valueOf(ordersLine.getProduct().getProd_price()) * ordersLine.getLine_count();
		}
		return totalMoney;
	}

	@SuppressWarnings("all")
	public Map<String, String> getCustomers() {
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer where cust_flag = 1");
		Map<String, String> map = new HashMap<String, String>();
		for (Customer customer : list) {
			map.put(customer.getCust_no(), customer.getCust_name());
		}
		return map;
	}

	@SuppressWarnings("all")
	public Map<String, Double> getCustTotalMoney() {
		List<Customer> list = (List<Customer>) this.getHibernateTemplate().find("from Customer where cust_flag = 1");
		Map<String, Double> map = new HashMap<String, Double>();
		Double orderMoney = 0.0d;
		Double lineMoney = 0.0d;
		
		for (Customer customer : list) {
			Set<Orders> ordersSet = customer.getOrders();
			if (ordersSet != null && ordersSet.size() != 0) {
				for (Orders orders : ordersSet) {
					Set<OrdersLine> ordersLines = orders.getOrdersLines();
					if (ordersLines != null && ordersLines.size() != 0) {
						for (OrdersLine ordersLine : ordersLines) {
							if (ordersLine.getLine_count() != null && ordersLine.getProduct().getProd_price() != null && !"".equals(ordersLine.getProduct().getProd_price())) {
								lineMoney += ordersLine.getLine_count() * Double.valueOf(ordersLine.getProduct().getProd_price());
							}
						}
						orderMoney += lineMoney;
					}
				}
				map.put(customer.getCust_no(), orderMoney);
			}
		}
		return map;
	}

	
	//多条件组合查询:使用拼接hql语句
	/*@SuppressWarnings("unchecked")
	public List<Customer> findMoreCondition(Customer customer) {
		//使用hibernate模板里面的find方法实现
		//拼接hql语句
		String hql = "from Customer where 1=1 ";
		
		//创建list集合，如果值不为空，把值设置到list里面
		List<Object> p = new ArrayList<Object>();
		
		//判断条件值是否为空，如果不为空拼接hql语句
		if (customer.getCust_name() != null && !"".equals(customer.getCust_name())) {
			//拼接hql语句
			hql += "and cust_name = ?";
			
			//把值设置到list集合里面
			p.add(customer.getCust_name());
		}
		if (customer.getCust_manager_name() != null && !"".equals(customer.getCust_manager_name())) {
			hql += "and cust_manager_name = ?";
			p.add(customer.getCust_manager_name());
		}
		if (customer.getCust_address() != null && !"".equals(customer.getCust_address())) {
			hql += "and cust_address = ?";
			p.add(customer.getCust_address());
		}
		
//		System.out.println("hql:  "+hql);
//		System.out.println("list: "+p);
		
		return (List<Customer>) this.getHibernateTemplate().find(hql, p.toArray());
	}*/

}
