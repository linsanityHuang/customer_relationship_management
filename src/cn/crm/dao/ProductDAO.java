package cn.crm.dao;

import java.util.List;

import cn.crm.entity.Product;

public interface ProductDAO {

	int findCount();

	List<Product> findPage(int begin, int pageSize);

	List<Product> multiQuery(Product product);

}
