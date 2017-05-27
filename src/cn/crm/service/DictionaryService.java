package cn.crm.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import cn.crm.dao.DictionaryDAO;
import cn.crm.entity.BasicDictionary;
import cn.crm.entity.PageBean;

@Transactional
public class DictionaryService {

	private DictionaryDAO dictionaryDAO;
	public void setDictionaryDAO(DictionaryDAO dictionaryDAO) {
		this.dictionaryDAO = dictionaryDAO;
	}
	
	//查询客户涉及的所有地区信息（编号和名称）
	public Map<String, String> getRegions(){
		return dictionaryDAO.getRegions();
	}

	//查询客户涉及的所有等级信息（编号和名称）
	public Map<String, String> getLevels() {
		return dictionaryDAO.getLevels();
	}
	
	//查询客户涉及的所有服务类型信息（编号和名称）
	public Map<String, String> getServices() {
		return dictionaryDAO.getServices();
	}

	public PageBean listPageCustLevel(Integer currentPage) {
		
		if (currentPage == null || currentPage == 0) {
			currentPage = 1;
		}
		// 创建PageBean对象
		PageBean pageBean = new PageBean();
		// 当前页
		pageBean.setCurrentPage(currentPage);
		
		// 总记录数
		int totalCount = dictionaryDAO.findCustLevelCount();
		pageBean.setTotalCount(totalCount);

		// 每页显示记录数
		int pageSize = 5;
		pageBean.setPageSize(pageSize);

		// 总页数
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		//开始位置
		int begin = (currentPage - 1)* pageSize;
		pageBean.setBegin(begin);
		
		//每页记录的list集合
		List<BasicDictionary> list = dictionaryDAO.getListPageCustLevel(begin, pageSize);
		
		pageBean.setList(list);
		
		return pageBean;
	}

	public BasicDictionary findOne(Integer basi_no) {
		return dictionaryDAO.findOne(basi_no);
	}

	public void update(BasicDictionary dictionary) {
		dictionaryDAO.update(dictionary);
	}

	public int getMaxCustLevel() {
		return dictionaryDAO.getMaxCustLevel();
	}

	public void add(BasicDictionary dictionary) {
		dictionaryDAO.add(dictionary);
	}

	public PageBean listPageServiceType(Integer currentPage) {
		if (currentPage == null || currentPage == 0) {
			currentPage = 1;
		}
		// 创建PageBean对象
		PageBean pageBean = new PageBean();
		// 当前页
		pageBean.setCurrentPage(currentPage);
		
		// 总记录数
		int totalCount = dictionaryDAO.findServiceTypeCount();
		pageBean.setTotalCount(totalCount);

		// 每页显示记录数
		int pageSize = 5;
		pageBean.setPageSize(pageSize);

		// 总页数
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		//开始位置
		int begin = (currentPage - 1)* pageSize;
		pageBean.setBegin(begin);
		
		//每页记录的list集合
		List<BasicDictionary> list = dictionaryDAO.getListPageServiceType(begin, pageSize);
		
		pageBean.setList(list);
		
		return pageBean;
	}

	public int getMaxServiceType() {
		return dictionaryDAO.getMaxServiceType();
	}

	public PageBean listPageCustRegion(Integer currentPage) {
		if (currentPage == null || currentPage == 0) {
			currentPage = 1;
		}
		// 创建PageBean对象
		PageBean pageBean = new PageBean();
		// 当前页
		pageBean.setCurrentPage(currentPage);
		
		// 总记录数
		int totalCount = dictionaryDAO.findCustRegionCount();
		pageBean.setTotalCount(totalCount);

		// 每页显示记录数
		int pageSize = 5;
		pageBean.setPageSize(pageSize);

		// 总页数
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		//开始位置
		int begin = (currentPage - 1)* pageSize;
		pageBean.setBegin(begin);
		
		//每页记录的list集合
		List<BasicDictionary> list = dictionaryDAO.getListPageCustRegion(begin, pageSize);
		
		pageBean.setList(list);
		
		return pageBean;
	}

	public int getMaxCustRegion() {
		return dictionaryDAO.getMaxCustRegion();
	}

	public Map<String, String> getCredits() {
		return dictionaryDAO.getCredits();
	}

	public Map<String, String> getSatisfies() {
		return dictionaryDAO.getSatisfies();
	}
}
