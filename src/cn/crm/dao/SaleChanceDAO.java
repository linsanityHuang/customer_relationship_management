package cn.crm.dao;

import java.util.List;

import cn.crm.entity.SaleChance;

public interface SaleChanceDAO {

	int findCount();

	List<SaleChance> findPage(int begin, int pageSize);

	SaleChance findOne(Long chan_no);

	void update(SaleChance saleChance);

	List<String> findAllCustManager();

	void add(SaleChance saleChance);

	int multiQueryCount(SaleChance saleChance);

	List<SaleChance> multiQueryResult(SaleChance saleChance, int begin, int pageSize);

}
