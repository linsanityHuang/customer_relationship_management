package cn.crm.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.crm.entity.PageBean;
import cn.crm.entity.SysRole;
import cn.crm.service.SysRoleService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SysRoleAction extends ActionSupport implements ModelDriven<SysRole>{

	private SysRoleService roleService;
	public void setRoleService(SysRoleService roleService) {
		this.roleService = roleService;
	}
	
	private Integer currentPage;
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	//使用模型驱动，要求模型中的属性名字与表单输入项的name属性名字一致
	private SysRole role = new SysRole();
	public SysRole getModel() {
		return role;
	}
	
	public String listpage() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		PageBean pageBean = roleService.listPage(currentPage);
		
		request.setAttribute("pageBean", pageBean);
		
		return "listpage";
	}
	
	public String edit() {
		Integer role_id = role.getRole_id();
		SysRole role = roleService.findOne(role_id);
		
		ServletActionContext.getRequest().setAttribute("role", role);
		
		return "edit";
	}
}
