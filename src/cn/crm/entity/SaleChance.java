package cn.crm.entity;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class SaleChance {
	
	private Long chan_no;
	private String chan_cust_name;
	private String chan_source;
	private BigDecimal chan_rate;
	private String chan_title;
	private String chan_linkman;
	private String chan_telephone;
	private Long chan_moblie;
	private String chan_description;
	private String chan_create_by;
	private String chan_create_date;
	private String chan_due_to;
	private String chan_due_date;
	private Integer chan_status;
	private Integer chan_flag;

	//一个销售机会对应多个开发计划
	private Set<SalePlan> salePlans = new HashSet<SalePlan>();
	public Set<SalePlan> getSalePlans() {
		return salePlans;
	}

	public void setSalePlans(Set<SalePlan> salePlans) {
		this.salePlans = salePlans;
	}

	public Long getChan_no() {
		return chan_no;
	}

	public void setChan_no(Long chan_no) {
		this.chan_no = chan_no;
	}

	public String getChan_cust_name() {
		return chan_cust_name;
	}

	public void setChan_cust_name(String chan_cust_name) {
		this.chan_cust_name = chan_cust_name;
	}

	public String getChan_source() {
		return chan_source;
	}

	public void setChan_source(String chan_source) {
		this.chan_source = chan_source;
	}

	public BigDecimal getChan_rate() {
		return chan_rate;
	}

	public void setChan_rate(BigDecimal chan_rate) {
		this.chan_rate = chan_rate;
	}

	public String getChan_title() {
		return chan_title;
	}

	public void setChan_title(String chan_title) {
		this.chan_title = chan_title;
	}

	public String getChan_linkman() {
		return chan_linkman;
	}

	public void setChan_linkman(String chan_linkman) {
		this.chan_linkman = chan_linkman;
	}

	public String getChan_telephone() {
		return chan_telephone;
	}

	public void setChan_telephone(String chan_telephone) {
		this.chan_telephone = chan_telephone;
	}

	public Long getChan_moblie() {
		return chan_moblie;
	}

	public void setChan_moblie(Long chan_moblie) {
		this.chan_moblie = chan_moblie;
	}

	public String getChan_description() {
		return chan_description;
	}

	public void setChan_description(String chan_description) {
		this.chan_description = chan_description;
	}

	public String getChan_create_by() {
		return chan_create_by;
	}

	public void setChan_create_by(String chan_create_by) {
		this.chan_create_by = chan_create_by;
	}

	public String getChan_create_date() {
		return chan_create_date;
	}

	public void setChan_create_date(String chan_create_date) {
		this.chan_create_date = chan_create_date;
	}

	public String getChan_due_to() {
		return chan_due_to;
	}

	public void setChan_due_to(String chan_due_to) {
		this.chan_due_to = chan_due_to;
	}

	public String getChan_due_date() {
		return chan_due_date;
	}

	public void setChan_due_date(String chan_due_date) {
		this.chan_due_date = chan_due_date;
	}

	public Integer getChan_status() {
		return chan_status;
	}

	public void setChan_status(Integer chan_status) {
		this.chan_status = chan_status;
	}

	public Integer getChan_flag() {
		return chan_flag;
	}

	public void setChan_flag(Integer chan_flag) {
		this.chan_flag = chan_flag;
	}
}
