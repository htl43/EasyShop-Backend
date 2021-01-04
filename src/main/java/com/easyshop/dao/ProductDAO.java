package com.easyshop.dao;

import com.easyshop.models.EsColor;
import com.easyshop.models.EsProduct;

public interface ProductDAO {
	
	public boolean addProduct(EsProduct esProduct);
	
	public boolean addColor(EsColor escolor);

}
