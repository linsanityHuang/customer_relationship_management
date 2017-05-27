package cn.crm.dao.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.crm.dao.DictionaryDAO;
import cn.crm.entity.BasicDictionary;

public class DictionaryDAOImpl extends HibernateDaoSupport implements DictionaryDAO {
	
	
	@SuppressWarnings("all")
	public Map<String, String> getCredits() {
		List<BasicDictionary> list = (List<BasicDictionary>) this.getHibernateTemplate().find("from BasicDictionary where basi_flag = 1 and basi_type = '客户信誉程度'");
		
		Map<String, String> map = new HashMap<String, String>();
		
		for (BasicDictionary basicDictionary : list) {
			map.put(basicDictionary.getBasi_value(), basicDictionary.getBasi_item());
		}
		
		return map;
	}

	
	@SuppressWarnings("all")
	public Map<String, String> getSatisfies() {
		List<BasicDictionary> list = (List<BasicDictionary>) this.getHibernateTemplate().find("from BasicDictionary where basi_flag = 1 and basi_type = '客户满意程度'");
		
		Map<String, String> map = new HashMap<String, String>();
		
		for (BasicDictionary basicDictionary : list) {
			map.put(basicDictionary.getBasi_value(), basicDictionary.getBasi_item());
		}
		
		return map;
	}

	//获取字典表中关于地区的数据
	@SuppressWarnings("all")
	public Map<String, String> getRegions() {
		List<BasicDictionary> list = (List<BasicDictionary>) this.getHibernateTemplate().find("from BasicDictionary where basi_flag = 1 and basi_type = '地区'");
		
		Map<String, String> map = new HashMap<String, String>();
		
		for (BasicDictionary basicDictionary : list) {
			map.put(basicDictionary.getBasi_value(), basicDictionary.getBasi_item());
		}
		
		return map;
	}

	//查询客户涉及的所有等级信息（编号和名称）
	@SuppressWarnings("all")
	public Map<String, String> getLevels() {
		List<BasicDictionary> list = (List<BasicDictionary>) this.getHibernateTemplate().find("from BasicDictionary where basi_flag = 1 and basi_type = '企业客户等级'");
		
		Map<String, String> map = new HashMap<String, String>();
		
		for (BasicDictionary basicDictionary : list) {
			map.put(basicDictionary.getBasi_value(), basicDictionary.getBasi_item());
		}
		
		return map;
	}
	
	//查询客户涉及的所有服务类型信息（编号和名称）
		@SuppressWarnings("all")
		public Map<String, String> getServices() {
			List<BasicDictionary> list = (List<BasicDictionary>) this.getHibernateTemplate().find("from BasicDictionary where basi_flag = 1 and basi_type = '服务类型'");
			
			Map<String, String> map = new HashMap<String, String>();
			
			for (BasicDictionary basicDictionary : list) {
				map.put(basicDictionary.getBasi_value(), basicDictionary.getBasi_item());
			}
			
			return map;
		}

	@SuppressWarnings("all")
	public int findCustLevelCount() {
		
		List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from BasicDictionary where basi_type = '企业客户等级' and basi_flag = 1");
		if (list != null && list.size() != 0) {
			Object object = list.get(0);
			Long lobj = (Long) object;
			int count = lobj.intValue();
			return count;
		}
		return 0;
	}
	
	@SuppressWarnings("all")
	public int findCustRegionCount() {
		
		List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from BasicDictionary where basi_type = '地区' and basi_flag = 1");
		if (list != null && list.size() != 0) {
			Object object = list.get(0);
			Long lobj = (Long) object;
			int count = lobj.intValue();
			return count;
		}
		return 0;
	}
	
	@SuppressWarnings("all")
	public List<BasicDictionary> getListPageCustLevel(Integer begin, Integer pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(BasicDictionary.class);
		
		criteria.add(Restrictions.eq("basi_type", "企业客户等级"));
		criteria.add(Restrictions.eq("basi_flag", 1));
		
		List<BasicDictionary> list = (List<BasicDictionary>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		
		return list;
	}

	@Override
	public BasicDictionary findOne(Integer basi_no) {
		return this.getHibernateTemplate().get(BasicDictionary.class, basi_no);
	}

	@Override
	public void update(BasicDictionary dictionary) {
		this.getHibernateTemplate().update(dictionary);
	}

	@Override
	public int getMaxCustLevel() {
		SessionFactory sessionFactory = this.getSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		BigDecimal bigDecimal = (BigDecimal) session.createSQLQuery("SELECT max(to_number(regexp_substr(basi_value,'[0-9]+'))) from BASIC_DICTIONARY WHERE basi_type='企业客户等级'")
				.uniqueResult();
		
		if (bigDecimal != null) {
			int maxCustLevel = bigDecimal.intValue();
			return maxCustLevel;
		}
		return -1;
	}

	@Override
	public void add(BasicDictionary dictionary) {
		this.getHibernateTemplate().save(dictionary);
	}

	
	@SuppressWarnings("all")
	public int findServiceTypeCount() {
		
		List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from BasicDictionary where basi_type = '服务类型' and basi_flag = 1");
		if (list != null && list.size() != 0) {
			Object object = list.get(0);
			Long lobj = (Long) object;
			int count = lobj.intValue();
			return count;
		}
		return 0;
	}

	@SuppressWarnings("all")
	public List<BasicDictionary> getListPageServiceType(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(BasicDictionary.class);
		
		criteria.add(Restrictions.eq("basi_type", "服务类型"));
		criteria.add(Restrictions.eq("basi_flag", 1));
		
		List<BasicDictionary> list = (List<BasicDictionary>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		
		return list;
	}

	@Override
	public int getMaxServiceType() {
		SessionFactory sessionFactory = this.getSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		BigDecimal bigDecimal = (BigDecimal) session.createSQLQuery("SELECT max(to_number(regexp_substr(basi_value,'[0-9]+'))) from BASIC_DICTIONARY WHERE basi_type='服务类型'")
				.uniqueResult();
		
		if (bigDecimal != null) {
			int maxCustLevel = bigDecimal.intValue();
			return maxCustLevel;
		}
		return -1;
	}

	@SuppressWarnings("all")
	public List<BasicDictionary> getListPageCustRegion(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(BasicDictionary.class);
		
		criteria.add(Restrictions.eq("basi_type", "地区"));
		criteria.add(Restrictions.eq("basi_flag", 1));
		
		List<BasicDictionary> list = (List<BasicDictionary>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		
		return list;
	}

	@Override
	public int getMaxCustRegion() {
		SessionFactory sessionFactory = this.getSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		BigDecimal bigDecimal = (BigDecimal) session.createSQLQuery("SELECT max(to_number(regexp_substr(basi_value,'[0-9]+'))) from BASIC_DICTIONARY WHERE basi_type='地区'")
				.uniqueResult();
		
		if (bigDecimal != null) {
			int maxCustLevel = bigDecimal.intValue();
			return maxCustLevel;
		}
		return -1;
	}
}
