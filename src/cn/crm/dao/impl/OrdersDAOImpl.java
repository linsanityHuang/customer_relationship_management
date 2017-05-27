package cn.crm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.crm.dao.OrdersDAO;
import cn.crm.entity.Orders;
import cn.crm.utils.HibernateUtils;

public class OrdersDAOImpl implements OrdersDAO{

	@Override
	public List<Orders> getAllOrders() {
		
		Session session = HibernateUtils.getSession();
		
		Transaction tx = session.beginTransaction();
		List<Orders> list = session.createQuery("from Orders").list();
		
		tx.commit();
		session.close();
		
		return list;
	}

}
