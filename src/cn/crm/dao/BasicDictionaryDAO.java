package cn.crm.dao;

import java.util.List;

import cn.crm.entity.BasicDictionary;

public interface BasicDictionaryDAO {

	//增加数据字典条目
	public boolean addBasicDictionary(BasicDictionary basicDictionary);
	//修改数据字典条目
	public boolean updateBasicDictionary(BasicDictionary basicDictionary);
	//删除数据字典条目
	public boolean deleteBasicDictionary(BasicDictionary basicDictionary);
	//查看数据字典条目
	public List<BasicDictionary> getAllBasicDictionaries();
}
