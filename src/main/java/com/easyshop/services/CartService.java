package com.easyshop.services;

import java.util.List;

import com.easyshop.dao.CartDAO;
import com.easyshop.dao.impl.CartDAOImpl;
import com.easyshop.models.EsProduct;

public class CartService {

	private CartDAO cartDAO = new CartDAOImpl();
	
	public boolean addToCart(EsProduct product) {
		if(cartDAO.addToCart(product)){
			return true;
		}else {return false;}
	}
	
	public List<EsProduct> showCartItems(int cartId) {
		return cartDAO.showCartItems(cartId);
	}
	
}
