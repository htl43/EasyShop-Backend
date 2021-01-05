package com.easyshop.main;

import java.sql.Date;
import java.util.List;

import com.easyshop.dao.CartDAO;
import com.easyshop.dao.UserDAO;
import com.easyshop.dao.impl.CartDAOImpl;
import com.easyshop.dao.impl.UserDAOImpl;
import com.easyshop.models.EsCart;
import com.easyshop.models.EsOrder;
import com.easyshop.models.EsProduct;
import com.easyshop.models.EsUser;

public class EasyShopMain {
	
	private static UserDAO userDAO = new UserDAOImpl();
	private static CartDAO cartDAO = new CartDAOImpl();

	public static void main(String[] args) {
//		long current = System.currentTimeMillis();
//		Date now = new Date(current);
//		EsUserContact esUserContact = new EsUserContact("Ben", "Petruzziello", "bp@gmail.com", "11111111", 
//				"767 N 44th", "", "Philadelphia", "PA", "19104", "USA");
//		EsUser esUser = new EsUser("htl", "htl43", now, now, esUserContact);
//		
//		userDAO.registerUser(esUser);
		

		
		int cartId = 1;
		double finalPrice = 300.00;
		Date dateAdded = new Date(new java.util.Date().getTime());
		EsUser esUser = new EsUser(2);
		EsProduct product = new EsProduct(1);
		//List<EsOrder> orderedProducts = null;
		
		EsCart ec = new EsCart(cartId, finalPrice, dateAdded, esUser, product);

		cartDAO.addToCart(ec);
		
	}

}
