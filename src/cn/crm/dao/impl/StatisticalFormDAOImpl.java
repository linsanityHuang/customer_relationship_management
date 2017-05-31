package cn.crm.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.crm.dao.StatisticalFormDAO;

public class StatisticalFormDAOImpl extends HibernateDaoSupport implements StatisticalFormDAO{

	@SuppressWarnings("all")
	public List serviceAnalysis() {
		Session session = this.getSessionFactory().getCurrentSession();
		SQLQuery sqlQuery = (SQLQuery) session.createSQLQuery(
				"SELECT BASI_ITEM, NUM " +
				"FROM (SELECT serv_type, COUNT(*) as num FROM service_manager GROUP BY serv_type) s, basic_dictionary b " +
				"WHERE s.serv_type = b.basi_value AND b.basi_type='服务类型'")
				.setResultTransformer(Transformers.aliasToBean(HashMap.class));
		
		List list = sqlQuery.list();
		
		return list;
	}

}
