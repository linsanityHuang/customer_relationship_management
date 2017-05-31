package cn.crm.dao.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.crm.dao.ServiceManagerDAO;
import cn.crm.entity.ServiceManager;

public class ServiceManagerDAOImpl extends HibernateDaoSupport implements ServiceManagerDAO {

	@Override
	public void save(ServiceManager serviceManager) {
		this.getHibernateTemplate().save(serviceManager);
	}

	@SuppressWarnings("all")
	public int findCount() {
		List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from ServiceManager where serv_flag = 1");
		if (list != null && list.size() != 0) {
			Long lobj = (Long) list.get(0);
			int count = lobj.intValue();
			return count;
		}
		return 0;
	}

	@SuppressWarnings("all")
	public List<ServiceManager> listPage(int begin, int pageSize) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(ServiceManager.class);
		
		criteria.add(Restrictions.eq("serv_flag", 1));
		
		List<ServiceManager> list = (List<ServiceManager>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		
		return list;
	}

	
	@SuppressWarnings("all")
	public int findCount2Handle() {
		List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from ServiceManager where serv_flag = 1 and serv_status = 2");
		if (list != null && list.size() != 0) {
			Long lobj = (Long) list.get(0);
			int count = lobj.intValue();
			return count;
		}
		return 0;
	}

	
	@SuppressWarnings("all")
	public List<ServiceManager> listPage2Handle(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ServiceManager.class);
		
		criteria.add(Restrictions.eq("serv_flag", 1));
		criteria.add(Restrictions.eq("serv_status", 2));
		
		List<ServiceManager> list = (List<ServiceManager>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		
		return list;
	}
	
	@SuppressWarnings("all")
	public int findCount2FeedBack() {
		List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from ServiceManager where serv_flag = 1 and serv_status = 3");
		if (list != null && list.size() != 0) {
			Long lobj = (Long) list.get(0);
			int count = lobj.intValue();
			return count;
		}
		return 0;
	}

	@SuppressWarnings("all")
	public List<ServiceManager> listPage2FeedBack(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ServiceManager.class);
		
		criteria.add(Restrictions.eq("serv_flag", 1));
		criteria.add(Restrictions.eq("serv_status", 3));
		
		List<ServiceManager> list = (List<ServiceManager>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		
		return list;
	}
	
	@SuppressWarnings("all")
	public int findCount2File() {
		List<Object> list = (List<Object>) this.getHibernateTemplate().find("select count(*) from ServiceManager where serv_flag = 1 and serv_status = 5");
		if (list != null && list.size() != 0) {
			Long lobj = (Long) list.get(0);
			int count = lobj.intValue();
			return count;
		}
		return 0;
	}

	@SuppressWarnings("all")
	public List<ServiceManager> listPage2File(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(ServiceManager.class);
		
		criteria.add(Restrictions.eq("serv_flag", 1));
		criteria.add(Restrictions.eq("serv_status", 5));
		
		List<ServiceManager> list = (List<ServiceManager>) this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		
		return list;
	}
	
	
	@SuppressWarnings("all")
	public List<String> getDuetoManagers() {
		List<ServiceManager> entityList = (List<ServiceManager>) this.getHibernateTemplate().find("from ServiceManager");
		List<String> managerList = new ArrayList<String>();
		for (ServiceManager entity : entityList) {
			if (!"".equals(entity.getServ_due_to())) {
				managerList.add(entity.getServ_due_to());
			}
		}
		return managerList;
	}

	@Override
	public ServiceManager findOne(String serv_no) {
		return this.getHibernateTemplate().get(ServiceManager.class, serv_no);
	}

	@Override
	public void update(ServiceManager serviceManager) {
		serviceManager.setServ_status(2);
		String datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		serviceManager.setServ_due_date(datetime);
		this.getHibernateTemplate().update(serviceManager);
	}

	@Override
	public void delete(ServiceManager serviceManager) {
		serviceManager.setServ_flag(0);
		this.getHibernateTemplate().update(serviceManager);
	}

	@Override
	public void updateHandleService2db(ServiceManager serviceManager) {
		serviceManager.setServ_status(3);
		this.getHibernateTemplate().update(serviceManager);
	}

	@Override
	public void updateFeedBackService(ServiceManager serviceManager) {
		if (serviceManager.getServ_satisfy() >= 3) {
			serviceManager.setServ_status(5);
		} else {
			serviceManager.setServ_status(2);
		}
		
		this.getHibernateTemplate().update(serviceManager);
	}
}
