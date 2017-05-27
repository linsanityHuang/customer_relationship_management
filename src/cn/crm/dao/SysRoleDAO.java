package cn.crm.dao;

import java.util.List;
import java.util.Map;

import cn.crm.entity.SysRole;

public interface SysRoleDAO {

	Map<Integer, String> getAllRoles();

	int findCount();

	List<SysRole> findPage(int begin, int pageSize);

	SysRole findOne(Integer role_id);
	
}
