package cn.crm.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.crm.dao.LinkManDAO;
import cn.crm.entity.CustLinkMan;

public class LinkManDAOImpl extends HibernateDaoSupport implements LinkManDAO {

	//添加联系人的方法
	public void add(CustLinkMan custLinkMan) {
		this.getHibernateTemplate().save(custLinkMan);
	}

	//联系人列表的方法
	@SuppressWarnings("unchecked")
	public List<CustLinkMan> list() {
		
		return (List<CustLinkMan>) this.getHibernateTemplate().find("from CustLinkMan");
	}

	//根据id查询联系人
	public CustLinkMan findOne(String link_no) {
		return this.getHibernateTemplate().get(CustLinkMan.class, link_no);
	}

	//修改联系人的方法
	public void update(CustLinkMan custLinkMan) {
		this.getHibernateTemplate().update(custLinkMan);
	}

	//多条件组合查询-hql语句拼接方式实现
	@SuppressWarnings("all")
//	public List<CustLinkMan> findCondition(CustLinkMan custLinkMan) {
//		String hql = "from CustLinkMan where 1=1 ";
//		List<Object> p = new ArrayList<Object>();
//		//判断条件值是否为空
//		if (custLinkMan.getLink_name() != null && !"".equals(custLinkMan.getLink_name())) {
//			hql += " and link_name = ?";
//			p.add(custLinkMan.getLink_name());
//		}
//		//判断是否选择客户
//		if (custLinkMan.getLink_cust_no().getCust_no() != null && !"0".equals(custLinkMan.getLink_cust_no().getCust_no())) {
//			hql += " and link_cust_no.cust_no = ?";
//			p.add(custLinkMan.getLink_cust_no().getCust_no());
//		}
//		return (List<CustLinkMan>) this.getHibernateTemplate().find(hql, p.toArray());
//	}
	
	
	//多条件组合查询-离线对象方式实现
	public List<CustLinkMan> findCondition(CustLinkMan custLinkMan) {
		// 创建离线对象
		DetachedCriteria criteria = DetachedCriteria.forClass(CustLinkMan.class);
		//判断条件值是否为空
		if (custLinkMan.getLink_name() != null && !"".equals(custLinkMan.getLink_name())) {
			criteria.add(Restrictions.eq("link_name", custLinkMan.getLink_name()));
		}
		//判断是否选择客户
		if (custLinkMan.getLink_cust_no().getCust_no() != null && !"0".equals(custLinkMan.getLink_cust_no().getCust_no())) {
			criteria.add(Restrictions.eq("customer.cust_no", custLinkMan.getLink_cust_no().getCust_no()));
		}
		
		return (List<CustLinkMan>) this.getHibernateTemplate().findByCriteria(criteria);
	}
}
