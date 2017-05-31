package cn.crm.dao;

import java.util.List;

import cn.crm.entity.ServiceManager;

public interface ServiceManagerDAO {

	void save(ServiceManager serviceManager);

	int findCount();

	List<ServiceManager> listPage(int begin, int pageSize);

	List<String> getDuetoManagers();

	ServiceManager findOne(String serv_no);

	void update(ServiceManager serviceManager);

	void delete(ServiceManager serviceManager);

	int findCount2Handle();

	List<ServiceManager> listPage2Handle(int begin, int pageSize);

	void updateHandleService2db(ServiceManager serviceManager);

	int findCount2FeedBack();

	List<ServiceManager> listPage2FeedBack(int begin, int pageSize);

	void updateFeedBackService(ServiceManager serviceManager);

	int findCount2File();

	List<ServiceManager> listPage2File(int begin, int pageSize);

}
