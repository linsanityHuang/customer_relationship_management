package cn.crm.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.jfree.chart.JFreeChart;

import cn.crm.entity.PageBean;
import cn.crm.service.CustomerService;
import cn.crm.service.StatisticalFormService;
import cn.crm.utils.JfreeChartUtil;

import com.opensymphony.xwork2.ActionSupport;

public class StatisticalFormAction extends ActionSupport {

	private StatisticalFormService statisticalFormService;
	public void setStatisticalFormService(StatisticalFormService statisticalFormService) {
		this.statisticalFormService = statisticalFormService;
	}
	
	private CustomerService customerService;
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	private Integer currentPage;
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	
	private JFreeChart chart;
    public JFreeChart getChart() {
        return chart;
    }
    public void setChart(JFreeChart chart) {
        this.chart = chart;
    }
	
	public String contributionAnalysis() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		//调用service的方法实现封装
		PageBean pageBean = customerService.listpage(currentPage);
		
		//获取客户所有订单的总金额
		Map<String, Double> custTotalMoney = customerService.getCustTotalMoney();
		request.setAttribute("custTotalMoney", custTotalMoney);
		
		//放到域对象中
		request.setAttribute("pageBean", pageBean);
		
		return "contributionAnalysis";
	}
	
	/*public String show() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		
	    String type=request.getParameter("type");
	    Map<String,Double> map=null;
	    if(type !=null && type.equals("area")) {
	        map = statisticalFormService.findRepairRecByArea();
	        
	        this.chart = JfreeChartUtil.createPieChart("各地区产品数量统计", map);//饼状图
	    }else if(type!=null&&type.equals("person")){
	    	
	        List<Map<String,Object>> list=statisticalFormService.findRepairRec(PERSON);
	        map=new HashMap<String,Double>();
	        for(Map<String,Object> repairRec:list){
	            String person=repairRec.get("repair_person")+"";
	            Double count=Double.parseDouble(repairRec.get("count")+"");
	            map.put(person, count);
	        }
	        this.chart = JfreeChartUtil.createBarChart("各人员维修产品数量统计", "维修人员", "产品数量", map);//柱状图
	    }
	    //this.chart = JfreeChartUtil.createLineChart("折线图", "X轴标签", "Y轴标签");
	    return "show";
	}*/
	
	public String serviceAnalysis() {
		List<Map<String,Object>> list = statisticalFormService.serviceAnalysis();
		Map<String,Integer> map = new HashMap<String,Integer>();
		for (Map<String,Object> object : list) {
			String basi_item = object.get("BASI_ITEM") + "";
			Integer count = Integer.parseInt(object.get("NUM") + "");
			map.put(basi_item, count);
		}
		this.chart = JfreeChartUtil.createBarChart("客户服务统计图", "服务类型", "服务数量", map);
		
		return "serviceAnalysis";
	}
}
