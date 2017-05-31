package cn.crm.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.crm.dao.ServiceManagerDAO;
import cn.crm.entity.PageBean;
import cn.crm.entity.ServiceManager;

@Transactional
public class ServiceManagerService {

	private ServiceManagerDAO serviceManagerDAO;
	public void setServiceManagerDAO(ServiceManagerDAO serviceManagerDAO) {
		this.serviceManagerDAO = serviceManagerDAO;
	}
	
	public void save(ServiceManager serviceManager) {
		serviceManagerDAO.save(serviceManager);
	}
	
	public PageBean listPage(Integer currentPage) {
		if (currentPage == null) {
			currentPage = 1;
		}
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage);
		
		int pageSize = 2;
		pageBean.setPageSize(pageSize);
		
		int begin = (currentPage - 1) * pageSize;
		pageBean.setBegin(begin);
		
		int totalCount = serviceManagerDAO.findCount();
		pageBean.setTotalCount(totalCount);
		
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		List<ServiceManager> list = serviceManagerDAO.listPage(begin, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	public List<String> getDuetoManagers() {
		return serviceManagerDAO.getDuetoManagers();
	}

	public ServiceManager findOne(String serv_no) {
		return serviceManagerDAO.findOne(serv_no);
	}

	public void update(ServiceManager serviceManager) {
		serviceManagerDAO.update(serviceManager);
	}

	public void delete(ServiceManager serviceManager) {
		serviceManagerDAO.delete(serviceManager);
	}

	public PageBean listPage2Handle(Integer currentPage) {
		if (currentPage == null) {
			currentPage = 1;
		}
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage);
		
		int pageSize = 2;
		pageBean.setPageSize(pageSize);
		
		int begin = (currentPage - 1) * pageSize;
		pageBean.setBegin(begin);
		
		int totalCount = serviceManagerDAO.findCount2Handle();
		pageBean.setTotalCount(totalCount);
		
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		List<ServiceManager> list = serviceManagerDAO.listPage2Handle(begin, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	public void updateHandleService2db(ServiceManager serviceManager) {
		serviceManagerDAO.updateHandleService2db(serviceManager);
	}

	public PageBean listPage2FeedBack(Integer currentPage) {
		if (currentPage == null) {
			currentPage = 1;
		}
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage);
		
		int pageSize = 2;
		pageBean.setPageSize(pageSize);
		
		int begin = (currentPage - 1) * pageSize;
		pageBean.setBegin(begin);
		
		int totalCount = serviceManagerDAO.findCount2FeedBack();
		pageBean.setTotalCount(totalCount);
		
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		List<ServiceManager> list = serviceManagerDAO.listPage2FeedBack(begin, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	public void updateFeedBackService(ServiceManager serviceManager) {
		serviceManagerDAO.updateFeedBackService(serviceManager);
	}

	public PageBean listPage2File(Integer currentPage) {
		if (currentPage == null) {
			currentPage = 1;
		}
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage);
		
		int pageSize = 2;
		pageBean.setPageSize(pageSize);
		
		int begin = (currentPage - 1) * pageSize;
		pageBean.setBegin(begin);
		
		int totalCount = serviceManagerDAO.findCount2File();
		pageBean.setTotalCount(totalCount);
		
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		List<ServiceManager> list = serviceManagerDAO.listPage2File(begin, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}
}
