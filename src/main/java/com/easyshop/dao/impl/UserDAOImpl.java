package com.easyshop.dao.impl;

import org.hibernate.Session;

import com.easyshop.dao.UserDAO;
import com.easyshop.dao.dbutil.HibernateUtil;
import com.easyshop.models.UserLoginProfile;
import com.easyshop.models.UserRegister;

public class UserDAOImpl implements UserDAO{

	@Override
	public boolean isLogin(UserLoginProfile userLoginProfile) {
		
		Session session = HibernateUtil.getSession();
		
		
		
		return false;
	}



	@Override
	public boolean registerUser(UserLoginProfile userLoginProfile) {
		
		Session session = HibernateUtil.getSession();
		
		System.out.println(userLoginProfile);
		
		if(userLoginProfile != null) {
			
			System.out.println("Before Register");
			
			
			
			session.save(userLoginProfile);
			
			System.out.println("After Register");
			
			return true;
			
		}

		return false;
	}

}
