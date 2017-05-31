package cn.crm.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import cn.crm.dao.CustomerDAO;
import cn.crm.entity.CommunicateRecord;
import cn.crm.entity.CustLinkMan;
import cn.crm.entity.Customer;
import cn.crm.entity.Orders;
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
		if (currentPage == null) {
			currentPage = 1;
		}
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

	public PageBean multiQuery(Customer customer, Integer currentPage) {

		if (currentPage == null) {
			currentPage = 1;
		}
		PageBean pageBean = new PageBean();
		pageBean.setCurrentPage(currentPage);
		
		int totalCount = customerDAO.findMultiQueryCount(customer);
		pageBean.setTotalCount(totalCount);
		
		int pageSize = 2;
		pageBean.setPageSize(pageSize);
		
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		int begin = (currentPage - 1) * pageSize;
		List<Customer> list = customerDAO.multiQuery(customer, begin, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	public CustLinkMan findLinkMans(String cust_no, String link_no) {
		return customerDAO.findLinkMans(cust_no, link_no);
	}

	public void deleteLinkMan(String cust_no, String link_no) {
		customerDAO.deleteLinkMan(cust_no, link_no);
	}

	public CommunicateRecord findCommunicateRecord(String cust_no, String comm_no) {
		return customerDAO.findCommunicateRecord(cust_no, comm_no);
	}

	public void deleteCommunicateRecord(String cust_no, String comm_no) {
		customerDAO.deleteCommunicateRecord(cust_no, comm_no);
	}

	public Orders findOrder(String cust_no, Integer orde_no) {
		return customerDAO.findOrder(cust_no, orde_no);
	}

	public Double getTotalMoney(String cust_no, Integer orde_no) {
		return customerDAO.getTotalMoney(cust_no, orde_no);
	}

	public Map<String, String> getCustomers() {
		return customerDAO.getCustomers();
	}

	public Map<String, Double> getCustTotalMoney() {
		return customerDAO.getCustTotalMoney();
	}
}
