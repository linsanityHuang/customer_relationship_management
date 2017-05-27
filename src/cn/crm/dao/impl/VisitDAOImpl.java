package cn.crm.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.crm.dao.VisitDAO;
import cn.crm.entity.Visit;

public class VisitDAOImpl extends HibernateDaoSupport implements VisitDAO{

	//添加客户拜访记录
	public void add(Visit visit) {
		this.getHibernateTemplate().save(visit);
	}

	//获取拜访列表
	@SuppressWarnings("unchecked")
	public List<Visit> findAll() {
		return (List<Visit>) this.getHibernateTemplate().find("from Visit");
	}

}
