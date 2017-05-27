package cn.crm.dao;

import java.util.List;
import java.util.Map;

import cn.crm.entity.BasicDictionary;

public interface DictionaryDAO {

	Map<String, String> getServices();

	Map<String, String> getRegions();

	Map<String, String> getLevels();

	int findCustLevelCount();

	List<BasicDictionary> getListPageCustLevel(Integer begin, Integer pageSize);

	BasicDictionary findOne(Integer basi_no);

	void update(BasicDictionary dictionary);

	int getMaxCustLevel();

	void add(BasicDictionary dictionary);

	int findServiceTypeCount();

	List<BasicDictionary> getListPageServiceType(int begin, int pageSize);

	int getMaxServiceType();

	int findCustRegionCount();

	List<BasicDictionary> getListPageCustRegion(int begin, int pageSize);

	int getMaxCustRegion();

	Map<String, String> getCredits();

	Map<String, String> getSatisfies();

}
