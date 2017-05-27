package cn.crm.entity;

import java.util.HashSet;
import java.util.Set;

public class SysUser {
	
	private Integer user_id;
	private String user_name;
	private String user_password;
	
	//用户里面的所有拜访记录
	private Set<Visit> setUserVisits = new HashSet<Visit>();
	public Set<Visit> getSetUserVisits() {
		return setUserVisits;
	}

	public void setSetUserVisits(Set<Visit> setUserVisits) {
		this.setUserVisits = setUserVisits;
	}

	//一个用户只能拥有一种角色
	private SysRole sysRole;
	public SysRole getSysRole() {
		return sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	private Integer user_flag;

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	

	public Integer getUser_flag() {
		return user_flag;
	}

	public void setUser_flag(Integer user_flag) {
		this.user_flag = user_flag;
	}
}
