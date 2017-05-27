package cn.crm.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.crm.dao.CustomerDAO;
import cn.crm.entity.Customer;
import cn.crm.entity.PageBean;

//事务注解
@Transactional
public class CustomerService {

	private CustomerDAO customerDAO;

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	public void add(Customer customer) {
		customerDAO.add(customer);
	}

	public List<Customer> findAll() {
		return customerDAO.findAll();
	}

	public Customer findOne(String cust_no) {
		return customerDAO.findOne(cust_no);
	}

	public void delete(Customer customer) {
		customerDAO.delete(customer);
	}

	public boolean update(Customer customer) {
		return customerDAO.update(customer);
	}

	// 封装分页数据到pagebean对象里面
	public PageBean listpage(Integer currentPage) {
		// 创建PageBean对象
		PageBean pageBean = new PageBean();
		// 当前页
		pageBean.setCurrentPage(currentPage);
		// 总记录数
		int totalCount = customerDAO.findCount();
		pageBean.setTotalCount(totalCount);

		// 每页显示记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);

		// 总页数
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		//开始位置
		int begin = (currentPage - 1)* pageSize;
		pageBean.setBegin(begin);
		
		//每页记录的list集合
		List<Customer> list = customerDAO.findPage(begin, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	public List<Customer> findCondition(Customer customer) {
		// TODO Auto-generated method stub
		return customerDAO.findCondition(customer);
	}

	public List<Customer> findMoreCondition(Customer customer) {
		return customerDAO.findMoreCondition(customer);
	}

	public List findCountManager() {
		return customerDAO.findCountManager();
	}

	public List findCountLevel() {
		return customerDAO.findCountLevel();
	}
}
