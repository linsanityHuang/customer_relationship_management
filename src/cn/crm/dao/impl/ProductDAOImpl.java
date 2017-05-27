package cn.crm.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.crm.dao.ProductDAO;
import cn.crm.entity.Product;

public class ProductDAOImpl extends HibernateDaoSupport implements ProductDAO {

	@SuppressWarnings("all")
	public int findCount() {
		List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from Product where prod_flag = 1");
		
		if (list != null && list.size() != 0) {
			Object object = list.get(0);
			Long lobj = (Long) object;
			int count = lobj.intValue();
			return count;
		}
		return 0;
	}

	@SuppressWarnings("all")
	public List<Product> findPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		
		criteria.add(Restrictions.eq("prod_flag", 1));
		
		List<Product> list = (List<Product>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		
		return list;
	}

	@SuppressWarnings("all")
	public List<Product> multiQuery(Product product) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
		
		if (product.getProd_name() != null && !"".equals(product.getProd_name())) {
			criteria.add(Restrictions.like("prod_name", "%"+product.getProd_name()+"%"));
		}
		
		if (product.getProd_type() != null && !"".equals(product.getProd_type())) {
			criteria.add(Restrictions.like("prod_type", "%"+product.getProd_type()+"%"));
		}
		
		if (product.getProd_garde_batch() != null && !"".equals(product.getProd_garde_batch())) {
			criteria.add(Restrictions.like("prod_garde_batch", "%"+product.getProd_garde_batch()+"%"));
		}
		
		List<Product> list = (List<Product>) this.getHibernateTemplate().findByCriteria(criteria);
		
		return list;
		
	}

}
