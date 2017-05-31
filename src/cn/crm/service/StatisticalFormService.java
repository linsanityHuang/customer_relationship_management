package cn.crm.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import cn.crm.dao.StatisticalFormDAO;

@Transactional
public class StatisticalFormService {

	private StatisticalFormDAO statisticalFormDAO;
	public void setStatisticalFormDAO(StatisticalFormDAO statisticalFormDAO) {
		this.statisticalFormDAO = statisticalFormDAO;
	}
	public List serviceAnalysis() {
		return statisticalFormDAO.serviceAnalysis();
	}
}
