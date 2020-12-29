package com.easyshop.dao;

import com.easyshop.models.EsUser;
import com.easyshop.models.EsUserContact;

public interface UserDAO {
	
	public boolean isLogin(EsUser userLoginProfile);
	public boolean registerUser(EsUser esUser);
	
	

}
