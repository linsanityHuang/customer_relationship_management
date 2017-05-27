package cn.crm.dao;

import java.util.List;

import cn.crm.entity.CustLinkMan;

public interface LinkManDAO {

	void add(CustLinkMan custLinkMan);

	List<CustLinkMan> list();

	CustLinkMan findOne(String link_no);

	void update(CustLinkMan custLinkMan);

	List<CustLinkMan> findCondition(CustLinkMan custLinkMan);

}
