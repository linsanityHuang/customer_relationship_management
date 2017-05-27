package cn.crm.dao;

import java.util.List;

/**
 * 
 * <p>Title:BaseDao</p>
 * <p>Description: 定义类型T，代表任意类型</p>
 * <p>Company:</p>
 * @author	Administrator
 * @date	2017-5-17 下午7:57:29
 * @version 1.0
 */
public interface BaseDao<T> {

	//添加
	void add(T t);
	
	//修改
	boolean update(T t);
	
	//删除
	void delete(T t);
	
	//根据id查询
	T findOne(String id);
	
	//查询所有
	List<T> findAll();
}
