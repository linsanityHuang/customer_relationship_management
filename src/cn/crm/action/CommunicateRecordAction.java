package cn.crm.action;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.crm.entity.CommunicateRecord;
import cn.crm.entity.Customer;
import cn.crm.service.CommunicateRecordService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CommunicateRecordAction extends ActionSupport implements ModelDriven<CommunicateRecord>{

	private CommunicateRecord communicateRecord = new CommunicateRecord();
	@Override
	public CommunicateRecord getModel() {
		return communicateRecord;
	}

	private CommunicateRecordService communicateRecordService;
	public void setCommunicateRecordService(CommunicateRecordService communicateRecordService) {
		this.communicateRecordService = communicateRecordService;
	}
	
	public String updateCommunicateRecord() {
		
		communicateRecordService.updateRecord(communicateRecord);
		
		HttpServletRequest request = ServletActionContext.getRequest();
		
		Customer customer = communicateRecord.getComm_cust_no();
		
		Set<CommunicateRecord> records = customer.getCommunicateRecords();
		
		request.setAttribute("customer", customer);
		request.setAttribute("records", records);
		
		//返回交往记录页面
		return "updateCommunicateRecord";
	}
	
	public String addCommunicateRecord2db() {
		communicateRecordService.addCommunicateRecord2db(communicateRecord);
		
		return "addCommunicateRecord2db";
	}
}
