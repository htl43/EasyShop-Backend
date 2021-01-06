package com.easyshop.dao;

import com.easyshop.models.EsUser;
import com.easyshop.models.LoginDTO;

public interface UserDAO {

	
	public EsUser isLogin(LoginDTO userLogin);
	public boolean registerUser(EsUser esUser);
	
	public boolean updateUser(EsUser esUser);
	
	

}
