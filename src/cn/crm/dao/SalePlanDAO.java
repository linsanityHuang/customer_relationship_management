package cn.crm.dao;

import java.io.Serializable;
import java.util.List;

import cn.crm.entity.SalePlan;

public interface SalePlanDAO {

	int findCount();

	List<SalePlan> listPage(int begin, int pageSize);

	List<SalePlan> multiQuery(SalePlan salePlan);

	SalePlan findOne(Integer plan_no);

	void update(SalePlan salePlan);

	Serializable save(SalePlan salePlan);

	SalePlan get(Serializable plan_no);

}
