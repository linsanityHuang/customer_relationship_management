package cn.crm.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.crm.dao.SalePlanDAO;
import cn.crm.entity.SalePlan;

public class SalePlanDAOImpl extends HibernateDaoSupport implements SalePlanDAO{

	
	@SuppressWarnings("all")
	public int findCount() {
		List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from SalePlan where plan_flag = 1");
		
		if (list != null && list.size() != 0) {
			Object object = list.get(0);
			Long lobj = (Long) object;
			int count = lobj.intValue();
			return count;
		}
		return 0;
	}

	@SuppressWarnings("all")
	public List<SalePlan> listPage(int begin, int pageSize) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(SalePlan.class);
		criteria.add(Restrictions.eq("plan_flag", 1));
		
		List<SalePlan> list = (List<SalePlan>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		
		return list;
	}

	
	@SuppressWarnings("all")
	public List<SalePlan> multiQuery(SalePlan salePlan) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SalePlan.class);
		
		if (salePlan.getSaleChance().getChan_cust_name() != null && !"".equals(salePlan.getSaleChance().getChan_cust_name())) {
			criteria.add(Restrictions.like("saleChance.chan_cust_name", "%"+salePlan.getSaleChance().getChan_cust_name()+"%"));
		}
		if (salePlan.getSaleChance().getChan_linkman() != null && !"".equals(salePlan.getSaleChance().getChan_linkman())) {
			criteria.add(Restrictions.like("saleChance.chan_linkman", salePlan.getSaleChance().getChan_linkman()));
		}
		if (salePlan.getSaleChance().getChan_title() != null && !"".equals(salePlan.getSaleChance().getChan_title())) {
			criteria.add(Restrictions.like("saleChance.chan_title", salePlan.getSaleChance().getChan_title()));
		}
		
		List<SalePlan> list = (List<SalePlan>) this.getHibernateTemplate().findByCriteria(criteria);
		
		return list;
	}

	@Override
	public SalePlan findOne(Integer plan_no) {
		return this.getHibernateTemplate().get(SalePlan.class, plan_no);
	}

	@Override
	public void update(SalePlan salePlan) {
		this.getHibernateTemplate().update(salePlan);
	}

	@Override
	public Serializable save(SalePlan salePlan) {
		return this.getHibernateTemplate().save(salePlan);
	}

	@Override
	public SalePlan get(Serializable plan_no) {
		return this.getHibernateTemplate().get(SalePlan.class, plan_no);
	}
	
}
