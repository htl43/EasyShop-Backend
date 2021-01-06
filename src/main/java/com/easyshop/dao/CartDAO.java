package com.easyshop.dao;

import java.util.List;

import com.easyshop.models.EsCart;
import com.easyshop.models.EsProduct;

public interface CartDAO {

	public boolean addToCart(EsCart cart);
	
	public List<EsCart> showCartItems (int userId);
	
}
