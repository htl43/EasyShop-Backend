package com.easyshop.dao;

import java.util.List;

import com.easyshop.models.EsProduct;

public interface CartDAO {

	public boolean addToCart(EsProduct product);
	
	public List<EsProduct> showCartItems (int cartId);
	
}
