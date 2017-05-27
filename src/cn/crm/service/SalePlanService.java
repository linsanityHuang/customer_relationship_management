package cn.crm.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.crm.dao.SalePlanDAO;
import cn.crm.entity.PageBean;
import cn.crm.entity.SalePlan;

@Transactional
public class SalePlanService {

	private SalePlanDAO salePlanDAO;
	public void setSalePlanDAO(SalePlanDAO salePlanDAO) {
		this.salePlanDAO = salePlanDAO;
	}
	
	public PageBean listPage(Integer currentPage) {
		if (currentPage == null) {
			currentPage = 1;
		}
		
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage);
		
		int totalCount = salePlanDAO.findCount();
		pageBean.setTotalCount(totalCount);
		
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		int begin = (currentPage - 1) * pageSize;
		pageBean.setBegin(begin);
		
		List<SalePlan> list = salePlanDAO.listPage(begin, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	public List<SalePlan> multiQuery(SalePlan salePlan) {
		return salePlanDAO.multiQuery(salePlan);
	}

	public SalePlan findOne(Integer plan_no) {
		return salePlanDAO.findOne(plan_no);
	}

	public void update(SalePlan salePlan) {
		salePlanDAO.update(salePlan);
	}

	public Serializable save(SalePlan salePlan) {
		return salePlanDAO.save(salePlan);
	}

	public SalePlan get(Serializable plan_no) {
		return salePlanDAO.get(plan_no);
	}
}
