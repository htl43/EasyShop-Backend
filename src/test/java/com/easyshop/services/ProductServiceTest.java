package com.easyshop.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import com.easyshop.dao.ProductDAO;
import com.easyshop.dao.impl.ProductDAOImp;
import com.easyshop.models.EsCart;
import com.easyshop.models.EsProduct;

class ProductServiceTest {

	ProductService ps = new ProductService();
	ProductDAO pd = new ProductDAOImp();
	EsProduct validProduct = new EsProduct(1);
	EsCart invalidProduct = new EsCart();
	
	@Test
	void testGetProductByCategoryId() {
		assertNotEquals(ps.getProductByCategoryId(validProduct), null);
	}
	
	@Test
	void testGetProductByCategoryId2() {
		assertEquals(ps.getProductByCategoryId(validProduct), pd.getProductByCategoryId(validProduct));
	}
	
	@Test
	void testinValidCaseAddProduct() {
		assertEquals(ps.addProduct(validProduct), false);
	}
	
	@Test
	void testValidCaseAddProduct() {
		assertNotEquals(ps.addProduct(validProduct), true);
	}
	
	@Test
	void testValidCaseAddProduct2() {
		assertNotEquals(ps.addProduct(validProduct), null);
	}

	@Test
	void testGetAllProduct() {
		assertNotEquals(ps.getAllProduct(), null);
	}
	
	@Test
	void testGetAllProduct2() {
		assertEquals(ps.getAllProduct(), pd.getAllProduct());
	}

}
