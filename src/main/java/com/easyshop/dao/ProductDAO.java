package com.easyshop.dao;

import java.util.List;

import com.easyshop.models.EsColor;
import com.easyshop.models.EsProduct;

public interface ProductDAO {
	
	public boolean addProduct(EsProduct esProduct);
	
	public boolean addColor(EsColor escolor);

	public List<EsProduct> getAllProduct();

	public List<EsProduct> getProductByCategoryId(EsProduct esProduct);

}
