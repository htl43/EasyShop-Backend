package com.easyshop.dao;

import com.easyshop.models.EsUser;

public interface UserDAO {
	
	public boolean isLogin(EsUser userLoginProfile);
	public boolean registerUser(EsUser esUser);
	
	

}
