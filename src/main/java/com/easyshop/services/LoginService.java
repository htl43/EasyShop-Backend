package com.easyshop.services;

import com.easyshop.dao.UserDAO;
import com.easyshop.dao.impl.UserDAOImpl;
import com.easyshop.models.UserLoginProfile;

public class LoginService {
	
	private UserDAO userDAO = new UserDAOImpl();


	public boolean isLogin(UserLoginProfile userLoginProfile) {
		
		userDAO.isLogin(userLoginProfile);
		return false;
	}


	public boolean registerUser(UserLoginProfile userLoginProfile) {
		
		return userDAO.registerUser(userLoginProfile);
		
	}
	
	

}
