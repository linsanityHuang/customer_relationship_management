package cn.crm.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import cn.crm.dao.ProductDAO;
import cn.crm.entity.PageBean;
import cn.crm.entity.Product;

@Transactional
public class ProductService {

	private ProductDAO productDAO;
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
	public PageBean listPage(Integer currentPage) {
		if (currentPage == null) {
			currentPage = 1;
		}
		
		PageBean pageBean = new PageBean();
		
		pageBean.setCurrentPage(currentPage);
		
		int totalCount = productDAO.findCount();
		pageBean.setTotalCount(totalCount);
		
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		
		// 总页数
		int totalPage = 0;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		
		int begin = (currentPage - 1) * pageSize;
		pageBean.setBegin(begin);
		
		List<Product> list = productDAO.findPage(begin, pageSize);
		pageBean.setList(list);
		
		return pageBean;
	}

	public List<Product> multiQuery(Product product) {
		return productDAO.multiQuery(product);
	}
}
