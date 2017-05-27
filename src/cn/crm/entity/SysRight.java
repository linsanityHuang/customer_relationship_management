package cn.crm.entity;

import java.util.HashSet;
import java.util.Set;

public class SysRight {
	private String right_code;
	//自身关联(0个或一个父类权限)
	private SysRight parentRight;
	private String right_type;
	private String right_text;
	private String right_url;
	private String right_tip;

	//一项权限可以赋给多个角色
	private Set<SysRole> sysRoles = new HashSet<SysRole>();
	
	public Set<SysRole> getSysRoles() {
		return sysRoles;
	}

	public void setSysRoles(Set<SysRole> sysRoles) {
		this.sysRoles = sysRoles;
	}

	public String getRight_code() {
		return right_code;
	}

	public void setRight_code(String right_code) {
		this.right_code = right_code;
	}

	public SysRight getParentRight() {
		return parentRight;
	}

	public void setParentRight(SysRight parentRight) {
		this.parentRight = parentRight;
	}

	public String getRight_type() {
		return right_type;
	}

	public void setRight_type(String right_type) {
		this.right_type = right_type;
	}

	public String getRight_text() {
		return right_text;
	}

	public void setRight_text(String right_text) {
		this.right_text = right_text;
	}

	public String getRight_url() {
		return right_url;
	}

	public void setRight_url(String right_url) {
		this.right_url = right_url;
	}

	public String getRight_tip() {
		return right_tip;
	}

	public void setRight_tip(String right_tip) {
		this.right_tip = right_tip;
	}

}
