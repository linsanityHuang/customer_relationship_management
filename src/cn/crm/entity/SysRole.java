package cn.crm.entity;

import java.util.HashSet;
import java.util.Set;

public class SysRole {
	private Integer role_id;
	private String role_name;
	private String role_desc;
	private Integer role_flag;

	//一个角色可以赋给多个用户
	private Set<SysUser> sysUsers = new HashSet<SysUser>();
	
	//一个角色可以拥有多个权限
	private Set<SysRight> sysRights = new HashSet<SysRight>();
	
	public Set<SysRight> getSysRights() {
		return sysRights;
	}

	public void setSysRights(Set<SysRight> sysRights) {
		this.sysRights = sysRights;
	}

	public Set<SysUser> getSysUsers() {
		return sysUsers;
	}

	public void setSysUsers(Set<SysUser> sysUsers) {
		this.sysUsers = sysUsers;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	public String getRole_desc() {
		return role_desc;
	}

	public void setRole_desc(String role_desc) {
		this.role_desc = role_desc;
	}

	public Integer getRole_flag() {
		return role_flag;
	}

	public void setRole_flag(Integer role_flag) {
		this.role_flag = role_flag;
	}

	@Override
	public String toString() {
		return "SysRole [role_id=" + role_id + ", role_name=" + role_name + ", role_desc=" + role_desc + ", role_flag=" + role_flag + "]";
	}

}
