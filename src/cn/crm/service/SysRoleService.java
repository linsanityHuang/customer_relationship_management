package cn.crm.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import cn.crm.dao.SysRoleDAO;
import cn.crm.entity.PageBean;
import cn.crm.entity.SysRole;

@Transactional
public class SysRoleService {

	private SysRoleDAO dao;
	public void setDao(SysRoleDAO dao) {
		this.dao = dao;
	}
	public Map<Integer, String> getAllRoles() {
		return dao.getAllRoles();
	}
	
	public PageBean listPage(Integer currentPage) {
		
		if (currentPage == null) {
			currentPage = 1;
		}
		
		// 创建PageBean对象
		PageBean pageBean = new PageBean();
		// 当前页
		pageBean.setCurrentPage(currentPage);
		
		// 总记录数
		int totalCount = dao.findCount();
		pageBean.setTotalCount(totalCount);

		// 每页显示记录数
		int pageSize = 3;
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
		List<SysRole> list = dao.findPage(begin, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}
	public SysRole findOne(Integer role_id) {
		return dao.findOne(role_id);
	}
	
}
