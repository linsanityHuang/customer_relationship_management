package cn.crm.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.crm.dao.SysUserDAO;
import cn.crm.entity.PageBean;
import cn.crm.entity.SysUser;
@Transactional
public class SysUserService {
	
	private SysUserDAO dao;
	public void setDao(SysUserDAO dao) {
		this.dao = dao;
	}

	//登录的方法
	public SysUser loginUser(SysUser user) {
		// TODO Auto-generated method stub
		return dao.loginUser(user);
	}


	public List<SysUser> findAll() {
		return dao.findAll();
	}
	
	//封装分页数据到pagebean对象里面
	public PageBean listPage(Integer currentPage) {
		
		//修改用户信息之后要跳转到分页列表页面，当前页数据传递不过来导致currentPage为null，因此，在这个地方判断
		if (currentPage == null) {
			currentPage = 1;
		}
		//创建pagebean对象
		PageBean pageBean = new PageBean();
		
		//设置当前页
		pageBean.setCurrentPage(currentPage);
		
		//获取总记录数
		int totalCount = dao.findCount();
		//设置总记录数
		pageBean.setTotalCount(totalCount);
		
		//设置每页显示的记录数
		int pageSize = 5;
		pageBean.setPageSize(pageSize);
		
		//获得总页数
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		
		//设置总页数
		
		pageBean.setTotalPage(totalPage);
		
		//开始位置
		int begin = (currentPage - 1) * pageSize;
		
		pageBean.setBegin(begin);
		
		//获取每页记录对应的list集合
		List<SysUser> list = dao.findPage(begin, pageSize);
		
		//设置每页记录
		pageBean.setList(list);
		
		return pageBean;
	}

	public SysUser findOne(Integer user_id) {
		return dao.findOne(user_id);
	}

	public void update(SysUser user) {
		dao.update(user);
	}

	public void add(SysUser user) {
		dao.add(user);
	}

	public List<SysUser> multiQuery(SysUser user) {
		return dao.multiQuery(user);
	}

}