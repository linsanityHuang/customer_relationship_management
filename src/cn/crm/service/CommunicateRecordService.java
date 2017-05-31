package cn.crm.service;

import org.springframework.transaction.annotation.Transactional;

import cn.crm.dao.CommunicateRecordDAO;
import cn.crm.entity.CommunicateRecord;

@Transactional
public class CommunicateRecordService {

	private CommunicateRecordDAO communicateRecordDAO;
	public void setCommunicateRecordDAO(CommunicateRecordDAO communicateRecordDAO) {
		this.communicateRecordDAO = communicateRecordDAO;
	}
	public void updateRecord(CommunicateRecord communicateRecord) {
		communicateRecordDAO.update(communicateRecord);
	}
	public void addCommunicateRecord2db(CommunicateRecord communicateRecord) {
		communicateRecordDAO.addCommunicateRecord2db(communicateRecord);
	}
}
