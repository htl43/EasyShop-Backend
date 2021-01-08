package com.easyshop.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.easyshop.dao.CartDAO;
import com.easyshop.dao.impl.CartDAOImpl;
import com.easyshop.models.EsCart;
import com.easyshop.models.EsProduct;
import com.easyshop.models.EsUser;

class CartServiceTest {
	
	CartService cs = new CartService();
	CartDAO cd = new CartDAOImpl();
	EsCart invalidCart = new EsCart();
	EsUser eu = new EsUser();
	EsProduct ep = new EsProduct();
	long millis=System.currentTimeMillis();  
	java.sql.Date date=new java.sql.Date(millis);

	EsCart validCart = new EsCart(1, 10.5, date, eu, ep);



	@Test
	void testAddToCart() {
		assertEquals(cs.addToCart(validCart), false);
	}
	
	@Test
	void testInvalidAddToCart() {
		assertEquals(cs.addToCart(invalidCart), false);
	}
	
	@Test
	void testShowCartItems() {
		assertEquals(cs.showCartItems(1), cd.showCartItems(1));
	}
	
	void testShowCartItems2() {
		assertNotEquals(cs.showCartItems(2), null);
	}

}
