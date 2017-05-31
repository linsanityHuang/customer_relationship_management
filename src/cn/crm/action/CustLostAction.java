package cn.crm.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.crm.entity.CustLost;
import cn.crm.entity.PageBean;
import cn.crm.service.CustLostService;
import cn.crm.service.DictionaryService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustLostAction extends ActionSupport implements ModelDriven<CustLost>{

	private CustLost custLost = new CustLost();
	public CustLost getModel() {
		return custLost;
	}

	private CustLostService custLostService;
	public void setCustLostService(CustLostService custLostService) {
		this.custLostService = custLostService;
	}
	private DictionaryService dictionaryService;
	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	private Integer currentPage;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}


	public String listpage() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		PageBean pageBean = custLostService.listPage(currentPage);
		Map<String, String> mapLostStatus = dictionaryService.getLostStatus();
		
		request.setAttribute("pageBean", pageBean);
		request.setAttribute("mapLostStatus", mapLostStatus);
		
		return "listpage";
	}
	
	public String multiQuery() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		List<CustLost> list = custLostService.multiQuery(custLost);
		Map<String, String> mapLostStatus = dictionaryService.getLostStatus();
		
		request.setAttribute("list", list);
		request.setAttribute("mapLostStatus", mapLostStatus);
		
		return "multiQuery";
	}
	
	public String pauseLost() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		CustLost custLost = custLostService.findOne(this.custLost.getLost_no());
		
		request.setAttribute("custLost", custLost);
		
		return "pauseLost";
	}
	
	public String updatePauseLost() {
		CustLost custLost = custLostService.findOne(this.custLost.getLost_no());
		
		custLost.setLost_delay(this.custLost.getLost_delay());
		custLost.setLost_status(2);
		
		custLostService.update(custLost);
		
		return "updatePauseLost";
	}
	
	public String confirmLost() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		CustLost custLost = custLostService.findOne(this.custLost.getLost_no());
		
		request.setAttribute("custLost", custLost);
		
		return "confirmLost";
	}
	
	public String updateConfirmLost() {
		CustLost custLost = custLostService.findOne(this.custLost.getLost_no());
		
		custLost.setLost_reson(this.custLost.getLost_reson());
		
		custLost.setLost_status(3);
		
		custLostService.update(custLost);
		
		return "updateConfirmLost";
	}
}
