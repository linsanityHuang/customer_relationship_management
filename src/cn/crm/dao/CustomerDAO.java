package cn.crm.dao;

import java.util.List;
import java.util.Map;

import cn.crm.entity.CommunicateRecord;
import cn.crm.entity.CustLinkMan;
import cn.crm.entity.Customer;
import cn.crm.entity.Orders;

public interface CustomerDAO {

	public void add(Customer customer);

	public List<Customer> findAll();

	public Customer findOne(String cust_no);

	public void delete(Customer customer);

	public boolean update(Customer customer);

	public int findCount();

	public List<Customer> findPage(int begin, int pageSize);

	public List<Customer> findCondition(Customer customer);

	public List<Customer> findMoreCondition(Customer customer);

	public List findCountManager();

	public List findCountLevel();

	public int findMultiQueryCount(Customer customer);

	public List<Customer> multiQuery(Customer customer, int begin, int pageSize);

	public CustLinkMan findLinkMans(String cust_no, String link_no);

	public void deleteLinkMan(String cust_no, String link_no);

	public CommunicateRecord findCommunicateRecord(String cust_no, String comm_no);

	public void deleteCommunicateRecord(String cust_no, String comm_no);

	public Orders findOrder(String cust_no, Integer orde_no);

	public Double getTotalMoney(String cust_no, Integer orde_no);

	public Map<String, String> getCustomers();

	public Map<String, Double> getCustTotalMoney();
}
