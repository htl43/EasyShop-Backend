package com.easyshop.services;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Date;

import org.junit.jupiter.api.Test;

import com.easyshop.models.EsUser;
import com.easyshop.models.EsUserContact;
import com.easyshop.models.LoginDTO;

class LoginServiceTest {

	private LoginService ls = new LoginService();
	
	String password = ls.encryptPassword("123456");
	private LoginDTO lDTO = new LoginDTO("us1", "1450575490");
	private LoginDTO invalidDTO = new LoginDTO("us1", "000");
	EsUser esUser = new EsUser();
	
	
	@Test
	void testEncryptPassword() {
		assertNotEquals(ls.encryptPassword("123456"), "123456");
	}
	
	@Test
	void testEncryptPassword2() {
		assertEquals(ls.encryptPassword("123456"), "1450575490");
	}
	
	@Test
	void testValidLogin() {
		assertNotEquals(ls.isLogin(lDTO), false);  
	}
	
	@Test
	void testKillInvalidLogin() {
		assertNull(ls.isLogin(invalidDTO));
	}

	@Test
	void testInvalidCreate() {
		assertEquals(ls.create(esUser), false);
	}
	
	@Test
	void testvalidCreate() {
		assertNotEquals(ls.create(esUser), true);
	}

}
