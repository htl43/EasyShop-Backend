package com.easyshop.dao.impl;

import org.hibernate.Session;

import com.easyshop.dao.UserDAO;
import com.easyshop.dao.dbutil.HibernateUtil;
import com.easyshop.models.EsUser;
import com.easyshop.models.EsUserContact;

public class UserDAOImpl implements UserDAO{

	@Override
	public boolean isLogin(EsUser userLoginProfile) {
		
		
		
		return false;
	}



	@Override
	public boolean registerUser(EsUser esUser) {
		Session ses = HibernateUtil.getSession();
		try {
			ses.save(esUser);
			HibernateUtil.closeSession();
			return true;
		} catch (Exception e){
			return false;
		}		
		

	}

}
