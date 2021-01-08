package com.easyshop.services;


import java.util.List;

import org.apache.log4j.Logger;

import com.easyshop.dao.ProductDAO;
import com.easyshop.dao.impl.CartDAOImpl;
import com.easyshop.dao.impl.ProductDAOImp;
import com.easyshop.models.EsProduct;

public class ProductService {
	
	private static Logger log=Logger.getLogger(ProductService.class);
	
	private ProductDAO productDAO = new ProductDAOImp();

	public boolean addProduct(EsProduct esProduct) {
		
		if(productDAO.addProduct(esProduct)) {
			log.info("add product is successful");
			return true;
		}
		return false;
	}

	public List<EsProduct> getAllProduct() {
		
		return productDAO.getAllProduct();
	}
	
	

	public List<EsProduct> getProductByCategoryId(EsProduct esProduct) {
		return productDAO.getProductByCategoryId(esProduct);
	}

}
