package com.easyshop.services;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

import com.easyshop.dao.impl.ProductDAOImp;
import com.easyshop.models.EsProduct;

class ProductServiceTest {

	ProductService ps = new ProductService();
	EsProduct validProduct = new EsProduct(1);
	EsProduct invalidProduct = new EsProduct();
	
	@Test
	void testValidCaseAddProduct() {
		assertEquals(ps.addProduct(validProduct), true);
	}
	
	@Test
	void testInValidCaseAddProduct() {
		fail("Not yet implemented");
	}

	@Test
	void testGetAllProduct() {
		assertNotEquals(ps.getAllProduct(), null);
	}

	@Test
	void testGetProductByCategoryId() {
		assertNotEquals(ps.getProductByCategoryId(validProduct), null);
	}

}
