package com.easyshop.services;

import org.apache.log4j.Logger;

import com.easyshop.dao.UserDAO;
import com.easyshop.dao.impl.CartDAOImpl;
import com.easyshop.dao.impl.UserDAOImpl;
import com.easyshop.models.EsCart;
import com.easyshop.models.EsUser;
import com.easyshop.models.LoginDTO;

public class LoginService {
	
	private static Logger log=Logger.getLogger(LoginService.class);
	
	private UserDAO userDAO = new UserDAOImpl();


	public EsUser isLogin(LoginDTO userLogin) {
		EsUser eu = userDAO.isLogin(userLogin);
		log.info(eu);
		return eu;
	}

	public boolean create(EsUser esUser) {	
		if(userDAO.registerUser(esUser)) {
			log.info("create user is successfull");
			return true;
		}
		return false;
	}
	
	
	
	public String encryptPassword(String password) {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		String newPassword = String.valueOf(result);
		return newPassword;
	}

	public boolean updateUser(EsUser esUser) {
		return userDAO.updateUser(esUser);
	}

	public boolean removeCart(EsCart esCart) {
		if(esCart!=null) {
			log.info("Removing Cart" + esCart);
			return userDAO.removeItem(esCart);
		}
		return false;
	}




	
	
	

}
