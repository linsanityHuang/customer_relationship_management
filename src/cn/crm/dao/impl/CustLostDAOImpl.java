package cn.crm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.crm.dao.CustLostDAO;
import cn.crm.entity.CustLost;

public class CustLostDAOImpl extends HibernateDaoSupport implements CustLostDAO {

	@SuppressWarnings("all")
	public int findTotalCount() {
		List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from CustLost");
		
		if (list != null && list.size() != 0) {
			Long lobj = (Long) list.get(0);
			int count = lobj.intValue();
			return count;
		}
		return 0;
	}

	@SuppressWarnings("all")
	public List<CustLost> listPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(CustLost.class);
		List<CustLost> list = (List<CustLost>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@SuppressWarnings("all")
	public List<CustLost> multiQuery(CustLost custLost) {
		DetachedCriteria criteria = DetachedCriteria.forClass(CustLost.class);
		if (custLost.getLost_cust_no().getCust_name() != null && !"".equals(custLost.getLost_cust_no().getCust_name())) {
			criteria.add(Restrictions.like("lost_cust_no.cust_name", "%"+custLost.getLost_cust_no().getCust_name()+"%"));
		}
		if (custLost.getLost_manager_name() != null && !"".equals(custLost.getLost_manager_name())) {
			criteria.add(Restrictions.like("lost_manager_name", custLost.getLost_manager_name()));
		}
		if (custLost.getLost_status() != null && !"".equals(custLost.getLost_status()) && custLost.getLost_status() != 0) {
			criteria.add(Restrictions.eq("lost_status", custLost.getLost_status()));
		}
		
		List<CustLost> list = (List<CustLost>) this.getHibernateTemplate().findByCriteria(criteria);
		
		return list;
	}

	@Override
	public CustLost findOne(Integer lost_no) {
		return this.getHibernateTemplate().get(CustLost.class, lost_no);
	}

	@Override
	public void update(CustLost custLost) {
		this.getHibernateTemplate().update(custLost);
	}

}
