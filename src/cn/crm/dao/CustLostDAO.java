package cn.crm.dao;

import java.util.List;

import cn.crm.entity.CustLost;

public interface CustLostDAO {

	int findTotalCount();

	List<CustLost> listPage(int begin, int pageSize);

	List<CustLost> multiQuery(CustLost custLost);

	CustLost findOne(Integer lost_no);

	void update(CustLost custLost);

}
