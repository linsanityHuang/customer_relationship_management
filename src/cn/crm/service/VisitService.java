package cn.crm.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.crm.dao.VisitDAO;
import cn.crm.entity.Visit;

@Transactional
public class VisitService {

	private VisitDAO visitDAO;

	public void setVisitDAO(VisitDAO visitDAO) {
		this.visitDAO = visitDAO;
	}

	public void addVisit(Visit visit) {
		visitDAO.add(visit);
	}

	public List<Visit> findAll() {
		return visitDAO.findAll();
	}
}
