package cn.crm.entity;

import java.util.HashSet;
import java.util.Set;

public class Orders {

	private Integer orde_no;
	private Customer orde_cust_no;
	private String  orde_date;
	private String  orde_address;
	private Integer orde_status;
	private Integer orde_flag;
	
	private Set<OrdersLine> ordersLines = new HashSet<OrdersLine>();
	public Set<OrdersLine> getOrdersLines() {
		return ordersLines;
	}
	public void setOrdersLines(Set<OrdersLine> ordersLines) {
		this.ordersLines = ordersLines;
	}
	
	//一张订单可以涉及多种商品
	/*private Set<Product> products = new HashSet<Product>();
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}*/
	
	
	public Integer getOrde_no() {
		return orde_no;
	}
	public void setOrde_no(Integer orde_no) {
		this.orde_no = orde_no;
	}
	public Customer getOrde_cust_no() {
		return orde_cust_no;
	}
	public void setOrde_cust_no(Customer orde_cust_no) {
		this.orde_cust_no = orde_cust_no;
	}
	public String getOrde_date() {
		return orde_date;
	}
	public void setOrde_date(String orde_date) {
		this.orde_date = orde_date;
	}
	public String getOrde_address() {
		return orde_address;
	}
	public void setOrde_address(String orde_address) {
		this.orde_address = orde_address;
	}
	public Integer getOrde_status() {
		return orde_status;
	}
	public void setOrde_status(Integer orde_status) {
		this.orde_status = orde_status;
	}
	public Integer getOrde_flag() {
		return orde_flag;
	}
	public void setOrde_flag(Integer orde_flag) {
		this.orde_flag = orde_flag;
	}
	
}
