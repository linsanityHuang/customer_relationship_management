package cn.crm.entity;

public class CustLinkMan {
	private String link_no;
	
	//表示该联系人所在的客户
	private Customer link_cust_no;
	
	private String link_name;
	private Integer link_sex;
	private String link_position;
	private String link_telephone;
	private Integer link_mobile;
	private String link_remark;
	private Integer link_flag;

	public String getLink_no() {
		return link_no;
	}

	public void setLink_no(String link_no) {
		this.link_no = link_no;
	}

	public Customer getLink_cust_no() {
		return link_cust_no;
	}

	public void setLink_cust_no(Customer link_cust_no) {
		this.link_cust_no = link_cust_no;
	}

	public String getLink_name() {
		return link_name;
	}

	public void setLink_name(String link_name) {
		this.link_name = link_name;
	}

	public Integer getLink_sex() {
		return link_sex;
	}

	public void setLink_sex(Integer link_sex) {
		this.link_sex = link_sex;
	}

	public String getLink_position() {
		return link_position;
	}

	public void setLink_position(String link_position) {
		this.link_position = link_position;
	}

	public String getLink_telephone() {
		return link_telephone;
	}

	public void setLink_telephone(String link_telephone) {
		this.link_telephone = link_telephone;
	}

	public Integer getLink_mobile() {
		return link_mobile;
	}

	public void setLink_mobile(Integer link_mobile) {
		this.link_mobile = link_mobile;
	}

	public String getLink_remark() {
		return link_remark;
	}

	public void setLink_remark(String link_remark) {
		this.link_remark = link_remark;
	}

	public Integer getLink_flag() {
		return link_flag;
	}

	public void setLink_flag(Integer link_flag) {
		this.link_flag = link_flag;
	}
}
