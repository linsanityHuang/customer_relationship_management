package cn.crm.dao;

import java.util.List;

import cn.crm.entity.Storage;

public interface StorageDAO {

	int findCount();

	List<Storage> listPage(int begin, int pageSize);

	List<Storage> multiQuery(Storage storage);

}
