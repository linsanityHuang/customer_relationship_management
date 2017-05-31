package cn.crm.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.crm.entity.PageBean;
import cn.crm.entity.ServiceManager;
import cn.crm.service.CustomerService;
import cn.crm.service.DictionaryService;
import cn.crm.service.ServiceManagerService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ServiceManagerAction extends ActionSupport implements ModelDriven<ServiceManager>{

	private ServiceManager serviceManager = new ServiceManager();
	public ServiceManager getModel() {
		return serviceManager;
	}

	private ServiceManagerService serviceManagerService;
	public void setServiceManagerService(ServiceManagerService serviceManagerService) {
		this.serviceManagerService = serviceManagerService;
	}
	
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	private DictionaryService dictionaryService;
	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	public String createService() {
		HttpServletRequest request = ServletActionContext.getRequest();
		//获取所有客户名称以及对应的客户编号
		Map<String, String> customerMap = customerService.getCustomers();
		request.setAttribute("customerMap", customerMap);
		
		//获取所有服务类型
		Map<String, String> serviceTypeMap = dictionaryService.getServices();
		request.setAttribute("serviceTypeMap", serviceTypeMap);
		
		return "createService";
	}
	
	public String createService2db() {
		serviceManagerService.save(serviceManager);
		return "createService2db";
	}
	
	private Integer currentPage;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	//跳往服务管理分页页面
	public String due_to_service() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//获取所有客户名称以及对应的客户编号
		Map<String, String> customerMap = customerService.getCustomers();
		request.setAttribute("customerMap", customerMap);
		
		//获取所有服务类型
		Map<String, String> serviceTypeMap = dictionaryService.getServices();
		request.setAttribute("serviceTypeMap", serviceTypeMap);
		
		//获取所有可供分配的经理
		List<String> list = serviceManagerService.getDuetoManagers();
		request.setAttribute("list", list);
		
		PageBean pageBean = serviceManagerService.listPage(currentPage);
		request.setAttribute("pageBean", pageBean);
		
		return "due_to_service";
	}
	//单击“分配给”按钮进行服务分配
	public String duetoService() {
		String serv_no = serviceManager.getServ_no();
		
		ServiceManager serviceManager = serviceManagerService.findOne(serv_no);
		
		serviceManager.setServ_due_to(this.serviceManager.getServ_due_to());
		
		serviceManagerService.update(serviceManager);
		
		return "duetoService";
	}
	
	public String deleteService() {
		String serv_no = serviceManager.getServ_no();
		
		ServiceManager serviceManager = serviceManagerService.findOne(serv_no);
		
		serviceManagerService.delete(serviceManager);
		
		return "deleteService";
	}
	
	//跳往服务处理分页显示页面
	public String handleService() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//获取所有客户名称以及对应的客户编号
		Map<String, String> customerMap = customerService.getCustomers();
		request.setAttribute("customerMap", customerMap);
		
		//获取所有服务类型
		Map<String, String> serviceTypeMap = dictionaryService.getServices();
		request.setAttribute("serviceTypeMap", serviceTypeMap);
		
		PageBean pageBean = serviceManagerService.listPage2Handle(currentPage);
		
		request.setAttribute("pageBean", pageBean);
		
		return "handleService";
	}
	
	//执行服务处理操作
	public String handlingService() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//获取所有服务类型
		Map<String, String> serviceTypeMap = dictionaryService.getServices();
		request.setAttribute("serviceTypeMap", serviceTypeMap);
		
		String serv_no = serviceManager.getServ_no();
		
		ServiceManager serviceManager = serviceManagerService.findOne(serv_no);
		
		request.setAttribute("serviceManager", serviceManager);
		
		return "handlingService";
	}
	
	//将处理结果保存到数据库
	public String handleService2db() {
		String serv_no = serviceManager.getServ_no();
		
		ServiceManager serviceManager = serviceManagerService.findOne(serv_no);
		
		serviceManager.setServ_deal(this.serviceManager.getServ_deal());
		serviceManager.setServ_deal_name(this.serviceManager.getServ_deal_name());
		serviceManager.setServ_deal_date(this.serviceManager.getServ_deal_date());
		
		serviceManagerService.updateHandleService2db(serviceManager);
		
		return "handleService2db";
	}
	
	public String feedBackService() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//获取所有客户名称以及对应的客户编号
		Map<String, String> customerMap = customerService.getCustomers();
		request.setAttribute("customerMap", customerMap);
		
		//获取所有服务类型
		Map<String, String> serviceTypeMap = dictionaryService.getServices();
		request.setAttribute("serviceTypeMap", serviceTypeMap);
		
		PageBean pageBean = serviceManagerService.listPage2FeedBack(currentPage);
		
		request.setAttribute("pageBean", pageBean);
		
		return "feedBackService";
	}
	
	public String feedBackingService() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//获取所有服务类型
		Map<String, String> serviceTypeMap = dictionaryService.getServices();
		request.setAttribute("serviceTypeMap", serviceTypeMap);
		
		//获取字典表中的满意度数据
		Map<String, String> satisfyMap = dictionaryService.getSatisfies();
		request.setAttribute("satisfyMap", satisfyMap);
		
		String serv_no = serviceManager.getServ_no();
		
		ServiceManager serviceManager = serviceManagerService.findOne(serv_no);
		
		request.setAttribute("serviceManager", serviceManager);
		
		return "feedBackingService";
	}
	
	public String feedBackService2db() {
		String serv_no = serviceManager.getServ_no();
		
		ServiceManager serviceManager = serviceManagerService.findOne(serv_no);
		
		serviceManager.setServ_deal_name(this.serviceManager.getServ_deal_name());
		serviceManager.setServ_deal_date(this.serviceManager.getServ_deal_date());
		serviceManager.setServ_result(this.serviceManager.getServ_result());
		serviceManager.setServ_satisfy(this.serviceManager.getServ_satisfy());
		
		serviceManagerService.updateFeedBackService(serviceManager);
		
		return "feedBackService2db";
	}
	
	public String fileService(){
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//获取所有服务类型
		Map<String, String> serviceTypeMap = dictionaryService.getServices();
		request.setAttribute("serviceTypeMap", serviceTypeMap);
		
		PageBean pageBean = serviceManagerService.listPage2File(currentPage);
		
		request.setAttribute("pageBean", pageBean);
		
		return "fileService";
	}
	
	public String showFileService() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//获取所有服务类型
		Map<String, String> serviceTypeMap = dictionaryService.getServices();
		request.setAttribute("serviceTypeMap", serviceTypeMap);
		
		//获取字典表中的满意度数据
		Map<String, String> satisfyMap = dictionaryService.getSatisfies();
		request.setAttribute("satisfyMap", satisfyMap);
		
		String serv_no = serviceManager.getServ_no();
		
		ServiceManager serviceManager = serviceManagerService.findOne(serv_no);
		
		request.setAttribute("serviceManager", serviceManager);
		
		return "showFileService";
	}
}
