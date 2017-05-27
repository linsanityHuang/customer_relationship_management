package cn.crm.entity;

public class Storage {
	private Integer stor_no;
	private Product product;
	private String stor_storehouse;
	private String stor_location;
	private Integer stor_count;
	private String stor_remark;
	private Integer stor_flag;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getStor_no() {
		return stor_no;
	}

	public void setStor_no(Integer stor_no) {
		this.stor_no = stor_no;
	}

	public String getStor_storehouse() {
		return stor_storehouse;
	}

	public void setStor_storehouse(String stor_storehouse) {
		this.stor_storehouse = stor_storehouse;
	}

	public String getStor_location() {
		return stor_location;
	}

	public void setStor_location(String stor_location) {
		this.stor_location = stor_location;
	}

	public Integer getStor_count() {
		return stor_count;
	}

	public void setStor_count(Integer stor_count) {
		this.stor_count = stor_count;
	}

	public String getStor_remark() {
		return stor_remark;
	}

	public void setStor_remark(String stor_remark) {
		this.stor_remark = stor_remark;
	}

	public Integer getStor_flag() {
		return stor_flag;
	}

	public void setStor_flag(Integer stor_flag) {
		this.stor_flag = stor_flag;
	}
}
