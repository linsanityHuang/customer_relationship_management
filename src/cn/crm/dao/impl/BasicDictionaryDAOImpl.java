package cn.crm.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.crm.dao.BasicDictionaryDAO;
import cn.crm.entity.BasicDictionary;
import cn.crm.utils.HibernateUtils;

public class BasicDictionaryDAOImpl implements BasicDictionaryDAO{

	@Override
	public List<BasicDictionary> getAllBasicDictionaries() {
		Session session = HibernateUtils.getSession();
		Transaction tx = session.beginTransaction();
		List<BasicDictionary> list = session.createQuery("from BasicDictionary").list();
		
		tx.commit();
		session.close();
		return list;
	}

	@Override
	public boolean addBasicDictionary(BasicDictionary basicDictionary) {
		boolean flag = false;
		Session session = HibernateUtils.getSession();
		
		Transaction tx = session.beginTransaction();
		try {
			session.save(basicDictionary);
			tx.commit();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		return flag;
	}

	@Override
	public boolean updateBasicDictionary(BasicDictionary basicDictionary) {
		boolean flag = false;
		Session session = HibernateUtils.getSession();
		
		Transaction tx = session.beginTransaction();
		try {
			session.update(basicDictionary);
			tx.commit();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		return flag;
	}

	@Override
	public boolean deleteBasicDictionary(BasicDictionary basicDictionary) {
		boolean flag = false;
		Session session = HibernateUtils.getSession();
		
		Transaction tx = session.beginTransaction();
		try {
			session.delete(basicDictionary);
			tx.commit();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
		}
		return flag;
	}
}
