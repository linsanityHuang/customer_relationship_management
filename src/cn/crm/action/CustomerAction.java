package cn.crm.action;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.crm.entity.CommunicateRecord;
import cn.crm.entity.CustLinkMan;
import cn.crm.entity.Customer;
import cn.crm.entity.Orders;
import cn.crm.entity.OrdersLine;
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

	//第一 分页的方法
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
	public String deleteCustomer(){
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
		return "deleteCustomer";
	}
	
	//第二 修改的方法 - 先根据id查询到记录信息
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
	
	//第三 修改的方法 - 修改之后保存的方法
	public String update(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		boolean flag = customerService.update(customer);
			
//		Customer customer = customerService.findOne(this.customer.getCust_no());
//		
//		request.setAttribute("customer", customer);
		
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
	
	//第四 多重条件查询
	public String multiQuery() {
		
		PageBean pageBean = customerService.multiQuery(customer, currentPage);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//放到域对象中
		request.setAttribute("pageBean", pageBean);
		
		//同时还需要将用户所涉及所有的地区和等级查出来，在放到listpage页面中
		Map<String, String> mapRegion = dictionaryService.getRegions();
		Map<String, String> mapLevel = dictionaryService.getLevels();
		request.setAttribute("mapRegion", mapRegion);
		request.setAttribute("mapLevel", mapLevel);
		
		return "multiQuery";
	}
	
	//第五 获取该客户的联系人信息
	public String showCustLinkMan() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String cust_no = customer.getCust_no();
		Customer customer = customerService.findOne(cust_no);
		
		Set<CustLinkMan> linkMans = customer.getCustLinkMans();
		
		request.setAttribute("customer", customer);
		request.setAttribute("linkMans", linkMans);
		
		return "showCustLinkMan";
	}
	
	private String link_no;
	public String getLink_no() {
		return link_no;
	}
	public void setLink_no(String link_no) {
		this.link_no = link_no;
	}

	//第六 编辑某个联系人信息
	public String editLinkMan() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String cust_no = customer.getCust_no();
		
		Customer customer = customerService.findOne(cust_no);
		
		CustLinkMan linkMan = customerService.findLinkMans(cust_no, link_no);
		
		request.setAttribute("linkMan", linkMan);
		request.setAttribute("customer", customer);
		
		return "editLinkMan";
	}
	
	//第七 删除联系人
	public String deleteLinkMan() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String cust_no = customer.getCust_no();
		
		customerService.deleteLinkMan(cust_no, link_no);
		
		Customer customer = customerService.findOne(cust_no);
		
		Set<CustLinkMan> linkMans = customer.getCustLinkMans();
		
		request.setAttribute("customer", customer);
		request.setAttribute("linkMans", linkMans);
		
		return "deleteLinkMan";
	}
	
	//第八 新建联系人
	public String addLinkMan() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		Customer customer = customerService.findOne(this.customer.getCust_no());
		
		request.setAttribute("customer", customer);
		
		return "addLinkMan";
	}
	
	//第九 查看该客户的所有交往记录
	public String showCommunicateRecords() {
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String cust_no = customer.getCust_no();
		Customer customer = customerService.findOne(cust_no);
		
		Set<CommunicateRecord> communicateRecords = customer.getCommunicateRecords();
		
		request.setAttribute("customer", customer);
		request.setAttribute("communicateRecords", communicateRecords);
		
		return "showCommunicateRecords";
	}
	
	
	private String comm_no;
	public String getComm_no() {
		return comm_no;
	}
	public void setComm_no(String comm_no) {
		this.comm_no = comm_no;
	}

	public String editCommunicateRecord() {

		HttpServletRequest request = ServletActionContext.getRequest();
		
		String cust_no = customer.getCust_no();
		
		Customer customer = customerService.findOne(cust_no);
		
		CommunicateRecord communicateRecord = customerService.findCommunicateRecord(cust_no, comm_no);
		
		request.setAttribute("communicateRecord", communicateRecord);
		request.setAttribute("customer", customer);
		
		return "editCommunicateRecord";
	}
	
	public String deleteCommunicateRecord() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String cust_no = customer.getCust_no();
		
		customerService.deleteCommunicateRecord(cust_no, comm_no);
		
		return "deleteCommunicateRecord";
	}
	
	public String addCommunicateRecord() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		Customer customer = customerService.findOne(this.customer.getCust_no());
		
		request.setAttribute("customer", customer);
		
		return "addCommunicateRecord";
	}
	
	//查看某客户的历史订单记录
	public String showHistoryOrders() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String cust_no = customer.getCust_no();
		Customer customer = customerService.findOne(cust_no);
		
		Set<Orders> orders = customer.getOrders();
		
		request.setAttribute("customer", customer);
		request.setAttribute("orders", orders);
		
		return "showHistoryOrders";
	}
	private Integer orde_no;
	public Integer getOrde_no() {
		return orde_no;
	}
	public void setOrde_no(Integer orde_no) {
		this.orde_no = orde_no;
	}

	public String showOrderDetail() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String cust_no = customer.getCust_no();
		
		Customer customer = customerService.findOne(cust_no);
		
		Orders order = customerService.findOrder(cust_no, orde_no);
		
		Set<OrdersLine> ordersLines = order.getOrdersLines();
		
		Double totalMoney = customerService.getTotalMoney(cust_no, orde_no);
		
		request.setAttribute("order", order);
		request.setAttribute("customer", customer);
		request.setAttribute("totalMoney", totalMoney);
		request.setAttribute("ordersLines", ordersLines);
		
		return "showOrderDetail";
	}
}
