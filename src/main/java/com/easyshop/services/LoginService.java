package com.easyshop.services;

import com.easyshop.dao.UserDAO;
import com.easyshop.dao.impl.UserDAOImpl;
import com.easyshop.models.EsUser;
import com.easyshop.models.LoginDTO;

public class LoginService {
	
	private UserDAO userDAO = new UserDAOImpl();


	public boolean isLogin(LoginDTO userLogin) {
		if(userDAO.isLogin(userLogin)) {
			return true;
		}
		return false;
	}


	
	public boolean create(EsUser esUser) {	
		if(userDAO.registerUser(esUser)) {
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




	
	
	

}
