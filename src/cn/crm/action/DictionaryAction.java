package cn.crm.action;

import org.apache.struts2.ServletActionContext;

import cn.crm.entity.BasicDictionary;
import cn.crm.entity.PageBean;
import cn.crm.service.DictionaryService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DictionaryAction extends ActionSupport implements ModelDriven<BasicDictionary>{

	private DictionaryService dictionaryService;
	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}
	
	private BasicDictionary dictionary = new BasicDictionary();
	public BasicDictionary getModel() {
		// TODO Auto-generated method stub
		return dictionary;
	}
	private Integer currentPage;
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public String showCustLevel() {
		PageBean pageBean = dictionaryService.listPageCustLevel(currentPage);
		
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		
		return "showCustLevel";
	}

	public String editLevel() {
		Integer basi_no = dictionary.getBasi_no();
		
		BasicDictionary dictionary = dictionaryService.findOne(basi_no);
		
		ServletActionContext.getRequest().setAttribute("dictionary", dictionary);
		
		return "editLevel";
	}
	
	public String saveLevel() {
		Integer basi_no = dictionary.getBasi_no();
		BasicDictionary dictionary = dictionaryService.findOne(basi_no);
		if (dictionary != null) {
			dictionary.setBasi_item(this.dictionary.getBasi_item());
			dictionaryService.update(dictionary);
		}
		return "saveLevel";
	}
	
	public String deleteLevel() {
		Integer basi_no = dictionary.getBasi_no();
		
		BasicDictionary dictionary = dictionaryService.findOne(basi_no);
		
		if (dictionary != null) {
			dictionary.setBasi_flag(0);
			dictionaryService.update(dictionary);
		}
		return "deleteLevel";
	}
	
	public String addCustLevel() {
		//获取客户等级对应的最大值
		int max_basi_valueOfCustLevel = dictionaryService.getMaxCustLevel();
		
		ServletActionContext.getRequest().setAttribute("max_basi_valueOfCustLevel", max_basi_valueOfCustLevel);
		
		return "addCustLevel";
	}
	
	public String add2db() {
		dictionaryService.add(dictionary);
		
		return "add2db";
	}
	
	public String showServiceType() {
		PageBean pageBean = dictionaryService.listPageServiceType(currentPage);
		
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		
		return "showServiceType";
	}
	
	public String editServiceType() {
		Integer basi_no = dictionary.getBasi_no();
		
		BasicDictionary dictionary = dictionaryService.findOne(basi_no);
		
		ServletActionContext.getRequest().setAttribute("dictionary", dictionary);
		
		return "editServiceType";
	}
	
	public String saveServiceType() {
		Integer basi_no = dictionary.getBasi_no();
		BasicDictionary dictionary = dictionaryService.findOne(basi_no);
		if (dictionary != null) {
			dictionary.setBasi_item(this.dictionary.getBasi_item());
			dictionaryService.update(dictionary);
		}
		return "saveServiceType";
	}
	
	public String deleteServiceType() {
		Integer basi_no = dictionary.getBasi_no();
		
		BasicDictionary dictionary = dictionaryService.findOne(basi_no);
		
		if (dictionary != null) {
			dictionary.setBasi_flag(0);
			dictionaryService.update(dictionary);
		}
		return "deleteServiceType";
	}
	
	public String addServiceType() {
		//获取客户等级对应的最大值
		int max_basi_valueOfServiceType = dictionaryService.getMaxServiceType();
		
		ServletActionContext.getRequest().setAttribute("max_basi_valueOfServiceType", max_basi_valueOfServiceType);
		
		return "addServiceType";
	}
	
	public String addServiceType2db() {
		dictionaryService.add(dictionary);
		
		return "addServiceType2db";
	}
	
	public String showCustRegion() {
		PageBean pageBean = dictionaryService.listPageCustRegion(currentPage);
		
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		
		return "showCustRegion";
	}
	
	public String editCustRegion() {
		Integer basi_no = dictionary.getBasi_no();
		
		BasicDictionary dictionary = dictionaryService.findOne(basi_no);
		
		ServletActionContext.getRequest().setAttribute("dictionary", dictionary);
		
		return "editCustRegion";
	}
	
	public String saveCustRegion() {
		Integer basi_no = dictionary.getBasi_no();
		BasicDictionary dictionary = dictionaryService.findOne(basi_no);
		if (dictionary != null) {
			dictionary.setBasi_item(this.dictionary.getBasi_item());
			dictionaryService.update(dictionary);
		}
		return "saveCustRegion";
	}
	
	public String deleteCustRegion() {
		Integer basi_no = dictionary.getBasi_no();
		
		BasicDictionary dictionary = dictionaryService.findOne(basi_no);
		
		if (dictionary != null) {
			dictionary.setBasi_flag(0);
			dictionaryService.update(dictionary);
		}
		return "deleteCustRegion";
	}
	
	public String addCustRegion() {
		//获取客户等级对应的最大值
		int max_basi_valueOfCustRegion = dictionaryService.getMaxCustRegion();
		
		ServletActionContext.getRequest().setAttribute("max_basi_valueOfCustRegion", max_basi_valueOfCustRegion);
		
		return "addCustRegion";
	}
	
	public String addCustRegion2db() {
		dictionaryService.add(dictionary);
		
		return "addCustRegion2db";
	}
}
