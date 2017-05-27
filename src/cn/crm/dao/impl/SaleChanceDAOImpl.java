package cn.crm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import oracle.net.aso.s;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.crm.dao.SaleChanceDAO;
import cn.crm.entity.SaleChance;

public class SaleChanceDAOImpl extends HibernateDaoSupport implements SaleChanceDAO{

	@SuppressWarnings("all")
	@Override
	public int findCount() {
		//调用hibernateTemplate里面的方法
		List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from SaleChance where chan_flag = 1 and chan_status = 0");
		
		//从list中把值得到
		if (list != null && list.size() != 0) {
			Object object = list.get(0);
			Long lonj = (Long) object;
			int count = lonj.intValue();
			return count;
		}
		return 0;
	}

	//分页查询操作
	@SuppressWarnings("all")
	public List<SaleChance> findPage(int begin, int pageSize) {
		
		//创建离线对象，设置对哪个实体类进行操作
//		DetachedCriteria criteria = DetachedCriteria.forClass(SaleChance.class);
		
		//调用hibernateTemplate的方法实现
//		List<SaleChance> list = (List<SaleChance>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		SessionFactory sessionFactory = this.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		
		List<SaleChance> list = session.createQuery("from SaleChance where chan_flag = 1 and chan_status = 0").setFirstResult(begin).setMaxResults(pageSize).list();
		
		return list;
	}

	@Override
	public SaleChance findOne(Long chan_no) {
		return this.getHibernateTemplate().get(SaleChance.class, chan_no);
	}

	@Override
	public void update(SaleChance saleChance) {
		this.getHibernateTemplate().update(saleChance);
	}

	//查询出所有的客户经理
	@SuppressWarnings("all")
	public List<String> findAllCustManager() {
		List<SaleChance> list = (List<SaleChance>) this.getHibernateTemplate().find("from SaleChance");
		List<String> listManager = new ArrayList<String>();
		for (SaleChance saleChance : list) {
			if (saleChance.getChan_due_to() != null && saleChance.getChan_due_to() != "") {
				listManager.add(saleChance.getChan_due_to());
			}
		}
		return listManager;
	}

	//新建销售信息的实际添加方法
	public void add(SaleChance saleChance) {
		this.getHibernateTemplate().save(saleChance);
	}

	
	@SuppressWarnings("all")
	public int multiQueryCount(SaleChance saleChance) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SaleChance.class);
		criteria.add(Restrictions.eq("chan_flag", 1));
		
		if (saleChance.getChan_cust_name() != null && !"".equals(saleChance.getChan_cust_name())) {
			criteria.add(Restrictions.like("chan_cust_name", "%"+saleChance.getChan_cust_name()+"%"));
		}
		
		if (saleChance.getChan_title() != null && !"".equals(saleChance.getChan_title())) {
			criteria.add(Restrictions.like("chan_title", "%"+saleChance.getChan_title()+"%"));
		}
		
		List<SaleChance> list = (List<SaleChance>) this.getHibernateTemplate().findByCriteria(criteria);
		if (list != null && list.size() != 0) {
			int count = list.size();
			return count;
		}
		return 0;
	}

	
	@SuppressWarnings("all")
	public List<SaleChance> multiQueryResult(SaleChance saleChance, int begin, int pageSize) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(SaleChance.class);
		criteria.add(Restrictions.eq("chan_flag", 1));
		if (saleChance.getChan_cust_name() != null && !"".equals(saleChance.getChan_cust_name())) {
			criteria.add(Restrictions.like("chan_cust_name", "%"+saleChance.getChan_cust_name()+"%"));
		}
		
		if (saleChance.getChan_title() != null && !"".equals(saleChance.getChan_title())) {
			criteria.add(Restrictions.like("chan_title", "%"+saleChance.getChan_title()+"%"));
		}
		
		List<SaleChance> list = (List<SaleChance>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		
		return list;
	}

}
