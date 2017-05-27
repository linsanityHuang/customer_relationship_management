package cn.crm.entity;

public class SalePlan {
	
	private Integer plan_no;	//开发计划编号，主键，非空
	private SaleChance saleChance;	//销售机会编号，外键，非空
	private String plan_date;		//开发计划计划时间，非空
	private String plan_item;		//开发计划计划项，非空
	private String plan_result;		//开发计划执行效果
	private Integer plan_flag;		//开发计划标识(0:已删除/1:未删除) , 非空

	public Integer getPlan_no() {
		return plan_no;
	}

	public void setPlan_no(Integer plan_no) {
		this.plan_no = plan_no;
	}

	public SaleChance getSaleChance() {
		return saleChance;
	}

	public void setSaleChance(SaleChance saleChance) {
		this.saleChance = saleChance;
	}

	public String getPlan_date() {
		return plan_date;
	}

	public void setPlan_date(String plan_date) {
		this.plan_date = plan_date;
	}

	public String getPlan_item() {
		return plan_item;
	}

	public void setPlan_item(String plan_item) {
		this.plan_item = plan_item;
	}

	public String getPlan_result() {
		return plan_result;
	}

	public void setPlan_result(String plan_result) {
		this.plan_result = plan_result;
	}

	public Integer getPlan_flag() {
		return plan_flag;
	}

	public void setPlan_flag(Integer plan_flag) {
		this.plan_flag = plan_flag;
	}
}
