package cn.crm.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.crm.entity.PageBean;
import cn.crm.entity.SysUser;
import cn.crm.service.SysRoleService;
import cn.crm.service.SysUserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SysUserAction extends ActionSupport implements ModelDriven<SysUser>{

	//模型驱动方法，获取从页面封装到SysUser中的数据
	private SysUser user = new SysUser();
	
	public SysUser getModel() {
		// TODO Auto-generated method stub
		return user;
	}
	
	private SysUserService sysUserService;
	public void setSysUserService(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

	private SysRoleService roleService;
	public void setRoleService(SysRoleService roleService) {
		this.roleService = roleService;
	}
	//属性封装
//	private String user_name;
//	private String user_password;
//	public String getUser_name() {
//		return user_name;
//	}
//	public void setUser_name(String user_name) {
//		this.user_name = user_name;
//	}
//	public String getUser_password() {
//		return user_password;
//	}
//	public void setUser_password(String user_password) {
//		this.user_password = user_password;
//	}


	//登录的方法
	public String login(){
	
		SysUser isExist = sysUserService.loginUser(user);
		
		if (isExist != null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.getSession().setAttribute("user", isExist);
			
			return "success";
		} else {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("info", "登录验证失败，请重新登录！");
			
			return "failed";
		}
	}
	
	//退出系统
	public String loginOut() {
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		return "loginOut";
	}
	
	
//	系统管理员点击“用户管理”菜单，进入用户列表页面，操作依次显示“编辑”、
//	“删除”链接图片。点击“查询”按钮，可以根据编号、用户名进行筛选查询。列表
//	内容要求用分页显示。
	//使用属性封装获取当前页
	private Integer currentPage;
	
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
		
	public String listpage() {
		
		PageBean pageBean = sysUserService.listPage(currentPage);
		
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		
		return "listpage";
	}
	
	//根据id查询出要编辑的用户信息，然后跳往编辑页面
	public String edit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		Integer user_id = user.getUser_id();
		
		SysUser user = sysUserService.findOne(user_id);
		
		//将查询到的对象放到域对象中
		request.setAttribute("user", user);
		
		//需要查询出所有的角色名称
		Map<Integer, String> mapRole = roleService.getAllRoles();
		
		request.setAttribute("mapRole", mapRole);
		return "edit";
	}
	
	//编辑之后将用户信息保存到数据库
	public String save() {
		
		user.setUser_flag(1);
		
		sysUserService.update(user);
		
		return "save";
	}
	
	//跳转至新建用户信息的页面
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();	
		
		//需要查询出所有的角色名称
		Map<Integer, String> mapRole = roleService.getAllRoles();
		
		request.setAttribute("mapRole", mapRole);
		
		return "add";
	}
	
	//将新建页面的用户信息保存到数据库中的方法
	public String add2db() {
		sysUserService.add(user);
		
		return "add2db";
	}
	
	//根据id删除用户信息
	public String delete(){
		Integer user_id = user.getUser_id();
		
		SysUser user = sysUserService.findOne(user_id);
		
		if (user != null) {
			user.setUser_flag(0);
			sysUserService.update(user);
		}
		return "delete";
	}
	
	//多条件查询
	public String multiQuery() {
		List<SysUser> multiQueryList = sysUserService.multiQuery(user);
		
		ServletActionContext.getRequest().setAttribute("multiQueryList", multiQueryList);
		
		return "multiQuery";
	}
}
