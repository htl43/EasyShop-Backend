package com.easyshop.services;

import com.easyshop.dao.ProductDAO;
import com.easyshop.dao.impl.ProductDAOImp;
import com.easyshop.models.EsProduct;

public class ProductService {
	
	private ProductDAO productDAO = new ProductDAOImp();

	public boolean addProduct(EsProduct esProduct) {
		
		if(productDAO.addProduct(esProduct)) {
			
			return true;
		}
		return false;
	}

}
