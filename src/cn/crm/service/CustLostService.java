package cn.crm.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.crm.dao.CustLostDAO;
import cn.crm.entity.CustLost;
import cn.crm.entity.PageBean;

@Transactional
public class CustLostService {

	private CustLostDAO custLostDAO;
	public void setCustLostDAO(CustLostDAO custLostDAO) {
		this.custLostDAO = custLostDAO;
	}
	
	public PageBean listPage(Integer currentPage) {
		if (currentPage == null) {
			currentPage = 1;
		}
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage);
		
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		
		int totalCount = custLostDAO.findTotalCount();
		pageBean.setTotalCount(totalCount);
		
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		int begin = (currentPage - 1) * pageSize;
		pageBean.setBegin(begin);
		
		List<CustLost> list = custLostDAO.listPage(begin, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	public List<CustLost> multiQuery(CustLost custLost) {
		return custLostDAO.multiQuery(custLost);
	}

	public CustLost findOne(Integer lost_no) {
		return custLostDAO.findOne(lost_no);
	}

	public void update(CustLost custLost) {
		custLostDAO.update(custLost);
	}
}
