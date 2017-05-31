package cn.crm.dao;

import cn.crm.entity.CommunicateRecord;

public interface CommunicateRecordDAO {

	void update(CommunicateRecord communicateRecord);

	void addCommunicateRecord2db(CommunicateRecord communicateRecord);

}
