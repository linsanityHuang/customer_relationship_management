package cn.crm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.crm.entity.PageBean;
import cn.crm.entity.SaleChance;
import cn.crm.entity.SalePlan;
import cn.crm.service.SaleChanceService;
import cn.crm.service.SalePlanService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SalePlanAction extends ActionSupport implements ModelDriven<SalePlan> {

	private SalePlan salePlan = new SalePlan();
	public SalePlan getModel() {
		return salePlan;
	}
	
	private SalePlanService salePlanService;
	public void setSalePlanService(SalePlanService salePlanService) {
		this.salePlanService = salePlanService;
	}

	private Integer currentPage;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public String showSalePlan() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		PageBean pageBean = salePlanService.listPage(currentPage);
		
		request.setAttribute("pageBean", pageBean);
		
		return "showSalePlan";
	}
	
	public String multiQuery() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		List<SalePlan> list = salePlanService.multiQuery(salePlan);
		
		request.setAttribute("list", list);
		
		return "multiQuery";
	}
	
//	客户经理对分配给自己的销售机会制定开发计划。点选“制定计划”后，显示销售机会的详细信息。
	public String makePlan() {
		Integer plan_no = salePlan.getPlan_no();
		
		SalePlan salePlan = salePlanService.findOne(plan_no);
		
		//获取该开发计划对应的销售机会
		SaleChance saleChance = salePlan.getSaleChance();
		
		ServletActionContext.getRequest().setAttribute("saleChance", saleChance);
		
		return "makePlan";
	}
	
	public String addPlan_Item() {
		salePlanService.save(salePlan);
		
		return "addPlan_Item";
	}
	
	public String deletePlan_Item() {
		Integer plan_no = salePlan.getPlan_no();
		
		SalePlan salePlan = salePlanService.findOne(plan_no);
		
		salePlan.setPlan_flag(0);
		
		salePlanService.update(salePlan);
		
		return "deletePlan_Item";
	}
	
	public String executePlan() {
		Integer plan_no = salePlan.getPlan_no();
		
		SalePlan salePlan = salePlanService.findOne(plan_no);
		
//		SaleChance saleChance = salePlan.getSaleChance();
		
		ServletActionContext.getRequest().setAttribute("salePlan", salePlan);
		
		return "executePlan";
	}
	
	public String writePlanResult() {
		
		Integer plan_no = salePlan.getPlan_no();
		
		SalePlan salePlan = salePlanService.findOne(plan_no);
		
		salePlan.setPlan_result(this.salePlan.getPlan_result());
		
		salePlanService.update(salePlan);
		
		return "writePlanResult";
	}
	
	
	public String showSaleChanceDetails() {
		Integer plan_no = salePlan.getPlan_no();
		
		SalePlan salePlan = salePlanService.findOne(plan_no);
		
		//获取该开发计划对应的销售机会
		SaleChance saleChance = salePlan.getSaleChance();
		
		ServletActionContext.getRequest().setAttribute("saleChance", saleChance);
		
		return "showSaleChanceDetails";
	}
	
	public String developSuccess() {
		Integer plan_no = salePlan.getPlan_no();
		
		SalePlan salePlan = salePlanService.findOne(plan_no);
		
		//修改销售机会的状态为“开发成功”
		salePlan.getSaleChance().setChan_status(3);
		
		salePlanService.update(salePlan);
		
		return "developSuccess";
	}
	
	public String developFailed() {
		Integer plan_no = salePlan.getPlan_no();
		
		SalePlan salePlan = salePlanService.findOne(plan_no);
		
		//修改销售机会的状态为“开发失败”
		salePlan.getSaleChance().setChan_status(2);
		
		salePlanService.update(salePlan);
		
		return "developFailed";
	}
}
