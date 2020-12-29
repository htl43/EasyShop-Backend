package com.easyshop.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.easyshop.controllers.LoginController;
import com.easyshop.dao.UserDAO;
import com.easyshop.dao.dbutil.HibernateUtil;
import com.easyshop.models.EsUser;
import com.easyshop.models.LoginDTO;

public class UserDAOImpl implements UserDAO{

	private static Logger log=Logger.getLogger(UserDAOImpl.class);
	
	@Override
	public EsUser isLogin(LoginDTO userLogin) {
		Session ses = HibernateUtil.getSession();
		try {
			List<EsUser> esUserList = ses.createQuery(
					"FROM EsUser e WHERE e.username=\'"+ userLogin.username +"\' AND e.password=\'" + userLogin.password +"\'")
					.list();
			HibernateUtil.closeSession();
			if(esUserList.size()>0) {
				System.out.println(esUserList.get(0));
				return esUserList.get(0);
			} else {
				return null;
			}
		} catch (Exception e){
			log.warn(e);
			return null;
		}	
		
	}



	@Override
	public boolean registerUser(EsUser esUser) {
		Session ses = HibernateUtil.getSession();
		try {
			ses.save(esUser);
			HibernateUtil.closeSession();
			return true;
		} catch (Exception e){
			log.warn(e);
			return false;
		}			
	}

}
