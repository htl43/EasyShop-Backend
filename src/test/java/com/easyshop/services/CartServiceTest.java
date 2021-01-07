package com.easyshop.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.easyshop.models.EsCart;

class CartServiceTest {
	
	CartService cs = new CartService();
	EsCart validCart = new EsCart();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAddToCart() {
		assertEquals(cs.addToCart(validCart), true);
	}

	@Test
	void testShowCartItems() {
		assertNotEquals(cs.showCartItems(1), null);
	}

}
