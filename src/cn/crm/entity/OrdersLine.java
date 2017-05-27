package cn.crm.entity;

public class OrdersLine {
	private Integer line_no;
	private Integer line_count;
	private String line_unit;
	private Integer line_flag;

	public Integer getLine_no() {
		return line_no;
	}

	public void setLine_no(Integer line_no) {
		this.line_no = line_no;
	}

	public Integer getLine_count() {
		return line_count;
	}

	public void setLine_count(Integer line_count) {
		this.line_count = line_count;
	}

	public String getLine_unit() {
		return line_unit;
	}

	public void setLine_unit(String line_unit) {
		this.line_unit = line_unit;
	}

	public Integer getLine_flag() {
		return line_flag;
	}

	public void setLine_flag(Integer line_flag) {
		this.line_flag = line_flag;
	}

}
