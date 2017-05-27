package cn.crm.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.crm.dao.SaleChanceDAO;
import cn.crm.entity.PageBean;
import cn.crm.entity.SaleChance;

@Transactional
public class SaleChanceService {

	private SaleChanceDAO saleChanceDAO;
	public void setSaleChanceDAO(SaleChanceDAO saleChanceDAO) {
		this.saleChanceDAO = saleChanceDAO;
	}

	//根据页面传过来的currentPage数据得到分页信息
	public PageBean listpage(Integer currentPage) {
		
		//创建PageBean对象
		PageBean pageBean = new PageBean();
		
		//设置当前页
		pageBean.setCurrentPage(currentPage);
		
		//获得总记录数
		int totalCount = saleChanceDAO.findCount();
		pageBean.setTotalCount(totalCount);
		
		//设置每页显示记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		
		//总页数
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		//开始位置
		int begin = (currentPage - 1) * pageSize;
		pageBean.setBegin(begin);
		
		//每页记录的list集合
		List<SaleChance> list = saleChanceDAO.findPage(begin, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	public SaleChance findOne(Long chan_no) {
		return saleChanceDAO.findOne(chan_no);
	}

	public void update(SaleChance saleChance) {
		saleChanceDAO.update(saleChance);
	}

	public List<String> findAllCustManager() {
		return saleChanceDAO.findAllCustManager();
	}

	public void add(SaleChance saleChance) {
		saleChanceDAO.add(saleChance);
	}

	public PageBean multiQuery(SaleChance saleChance, Integer currentPage) {
		if (currentPage == null) {
			currentPage = 1;
		}
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage);
		
		int totalCount = saleChanceDAO.multiQueryCount(saleChance);
		pageBean.setTotalCount(totalCount);
		
		int pageSize = 2;
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
		
		List<SaleChance> list = saleChanceDAO.multiQueryResult(saleChance, begin, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

}
