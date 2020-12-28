package com.easyshop.dao;

import com.easyshop.models.UserLoginProfile;
import com.easyshop.models.UserRegister;

public interface UserDAO {
	
	public boolean isLogin(UserLoginProfile userLoginProfile);
	public boolean registerUser(UserLoginProfile userLoginProfile);
	
	
	

}
