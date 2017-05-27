package cn.crm.entity;

import java.util.HashSet;
import java.util.Set;

public class Product {
	private Integer prod_no;
	private String prod_name;
	private String prod_type;
	private String prod_garde_batch;
	private String prod_unit;
	private String prod_price;
	private String prod_remark;
	private Integer prod_flag;

	/**
	 * 关联Storage，调用该商品的库存信息
	 */
	private Storage storage;
	
	//一种商品可以在多个订单中存在
	private Set<Orders> orders = new HashSet<Orders>();
	
	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	public Integer getProd_no() {
		return prod_no;
	}

	public void setProd_no(Integer prod_no) {
		this.prod_no = prod_no;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public String getProd_type() {
		return prod_type;
	}

	public void setProd_type(String prod_type) {
		this.prod_type = prod_type;
	}

	public String getProd_garde_batch() {
		return prod_garde_batch;
	}

	public void setProd_garde_batch(String prod_garde_batch) {
		this.prod_garde_batch = prod_garde_batch;
	}

	public String getProd_unit() {
		return prod_unit;
	}

	public void setProd_unit(String prod_unit) {
		this.prod_unit = prod_unit;
	}

	public String getProd_price() {
		return prod_price;
	}

	public void setProd_price(String prod_price) {
		this.prod_price = prod_price;
	}

	public String getProd_remark() {
		return prod_remark;
	}

	public void setProd_remark(String prod_remark) {
		this.prod_remark = prod_remark;
	}

	public Integer getProd_flag() {
		return prod_flag;
	}

	public void setProd_flag(Integer prod_flag) {
		this.prod_flag = prod_flag;
	}
}
