package cn.crm.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.crm.dao.SysRoleDAO;
import cn.crm.entity.Customer;
import cn.crm.entity.SysRole;

public class SysRoleDAOImpl extends HibernateDaoSupport implements SysRoleDAO{

	@SuppressWarnings("all")
	public Map<Integer, String> getAllRoles() {
		List<SysRole> list = (List<SysRole>) this.getHibernateTemplate().find("from SysRole");
		Map<Integer, String> map = new HashMap<Integer, String>();
		if (list != null && list.size() != 0) {
			for (SysRole sysRole : list) {
				map.put(sysRole.getRole_id(), sysRole.getRole_name());
			}
			return map;
		}
		return null;
	}

	@SuppressWarnings("all")
	public int findCount() {
		List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from SysRole where role_flag = 1");
		
		if (list != null && list.size() != 0) {
			Object object = list.get(0);
			Long lobj = (Long) object;
			int count = lobj.intValue();
			return count;
		}
		return 0;
	}

	@SuppressWarnings("all")
	public List<SysRole> findPage(int begin, int pageSize) {
		SessionFactory sessionFactory = this.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		List<SysRole> list = session.createQuery("from SysRole where role_flag = 1")
				.setFirstResult(begin)
				.setMaxResults(pageSize)
				.list();
		
		return list;
	}

	
	public SysRole findOne(Integer role_id) {
		return this.getHibernateTemplate().get(SysRole.class, role_id);
	}

}
