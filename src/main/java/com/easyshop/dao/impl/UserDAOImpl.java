package com.easyshop.dao.impl;

import org.hibernate.Session;

import com.easyshop.dao.UserDAO;
import com.easyshop.dao.dbutil.HibernateUtil;
import com.easyshop.models.EsUser;
import com.easyshop.models.EsUserContact;

public class UserDAOImpl implements UserDAO{

	@Override
	public boolean isLogin(EsUser userLoginProfile) {
		
		Session session = HibernateUtil.getSession();
		
		
		
		return false;
	}



	@Override
<<<<<<< HEAD
	public boolean registerUser(EsUser esUser) {
		Session ses = HibernateUtil.getSession();
		try {
			ses.save(esUser);
			return true;
		} catch (Exception e){
			return false;
		}		
=======
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
>>>>>>> ffa064c371b2689e94712b2c7d9270cc197bbb0c
	}

}
