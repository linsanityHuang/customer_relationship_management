package cn.crm.entity;

public class CustLost {
	private Integer lost_no;
	private Customer lost_cust_no;
	private String lost_manager_name;
	private String lost_last_order_date;
	private String lost_last_date;
	private String lost_delay;
	private String lost_reson;
	private Integer lost_status;

	public Integer getLost_no() {
		return lost_no;
	}

	public void setLost_no(Integer lost_no) {
		this.lost_no = lost_no;
	}

	public Customer getLost_cust_no() {
		return lost_cust_no;
	}

	public void setLost_cust_no(Customer lost_cust_no) {
		this.lost_cust_no = lost_cust_no;
	}

	public String getLost_manager_name() {
		return lost_manager_name;
	}

	public void setLost_manager_name(String lost_manager_name) {
		this.lost_manager_name = lost_manager_name;
	}

	public String getLost_last_order_date() {
		return lost_last_order_date;
	}

	public void setLost_last_order_date(String lost_last_order_date) {
		this.lost_last_order_date = lost_last_order_date;
	}

	public String getLost_last_date() {
		return lost_last_date;
	}

	public void setLost_last_date(String lost_last_date) {
		this.lost_last_date = lost_last_date;
	}

	public String getLost_delay() {
		return lost_delay;
	}

	public void setLost_delay(String lost_delay) {
		this.lost_delay = lost_delay;
	}

	public String getLost_reson() {
		return lost_reson;
	}

	public void setLost_reson(String lost_reson) {
		this.lost_reson = lost_reson;
	}

	public Integer getLost_status() {
		return lost_status;
	}

	public void setLost_status(Integer lost_status) {
		this.lost_status = lost_status;
	}

	@Override
	public String toString() {
		return "CustLost [lost_no=" + lost_no + ", lost_manager_name=" + lost_manager_name + ", lost_last_order_date=" + lost_last_order_date + ", lost_last_date="
				+ lost_last_date + "]";
	}

}
