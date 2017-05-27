package cn.crm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.crm.dao.StorageDAO;
import cn.crm.entity.Storage;

public class StorageDAOImpl extends HibernateDaoSupport implements StorageDAO{

	@SuppressWarnings("all")
	public int findCount() {
		List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from Storage where stor_flag = 1");
		if (list != null && list.size() != 0) {
			Object object = list.get(0);
			Long lobj = (Long) object;
			int count = lobj.intValue();
			return count;
		}
		return 0;
	}

	@SuppressWarnings("all")
	public List<Storage> listPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Storage.class);
		List<Storage> list = (List<Storage>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@SuppressWarnings("all")
	public List<Storage> multiQuery(Storage storage) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Storage.class);
		
		if (storage.getProduct().getProd_no() != null) {
			criteria.add(Restrictions.eq("product.prod_no", storage.getProduct().getProd_no()));
		}
		
		if (storage.getStor_storehouse() != null && !"".equals(storage.getStor_storehouse())) {
			criteria.add(Restrictions.like("stor_storehouse", "%"+storage.getStor_storehouse()+"%"));
		}
		
		List<Storage> list = (List<Storage>) this.getHibernateTemplate().findByCriteria(criteria);
		return list;
	}

}
