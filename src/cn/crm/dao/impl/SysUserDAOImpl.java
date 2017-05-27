package cn.crm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.crm.dao.SysUserDAO;
import cn.crm.entity.SysUser;
import cn.crm.utils.HibernateUtils;

public class SysUserDAOImpl extends HibernateDaoSupport implements SysUserDAO{
	//验证用户是否存在
	@SuppressWarnings("all")
	public SysUser loginUser(SysUser user) {
		
		List<SysUser> list = (List<SysUser>) this.getHibernateTemplate().
				find("from SysUser where user_name = ? and user_password = ?", user.getUser_name(), user.getUser_password());
		
		if (list != null && list.size() != 0) {
			return list.get(0);
		}
		
		return null;
	}

	//查询所有用户
	@SuppressWarnings("unchecked")
	public List<SysUser> findAll() {
		return (List<SysUser>) this.getHibernateTemplate().find("from SysUser");
	}

	
	//查询记录数
	@SuppressWarnings("all")
	public int findCount() {
		//调用hibernateTemplate里面的find方法
		List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from SysUser where user_flag = 1");
		
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
	@SuppressWarnings("all")
	public List<SysUser> findPage(int begin, int pageSize) {
		//第一种 使用hibernate底层代码实现（了解）
		SessionFactory sessionFactory = this.getHibernateTemplate().getSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		List<SysUser> list =  session.createQuery("from SysUser where user_flag = 1")
				.setFirstResult(begin)
				.setMaxResults(pageSize)
				.list();
		
		return list;
	}

	//根据用户编号查询
	public SysUser findOne(Integer user_id) {
		return this.getHibernateTemplate().get(SysUser.class, user_id);
	}

	@Override
	public void update(SysUser user) {
		this.getHibernateTemplate().update(user);
	}

	@Override
	public void add(SysUser user) {
		this.getHibernateTemplate().save(user);
	}

	@SuppressWarnings("all")
	public List<SysUser> multiQuery(SysUser user) {
		DetachedCriteria criteria = DetachedCriteria.forClass(SysUser.class);
		if (user.getUser_id() != null && 0 != user.getUser_id()) {
			criteria.add(Restrictions.eq("user_id", user.getUser_id()));
		}
		if (user.getUser_name() != null && !"".equals(user.getUser_name())) {
			criteria.add(Restrictions.eq("user_name", user.getUser_name()));
		}
		List<SysUser> list = (List<SysUser>) this.getHibernateTemplate().findByCriteria(criteria);
		
		return list;
	}

}
