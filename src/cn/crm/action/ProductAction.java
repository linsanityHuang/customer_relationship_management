package cn.crm.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.crm.entity.PageBean;
import cn.crm.entity.Product;
import cn.crm.service.ProductService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProductAction extends ActionSupport implements ModelDriven<Product>{

	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	private Product product = new Product();
	public Product getModel() {
		return product;
	}

	private Integer currentPage;
	
	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}


	public String showProduct() {
		PageBean pageBean = productService.listPage(currentPage);
		
		ServletActionContext.getRequest().setAttribute("pageBean", pageBean);
		
		return "showProduct";
	}
	
	public String multiQuery() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		List<String> keyWords = new ArrayList<String>();
		if (product.getProd_name() != null && !"".equals(product.getProd_name())) {
			keyWords.add(product.getProd_name());
		}
		if (product.getProd_type() != null && !"".equals(product.getProd_type())) {
			keyWords.add(product.getProd_type());
		}
		if (product.getProd_garde_batch() != null && !"".equals(product.getProd_garde_batch())) {
			keyWords.add(product.getProd_garde_batch());
		}
		
		request.setAttribute("keyWords", keyWords);
		
		List<Product> list = productService.multiQuery(product);
		
		request.setAttribute("list", list);
		
		return "multiQuery";
	}
}
