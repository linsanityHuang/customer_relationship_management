package cn.crm.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.crm.dao.LinkManDAO;
import cn.crm.entity.CustLinkMan;

@Transactional
public class LinkManService {

	private LinkManDAO linkManDAO;

	public void setLinkManDAO(LinkManDAO linkManDAO) {
		this.linkManDAO = linkManDAO;
	}

	public void addLinkMan(CustLinkMan custLinkMan) {
		linkManDAO.add(custLinkMan);
	}

	public List<CustLinkMan> listLinkMan() {
		return linkManDAO.list();
	}

	public CustLinkMan findOne(String link_no) {
		return linkManDAO.findOne(link_no);
	}

	public void updateLink(CustLinkMan custLinkMan) {
		linkManDAO.update(custLinkMan);
	}

	public List<CustLinkMan> findCondition(CustLinkMan custLinkMan) {
		return linkManDAO.findCondition(custLinkMan);
	}
}
