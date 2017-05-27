package cn.crm.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.crm.entity.PageBean;
import cn.crm.entity.SaleChance;
import cn.crm.entity.SysUser;
import cn.crm.service.DictionaryService;
import cn.crm.service.SaleChanceService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SaleChanceAction extends ActionSupport implements ModelDriven<SaleChance> {

	//模型驱动获取页面参数
	private SaleChance saleChance = new SaleChance();
	public SaleChance getModel() {
		// TODO Auto-generated method stub
		return saleChance;
	}
	
	//属性注入
	private SaleChanceService saleChanceService;
	public void setSaleChanceService(SaleChanceService saleChanceService) {
		this.saleChanceService = saleChanceService;
	}
	
	private DictionaryService dictionaryService;
	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	//使用属性封装方式获取从页面传过来的请求数据currentpage
	private Integer currentPage;
	
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

//	在销售机会管理的列表页面列出所有状态为“未分配”的销售机会记录
	public String listpage() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		PageBean pageBean = saleChanceService.listpage(currentPage);
		
		request.setAttribute("pageBean", pageBean);
		return "listpage";
	}
	
	//根据页面传入的主键进行逻辑删除操作（实际上更新标识即可）
	
//	销售主管、客户经理对状态为“未分配”的销售机会可以删除。删除时需要判断
//	当前登录用户为该销售机会的创建人，否则不可删除。
//	点选“删除”操作后应提示“确认删除？”，用户选“确定”则执行删除操作，否
//	则不执行。删除成功后提示“删除成功”。
	public String delete(){
		Long chan_no = saleChance.getChan_no();
		
		//获取当前登录用户信息
		SysUser user = (SysUser) ServletActionContext.getRequest().getSession().getAttribute("user");
		
		//删除记录的规范操作，先查再删
		SaleChance saleChance = saleChanceService.findOne(chan_no);
		
		if (saleChance != null) {
			
			if (saleChance.getChan_create_by().equals(user.getUser_name())) {
				//将该对象的标识更新为0，即已删除
				saleChance.setChan_flag(0);
				saleChanceService.update(saleChance);
				return "deleteSuccsess";
			}
			
		}
		return "deleteFailed";
	}
	
	
	//修改，分为两步进行，先根据主键值查询出来，并跳往详细显示的页面
	public String showSaleChance() {
		Long chan_no = saleChance.getChan_no();
		
		//根据主键查询
		SaleChance saleChance = saleChanceService.findOne(chan_no);
		
		//将查询到的对象放到域对象中
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("saleChance", saleChance);
		
		//同时还需要将用户所涉及所有的地区和等级查出来，在放到listpage页面中,因为几乎所有新建和编辑页面都要用到地区和等级信息，至少可以把它们放在session域中
		HttpSession session = request.getSession();
		Map<String, String> mapRegion = dictionaryService.getRegions();
		Map<String, String> mapLevel = dictionaryService.getLevels();
		session.setAttribute("mapRegion", mapRegion);
		session.setAttribute("mapLevel", mapLevel);
		
		//还需要查询出所有的客户经理
		List<String> listManager = saleChanceService.findAllCustManager();
		session.setAttribute("listManager", listManager);
		
		//由于在编辑页面有一个返回按钮，因此当点击返回按钮的时候就需要该当前页码返回
		request.setAttribute("currentPage", currentPage);
		return "showSaleChance";
	}
	
	// 然后在编辑页面将数据保存到数据库
	public String update() {
		saleChanceService.update(saleChance);
		
		return "update";
	}
	
	
	//将指定主键的销售机会指派给某位经理的方法
	public String due_to_manager() {
		Long chan_no = saleChance.getChan_no();
		
		//根据主键查询
		SaleChance saleChance = saleChanceService.findOne(chan_no);
		
		//将查询到的对象放到域对象中
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("saleChance", saleChance);
		
		List<String> listManager = saleChanceService.findAllCustManager();
		request.setAttribute("listManager", listManager);
		
		return "due_to_manager";
	}
	
	public String due_to_manager_update() {
		Long chan_no = saleChance.getChan_no();
		
		SaleChance saleChance = saleChanceService.findOne(chan_no);
		
		saleChance.setChan_due_to(this.saleChance.getChan_due_to());
		saleChance.setChan_due_date(this.saleChance.getChan_due_date());
		//并将该销售机会状态改为“已指派”（即“开发中”）
		saleChance.setChan_status(1);
		
		saleChanceService.update(saleChance);
		
		return "due_to_manager_update";
	}
	
	//新建销售机会同样分为两步走，先通过该方法跳转至新建页面，然后在 通过表单提交进入该action的实际添加方法
	public String toAddPage() {
		List<String> listManager = saleChanceService.findAllCustManager();
		Map<String, String> mapRegion = dictionaryService.getRegions();
		Map<String, String> mapLevel = dictionaryService.getLevels();
		
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("listManager", listManager);
		request.setAttribute("mapRegion", mapRegion);
		request.setAttribute("mapLevel", mapLevel);
		
		return "toAddPage";
	}
	
	//实际的添加方法
	public String add() {
		saleChanceService.add(saleChance);
		return "add";
	}
	
	public String multiQuery() {
		
		PageBean pageBean = saleChanceService.multiQuery(saleChance, currentPage);
		
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		
		return "multiQuery";
	}
}
