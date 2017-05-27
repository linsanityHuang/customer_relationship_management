package cn.crm.entity;

public class ServiceManager {
	private String serv_no;
	private Customer serv_cust_no;
	private Integer serv_type;
	private String serv_title;
	private String serv_cust_name;
	private Integer serv_status;
	private String serv_request;
	private String serv_create_by;
	private String serv_create_date;
	private String serv_due_to;
	private String serv_due_date;
	private String serv_deal;
	private String serv_deal_name;
	private String serv_deal_date;
	private String serv_result;
	private Integer serv_satisfy;
	private Integer serv_flag;

	public String getServ_no() {
		return serv_no;
	}

	public void setServ_no(String serv_no) {
		this.serv_no = serv_no;
	}

	public Customer getServ_cust_no() {
		return serv_cust_no;
	}

	public void setServ_cust_no(Customer serv_cust_no) {
		this.serv_cust_no = serv_cust_no;
	}

	public Integer getServ_type() {
		return serv_type;
	}

	public void setServ_type(Integer serv_type) {
		this.serv_type = serv_type;
	}

	public String getServ_title() {
		return serv_title;
	}

	public void setServ_title(String serv_title) {
		this.serv_title = serv_title;
	}

	public String getServ_cust_name() {
		return serv_cust_name;
	}

	public void setServ_cust_name(String serv_cust_name) {
		this.serv_cust_name = serv_cust_name;
	}

	public Integer getServ_status() {
		return serv_status;
	}

	public void setServ_status(Integer serv_status) {
		this.serv_status = serv_status;
	}

	public String getServ_request() {
		return serv_request;
	}

	public void setServ_request(String serv_request) {
		this.serv_request = serv_request;
	}

	public String getServ_create_by() {
		return serv_create_by;
	}

	public void setServ_create_by(String serv_create_by) {
		this.serv_create_by = serv_create_by;
	}

	public String getServ_create_date() {
		return serv_create_date;
	}

	public void setServ_create_date(String serv_create_date) {
		this.serv_create_date = serv_create_date;
	}

	public String getServ_due_to() {
		return serv_due_to;
	}

	public void setServ_due_to(String serv_due_to) {
		this.serv_due_to = serv_due_to;
	}

	public String getServ_due_date() {
		return serv_due_date;
	}

	public void setServ_due_date(String serv_due_date) {
		this.serv_due_date = serv_due_date;
	}

	public String getServ_deal() {
		return serv_deal;
	}

	public void setServ_deal(String serv_deal) {
		this.serv_deal = serv_deal;
	}

	public String getServ_deal_name() {
		return serv_deal_name;
	}

	public void setServ_deal_name(String serv_deal_name) {
		this.serv_deal_name = serv_deal_name;
	}

	public String getServ_deal_date() {
		return serv_deal_date;
	}

	public void setServ_deal_date(String serv_deal_date) {
		this.serv_deal_date = serv_deal_date;
	}

	public String getServ_result() {
		return serv_result;
	}

	public void setServ_result(String serv_result) {
		this.serv_result = serv_result;
	}

	public Integer getServ_satisfy() {
		return serv_satisfy;
	}

	public void setServ_satisfy(Integer serv_satisfy) {
		this.serv_satisfy = serv_satisfy;
	}

	public Integer getServ_flag() {
		return serv_flag;
	}

	public void setServ_flag(Integer serv_flag) {
		this.serv_flag = serv_flag;
	}

	@Override
	public String toString() {
		return "ServiceManager [serv_no=" + serv_no + ", serv_type=" + serv_type + ", serv_title=" + serv_title + ", serv_cust_name=" + serv_cust_name + "]";
	}

}
