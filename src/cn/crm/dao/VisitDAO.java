package cn.crm.dao;

import java.util.List;

import cn.crm.entity.Visit;

public interface VisitDAO {

	void add(Visit visit);

	List<Visit> findAll();

}
