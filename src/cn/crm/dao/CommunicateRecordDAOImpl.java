package cn.crm.dao;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.crm.entity.CommunicateRecord;

public class CommunicateRecordDAOImpl extends HibernateDaoSupport implements CommunicateRecordDAO {

	@Override
	public void update(CommunicateRecord communicateRecord) {
		this.getHibernateTemplate().update(communicateRecord);
	}

	@Override
	public void addCommunicateRecord2db(CommunicateRecord communicateRecord) {
		this.getHibernateTemplate().save(communicateRecord);
	}

}
