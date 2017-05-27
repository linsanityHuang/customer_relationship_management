package cn.crm.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.crm.dao.BaseDao;

public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class pClass;
	//构造方法
	public BaseDaoImpl() {
		//第一步 得到当前运行类Class
		Class clazz = this.getClass();
		//CustomerDAOImpl
//		System.out.println("*********"+clazz+"************");
		
		//第二步 得到运行类的父类的参数化类型BaseDaoImpl<Customer>
		// Type getGenericSuperclass()
		// 使用Type子接口 ParameterizedType
		Type type = clazz.getGenericSuperclass();
		ParameterizedType pType = (ParameterizedType) type;
		
//		System.out.println("**********"+pType);
		
		//第三步 得到实际类型参数<Customer>里面Customer
		// Type[] getActualTypeArguments() 
		Type[] types = pType.getActualTypeArguments();
		
		//Type接口的实现类是Class
		Class tClass =  (Class) types[0];
//		System.out.println("****************"+pClass);
		
		this.pClass = tClass;
	}

	//根据id查询
	@SuppressWarnings("all")
	public T findOne(String id) {
		//不能写T.class
		return (T) this.getHibernateTemplate().get(pClass, id);
	}

	//查询所有
	@SuppressWarnings("all")
	public List<T> findAll() {
		//使用Class里面的String getSimpleName() 得到类名称
		return (List<T>) this.getHibernateTemplate().find("from "+pClass.getSimpleName());
	}
		
		
	//添加
	public void add(T t) {
		this.getHibernateTemplate().save(t);
	}

	//修改
	public boolean update(T t) {
		boolean flag = false;
		try {
			this.getHibernateTemplate().update(t);
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return flag;
	}

	//删除
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}
}
