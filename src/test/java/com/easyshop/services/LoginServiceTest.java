package com.easyshop.services;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.easyshop.models.LoginDTO;

class LoginServiceTest {

	private LoginService ls = new LoginService();
	private LoginDTO lDTO = new LoginDTO("us1", "123456");
	private LoginDTO invalidDTO = new LoginDTO("us1", "000");
	
	@Test
	void testIsLogin() {
		assertEquals(ls.isLogin(lDTO), true);
	}
	
	@Test
	void testKillInvalidLogin() {
		assertEquals(ls.isLogin(invalidDTO), true);
	}

	@Test
	void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	void testEncryptPassword() {
		fail("Not yet implemented");
	}

}
