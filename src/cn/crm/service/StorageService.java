package cn.crm.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.crm.dao.StorageDAO;
import cn.crm.entity.PageBean;
import cn.crm.entity.Storage;

@Transactional
public class StorageService {

	private StorageDAO storageDAO;
	public void setStorageDAO(StorageDAO storageDAO) {
		this.storageDAO = storageDAO;
	}
	public PageBean listPage(Integer currentPage) {
		if (currentPage == null) {
			currentPage = 1;
		}
		
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage);
		
		int totalCount = storageDAO.findCount();
		pageBean.setTotalCount(totalCount);
		
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		
		int begin = (currentPage - 1) * pageSize;
		pageBean.setBegin(begin);
		
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		
		pageBean.setTotalPage(totalPage);
		
		List<Storage> list = storageDAO.listPage(begin, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}
	public List<Storage> multiQuery(Storage storage) {
		return storageDAO.multiQuery(storage);
	}
}
