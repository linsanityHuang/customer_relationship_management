package cn.crm.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.crm.entity.Customer;
import cn.crm.entity.PageBean;
import cn.crm.service.CustomerService;
import cn.crm.service.DictionaryService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

	//使用模型驱动，要求模型中的属性名字与表单输入项的name属性名字一致
	private Customer customer = new Customer();
	
	public Customer getModel() {
		return customer;
	}
	
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	private DictionaryService dictionaryService;
	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	//多条件查询(名称、编号、地区、经理、等级)
	public String moreCondition() {
		List<Customer> list = customerService.findMoreCondition(customer);
		
		ServletActionContext.getRequest().setAttribute("list", list);
		return "moreCondition";
	}
	
	//到查询客户信息的页面
	public String toSelectCustomerPage() {
		
		return "toSelectCustomerPage";
	}
	
	
	//条件查询的方法
	public String listcondition() {
		//如果输入客户名称，根据客户名称查询
		//如果不输入任何内容，查询所有
		if (customer.getCust_name() != null && !"".equals(customer.getCust_name())) {
			//不为空
			List<Customer> list = customerService.findCondition(customer);
			ServletActionContext.getRequest().setAttribute("list", list);
		} else {
			//不输入任何内容，查询所有
			list();
		}
		return "listcondition";
	}
	//使用属性封装获取当前页
	private Integer currentPage;
	
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	//分页的方法
	public String listpage(){
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//调用service的方法实现封装
		PageBean pageBean = customerService.listpage(currentPage);
		
		//放到域对象中
		request.setAttribute("pageBean", pageBean);
		
		//同时还需要将用户所涉及所有的地区和等级查出来，在放到listpage页面中
		Map<String, String> mapRegion = dictionaryService.getRegions();
		Map<String, String> mapLevel = dictionaryService.getLevels();
		request.setAttribute("mapRegion", mapRegion);
		request.setAttribute("mapLevel", mapLevel);
		
		return "listpage";
	}
	
	//1 到添加页面
	public String toAddPage(){
		
		return "toAddPage";
	}
	
	//2 添加的方法
	public String add(){
		//添加逻辑
		customerService.add(customer);
		return "add";
	}
	
	//定义list变量
	private List<Customer> list;
	//生成get方法
	public List<Customer> getList() {
		return list;
	}
	
	//3 客户列表的方法
	public String list(){
		
//		List<Customer> list = customerService.findAll();
		//放到域对象
//		ServletActionContext.getRequest().setAttribute("list", list);
		
		//将返回的list对象放到值栈中
		list = customerService.findAll();
		
		
		return "list";
	}


	//4 删除的方法
	public String delete(){
		//使用模型驱动获取表单提交的cust_no值，只要表单提交过来的数据的属性名如cust_no与实体类中的属性名一致，就可以通过模型驱动获取数据
		String cust_no = customer.getCust_no();
		
		//删除记录的规范：首先根据id查询该数据是否存在，再调用方法删除
		//根据id查询
		Customer customer = customerService.findOne(cust_no);
		
		//判断根据id查询得到的对象是否为空
		if (customer != null) {
			//调用方法删除(执行逻辑删除，将客户标识cust_flag设置为0)
			customerService.delete(customer);
		}
		return "delete";
	}
	
	//5 修改的方法 - 先根据id查询到记录信息
	public String showCustomer(){
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//使用模型驱动得到主键值
		String cust_no = customer.getCust_no();
		
		//根据id查询
		Customer customer = customerService.findOne(cust_no);
		
		Map<String, String> mapLevel = dictionaryService.getLevels();
		Map<String, String> mapRegion = dictionaryService.getRegions();
		Map<String, String> mapCredit = dictionaryService.getCredits();
		Map<String, String> mapSatisfy = dictionaryService.getSatisfies();
		
		//将查询到的对象放到域对象中
		request.setAttribute("customer", customer);
		request.setAttribute("mapLevel", mapLevel);
		request.setAttribute("mapRegion", mapRegion);
		request.setAttribute("mapCredit", mapCredit);
		request.setAttribute("mapSatisfy", mapSatisfy);
		
		return "showCustomer";
	}
	
	//6 修改的方法 - 修改之后保存的方法
	public String update(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		boolean flag = customerService.update(customer);
			
		Customer customer = customerService.findOne(this.customer.getCust_no());
		
		request.setAttribute("customer", customer);
		
		request.setAttribute("flag", flag);
		
		return "update";
	}
	
	//根据客户经理统计
	public String countManager() {
		List list = customerService.findCountManager();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "countManager";
	}
	
	//根据客户级别统计
	public String countLevel() {
		List list = customerService.findCountLevel();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "countLevel";
	}
}
