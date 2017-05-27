package cn.crm.entity;

public class CommunicateRecord {
	private String comm_no;
	private Customer comm_cust_no;
	private String comm_date;
	private String comm_address;
	private String comm_title;
	private String comm_detail;
	private String comm_remark;
	private Integer comm_flag;

	public String getComm_no() {
		return comm_no;
	}

	public void setComm_no(String comm_no) {
		this.comm_no = comm_no;
	}

	public Customer getComm_cust_no() {
		return comm_cust_no;
	}

	public void setComm_cust_no(Customer comm_cust_no) {
		this.comm_cust_no = comm_cust_no;
	}

	public String getComm_date() {
		return comm_date;
	}

	public void setComm_date(String comm_date) {
		this.comm_date = comm_date;
	}

	public String getComm_address() {
		return comm_address;
	}

	public void setComm_address(String comm_address) {
		this.comm_address = comm_address;
	}

	public String getComm_title() {
		return comm_title;
	}

	public void setComm_title(String comm_title) {
		this.comm_title = comm_title;
	}

	public String getComm_detail() {
		return comm_detail;
	}

	public void setComm_detail(String comm_detail) {
		this.comm_detail = comm_detail;
	}

	public String getComm_remark() {
		return comm_remark;
	}

	public void setComm_remark(String comm_remark) {
		this.comm_remark = comm_remark;
	}

	public Integer getComm_flag() {
		return comm_flag;
	}

	public void setComm_flag(Integer comm_flag) {
		this.comm_flag = comm_flag;
	}

	@Override
	public String toString() {
		return "CommunicateRecord [comm_no=" + comm_no + ", comm_date=" + comm_date + ", comm_address=" + comm_address + ", comm_title=" + comm_title + "]";
	}

}
