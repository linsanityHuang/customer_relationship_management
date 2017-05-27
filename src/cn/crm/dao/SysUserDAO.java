package cn.crm.dao;

import java.util.List;

import cn.crm.entity.SysUser;

public interface SysUserDAO {

	public SysUser loginUser(SysUser user);

	public List<SysUser> findAll();

	public int findCount();

	public List<SysUser> findPage(int begin, int pageSize);

	public SysUser findOne(Integer user_id);

	public void update(SysUser user);

	public void add(SysUser user);

	public List<SysUser> multiQuery(SysUser user);
}
