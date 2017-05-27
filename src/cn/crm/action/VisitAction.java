package cn.crm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.crm.entity.Customer;
import cn.crm.entity.SysUser;
import cn.crm.entity.Visit;
import cn.crm.service.CustomerService;
import cn.crm.service.SysUserService;
import cn.crm.service.VisitService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class VisitAction extends ActionSupport implements ModelDriven<Visit>{

	private Visit visit = new Visit();
	@Override
	public Visit getModel() {
		// TODO Auto-generated method stub
		return visit;
	}
	private VisitService visitService;

	public void setVisitService(VisitService visitService) {
		this.visitService = visitService;
	}
	
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	private SysUserService sysUserService;
	public void setSysUserService(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

	//1 到新增页面
	public String toAddPage() {
		//查询所有客户
		List<Customer> listCustomer = customerService.findAll();
		//查询所有用户
		List<SysUser> listUser = sysUserService.findAll();
		
		//放到域对象中
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listCustomer", listCustomer);
		request.setAttribute("listUser", listUser);
		
		return "toAddPage";
	}
	
	//2 新增数据到数据库的方法
	public String addVisit() {
		
		visitService.addVisit(visit);
		return "addVisit";
	}
	
	//3 拜访列表的方法
	public String list() {
		List<Visit> list = visitService.findAll();
		
		ServletActionContext.getRequest().setAttribute("list", list);
		return "list";
	}
	
}
