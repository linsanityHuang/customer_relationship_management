package cn.crm.entity;

public class BasicDictionary {

	private Integer basi_no;	//数据字典编号，主键, 非空
	private String basi_type;	//数据字典类型, 非空
	private String basi_item;	//数据字典标题, 非空
	private String basi_value;	//数据字典内容, 非空
	private Integer basi_editable;	//数据字典可编辑状态(0/1) , 非空
	private Integer basi_flag;	//数据字典标识（0:已删除/1:未删除）, 非空

	public Integer getBasi_no() {
		return basi_no;
	}

	public void setBasi_no(Integer basi_no) {
		this.basi_no = basi_no;
	}

	public String getBasi_type() {
		return basi_type;
	}

	public void setBasi_type(String basi_type) {
		this.basi_type = basi_type;
	}

	public String getBasi_item() {
		return basi_item;
	}

	public void setBasi_item(String basi_item) {
		this.basi_item = basi_item;
	}

	public String getBasi_value() {
		return basi_value;
	}

	public void setBasi_value(String basi_value) {
		this.basi_value = basi_value;
	}

	public Integer getBasi_editable() {
		return basi_editable;
	}

	public void setBasi_editable(Integer basi_editable) {
		this.basi_editable = basi_editable;
	}

	public Integer getBasi_flag() {
		return basi_flag;
	}

	public void setBasi_flag(Integer basi_flag) {
		this.basi_flag = basi_flag;
	}

	@Override
	public String toString() {
		return "BasicDictionary [basi_no=" + basi_no + ", basi_type=" + basi_type + ", basi_item=" + basi_item + ", basi_value=" + basi_value + ", basi_editable=" + basi_editable
				+ ", basi_flag=" + basi_flag + "]";
	}
}
