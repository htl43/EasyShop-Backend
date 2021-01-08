package com.easyshop.services;

import java.util.List;

import org.apache.log4j.Logger;

import com.easyshop.dao.CartDAO;
import com.easyshop.dao.impl.CartDAOImpl;
import com.easyshop.models.EsCart;

public class CartService {
	
	private static Logger log=Logger.getLogger(CartService.class);

	private CartDAO cartDAO = new CartDAOImpl();
	
	public boolean addToCart(EsCart cart) {
		if(cartDAO.addToCart(cart)){
			log.info("add cart is successfull");
			return true;
		}else {
			log.info("add cart is failed");
			return false;}
	}
	
	public List<EsCart> showCartItems(int userId) {
		return cartDAO.showCartItems(userId);
	}
	
}
