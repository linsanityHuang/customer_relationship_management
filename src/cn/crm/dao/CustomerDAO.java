package cn.crm.dao;

import java.util.List;

import cn.crm.entity.Customer;

public interface CustomerDAO extends BaseDao<Customer>{

//	public void add(Customer customer);

//	public List<Customer> findAll();

//	public Customer findOne(String cust_no);

//	public void delete(Customer customer);

//	public void update(Customer customer);

	public int findCount();

	public List<Customer> findPage(int begin, int pageSize);

	public List<Customer> findCondition(Customer customer);

	public List<Customer> findMoreCondition(Customer customer);

	public List findCountManager();

	public List findCountLevel();
}
