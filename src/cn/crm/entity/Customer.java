package cn.crm.entity;

import java.util.HashSet;
import java.util.Set;

public class Customer {

	private String cust_no; // 客户编号，主键，非空
	private String cust_name; // 客户名称 , 非空
	private int cust_region; // 客户所在地区,参照数据字典表
	private String cust_manager_name; // 负责客户的经理名称, 非空
	private int cust_level; // 客户等级， 参照数据字典表
	private int cust_satisfy; // 客户满意度， 参照数据字典表
	private int cust_credit; // 客户信誉度，参照数据字典表
	private String cust_address; // 客户所在地址
	private int cust_zip; // 客户邮政编码
	private String cust_fax; // 客户传真
	private String cust_telephone; // 客户办公电话
	private String cust_website; // 客户网址
	private String cust_licenc_no; // 客户营业执照编号
	private String cust_corporation; // 客户法人
	private String cust_registered_capital; // 客户注册资金(万元)
	private String cust_turnover; // 客户年营业额(万元)
	private String cust_bank; // 客户开户银行
	private String cust_bank_account; // 客户银行账号
	private String cust_local_tax_no; // 客户地税登记号
	private String cust_national_tax_no; // 客户国税登记号
	private int cust_flag; // 客户标识（0:已删除/1:未删除）, 非空
	
	//一个客户对应数据字典表中多条记录：cust_region、cust_level、cust_satisfy、cust_credit
//	private BasicDictionary basicDictionary;
//	
//	public BasicDictionary getBasicDictionary() {
//		return basicDictionary;
//	}
//
//	public void setBasicDictionary(BasicDictionary basicDictionary) {
//		this.basicDictionary = basicDictionary;
//	}

	public int getCust_region() {
		return cust_region;
	}

	public void setCust_region(int cust_region) {
		this.cust_region = cust_region;
	}

	public int getCust_level() {
		return cust_level;
	}

	public void setCust_level(int cust_level) {
		this.cust_level = cust_level;
	}

	public int getCust_satisfy() {
		return cust_satisfy;
	}

	public void setCust_satisfy(int cust_satisfy) {
		this.cust_satisfy = cust_satisfy;
	}

	public int getCust_credit() {
		return cust_credit;
	}

	public void setCust_credit(int cust_credit) {
		this.cust_credit = cust_credit;
	}

	//一个客户里面所有拜访记录
	private Set<Visit> setCusVisits = new HashSet<Visit>();
	
	public Set<Visit> getSetCusVisits() {
		return setCusVisits;
	}

	public void setSetCusVisits(Set<Visit> setCusVisits) {
		this.setCusVisits = setCusVisits;
	}

	private Set<Orders> orders = new HashSet<Orders>(); // 每个客户都对应多个订单
	private Set<CommunicateRecord> communicateRecords = new HashSet<CommunicateRecord>();
	
	//表示该客户下的所有联系人
	private Set<CustLinkMan> custLinkMans = new HashSet<CustLinkMan>();
	
	private Set<CustLost> custLosts = new HashSet<CustLost>();
	private Set<ServiceManager> serviceManagers = new HashSet<ServiceManager>();

	public String getCust_no() {
		return cust_no;
	}

	public void setCust_no(String cust_no) {
		this.cust_no = cust_no;
	}

	public String getCust_name() {
		return cust_name;
	}

	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}

//	public int getCust_region() {
//		return cust_region;
//	}
//
//	public void setCust_region(int cust_region) {
//		this.cust_region = cust_region;
//	}

	public String getCust_manager_name() {
		return cust_manager_name;
	}

	public void setCust_manager_name(String cust_manager_name) {
		this.cust_manager_name = cust_manager_name;
	}

//	public int getCust_level() {
//		return cust_level;
//	}
//
//	public void setCust_level(int cust_level) {
//		this.cust_level = cust_level;
//	}
//
//	public int getCust_satisfy() {
//		return cust_satisfy;
//	}
//
//	public void setCust_satisfy(int cust_satisfy) {
//		this.cust_satisfy = cust_satisfy;
//	}
//
//	public int getCust_credit() {
//		return cust_credit;
//	}
//
//	public void setCust_credit(int cust_credit) {
//		this.cust_credit = cust_credit;
//	}

	public String getCust_address() {
		return cust_address;
	}

	public void setCust_address(String cust_address) {
		this.cust_address = cust_address;
	}

	public int getCust_zip() {
		return cust_zip;
	}

	public void setCust_zip(int cust_zip) {
		this.cust_zip = cust_zip;
	}

	public String getCust_fax() {
		return cust_fax;
	}

	public void setCust_fax(String cust_fax) {
		this.cust_fax = cust_fax;
	}

	public String getCust_telephone() {
		return cust_telephone;
	}

	public void setCust_telephone(String cust_telephone) {
		this.cust_telephone = cust_telephone;
	}

	public String getCust_website() {
		return cust_website;
	}

	public void setCust_website(String cust_website) {
		this.cust_website = cust_website;
	}

	public String getCust_licenc_no() {
		return cust_licenc_no;
	}

	public void setCust_licenc_no(String cust_licenc_no) {
		this.cust_licenc_no = cust_licenc_no;
	}

	public String getCust_corporation() {
		return cust_corporation;
	}

	public void setCust_corporation(String cust_corporation) {
		this.cust_corporation = cust_corporation;
	}

	public String getCust_registered_capital() {
		return cust_registered_capital;
	}

	public void setCust_registered_capital(String cust_registered_capital) {
		this.cust_registered_capital = cust_registered_capital;
	}

	public String getCust_turnover() {
		return cust_turnover;
	}

	public void setCust_turnover(String cust_turnover) {
		this.cust_turnover = cust_turnover;
	}

	public String getCust_bank() {
		return cust_bank;
	}

	public void setCust_bank(String cust_bank) {
		this.cust_bank = cust_bank;
	}

	public String getCust_bank_account() {
		return cust_bank_account;
	}

	public void setCust_bank_account(String cust_bank_account) {
		this.cust_bank_account = cust_bank_account;
	}

	public String getCust_local_tax_no() {
		return cust_local_tax_no;
	}

	public void setCust_local_tax_no(String cust_local_tax_no) {
		this.cust_local_tax_no = cust_local_tax_no;
	}

	public String getCust_national_tax_no() {
		return cust_national_tax_no;
	}

	public void setCust_national_tax_no(String cust_national_tax_no) {
		this.cust_national_tax_no = cust_national_tax_no;
	}

	public int getCust_flag() {
		return cust_flag;
	}

	public void setCust_flag(int cust_flag) {
		this.cust_flag = cust_flag;
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	public Set<CommunicateRecord> getCommunicateRecords() {
		return communicateRecords;
	}

	public void setCommunicateRecords(Set<CommunicateRecord> communicateRecords) {
		this.communicateRecords = communicateRecords;
	}

	public Set<CustLinkMan> getCustLinkMans() {
		return custLinkMans;
	}

	public void setCustLinkMans(Set<CustLinkMan> custLinkMans) {
		this.custLinkMans = custLinkMans;
	}

	public Set<CustLost> getCustLosts() {
		return custLosts;
	}

	public void setCustLosts(Set<CustLost> custLosts) {
		this.custLosts = custLosts;
	}

	public Set<ServiceManager> getServiceManagers() {
		return serviceManagers;
	}

	public void setServiceManagers(Set<ServiceManager> serviceManagers) {
		this.serviceManagers = serviceManagers;
	}
}
