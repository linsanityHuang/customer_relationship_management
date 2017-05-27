package cn.crm.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import cn.crm.entity.PageBean;
import cn.crm.entity.Storage;
import cn.crm.service.StorageService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class StorageAction extends ActionSupport implements ModelDriven<Storage>{

	private Storage storage = new Storage();
	public Storage getModel() {
		return storage;
	}

	private StorageService storageService;
	public void setStorageService(StorageService storageService) {
		this.storageService = storageService;
	}
	
	private Integer currentPage;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	private String prod_name;
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	
	public String showStorage() {
		PageBean pageBean = storageService.listPage(currentPage);
		
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		
		return "showStorage";
	}
	
	
	public String multiQuery() {
		
		List<Storage> list = storageService.multiQuery(storage);
		
		ServletActionContext.getRequest().setAttribute("list", list);
		
		return "multiQuery";
	}
}
