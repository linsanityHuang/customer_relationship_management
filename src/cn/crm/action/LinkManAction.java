package cn.crm.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.crm.entity.CustLinkMan;
import cn.crm.entity.Customer;
import cn.crm.service.CustomerService;
import cn.crm.service.LinkManService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class LinkManAction extends ActionSupport implements ModelDriven<CustLinkMan>{

	private CustLinkMan custLinkMan = new CustLinkMan();
	public CustLinkMan getModel() {
		return custLinkMan;
	}
	
	
	private LinkManService linkManService;

	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}

	//注入客户的service对象
	private CustomerService customerService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	// 1 到新增联系人页面的方法
	public String toAddPage() {
		// 1 查询到所有客户，把所有客户list集合传递到页面中显示（放到域对象中）
		// 调用客户service里面的方法得到所有的客户
		List<Customer> listcusCustomer = customerService.findAll();
		
		ServletActionContext.getRequest().setAttribute("listcusCustomer", listcusCustomer);
		return "toAddPage";
	}
	
	/*
	 * 文件上传需要的两个对象
	 * 上传文件（流）
	 * 上传文件名称
	 * （1）在action里面成员变量的位置定义变量
	 * -一个表示上传文件
	 * -一个表示文件名称
	 * （2）生成变量的get和set方法
	 * 
	 * 还有一个变量，指定上传文件的mime类型，不需要手动设置
	 */
	
	//1 上传文件,变量的名称需要时表单里面文件上传项的name值
	private File upload;
	
	//2 上传文件名称,表单里面文件上传项的name值+“FileName”,固定的
	private String uploadFileName;
	
	//3 生成set和get方法
	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	
	
	//2 添加数据到数据库的方法
	public String addLinkMan() throws IOException {
		
		//判断是否需要上传文件
		if (upload != null) {
			//写上传代码
			//在服务器文件夹里面创建文件
			File serverFile = new File("G:\\sshimg\\"+uploadFileName);
			//把要上传的文件复制到服务器文件里面
			FileUtils.copyFile(upload, serverFile);
		} 
		/**
		 * 可以封装联系人的基本信息
		 * 但是cust_no是客户的id值，不能直接封装的
		 * 可以把cust_no封装到CustLinkMan实体类里面的Customer类型的名为link_cust_no的属性里面
		 */
		
		//原始方式实现
//		String cust_no = ServletActionContext.getRequest().getParameter("cust_no");
//		
//		//创建customer对象
//		Customer customer = new Customer();
//		customer.setCust_no(cust_no);
//		
//		custLinkMan.setLink_cust_no(customer);
		
		linkManService.addLinkMan(custLinkMan);
		return "addLinkMan";
	}

	//3 获取联系人列表的方法
	public String list() {
		List<CustLinkMan> list = linkManService.listLinkMan();
		ServletActionContext.getRequest().setAttribute("list", list);
		
		return "list";
	}
	
	//4 到修改联系人页面的方法
	public String showLinkMan() {
		//使用模型驱动获取要修改的id值
		String link_no = custLinkMan.getLink_no();
		
		//根据id查询联系人对象
		CustLinkMan custLinkMan = linkManService.findOne(link_no);
		
		//除了联系人对象外，还需要所有客户的list结合
		List<Customer> listCustomers = customerService.findAll();
		
		
		//放到域对象
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("custLinkMan", custLinkMan);
		request.setAttribute("listCustomers", listCustomers);
		
		return "showLinkMan";
	}
	
	//5 修改联系人信息并保存到数据库
	public String updateCustLinkMan() {
		linkManService.updateLink(custLinkMan);
		return "updateCustLinkMan";
	}
	
	//到联系人添加页面
	public String toSelectPage() {
		//查询所有客户，传递到页面下拉列表中
		List<Customer> list = customerService.findAll();
		ServletActionContext.getRequest().setAttribute("list", list);
		return "toSelectPage";
	}
	
	//多条件查询
	public String moreCondition() {
		//调用方法得到条件结果
		List<CustLinkMan> list = linkManService.findCondition(custLinkMan);
		ServletActionContext.getRequest().setAttribute("list", list);
		
		return  "moreCondition";
	}
	
	//保存更新之后的联系人信息
	public String updateLinkMan() {
		
		linkManService.updateLink(custLinkMan);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		
		
		Customer customer = custLinkMan.getLink_cust_no();
		
		Set<CustLinkMan> linkMans = customer.getCustLinkMans();
		
		request.setAttribute("customer", customer);
		request.setAttribute("linkMans", linkMans);
		
		
		return "updateLinkMan";
	}
	
	//添加联系人到数据库
	public String addLinkMan2db() {
		linkManService.addLinkMan(custLinkMan);
		
		return "addLinkMan2db";
	}
}
