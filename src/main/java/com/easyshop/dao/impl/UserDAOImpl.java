package com.easyshop.dao.impl;

import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.easyshop.dao.UserDAO;
import com.easyshop.dao.dbutil.HibernateUtil;
import com.easyshop.models.EsCart;
import com.easyshop.models.EsUser;
import com.easyshop.models.LoginDTO;

public class UserDAOImpl implements UserDAO{
	
	private static Logger log=Logger.getLogger(UserDAOImpl.class);

	@Override
	public EsUser isLogin(LoginDTO userLogin) {	
		Session ses = HibernateUtil.getSession();
		EsUser esUser = null;
		long current = System.currentTimeMillis();
		Date now = new Date(current);
		try {
			List<EsUser> esUserList = ses.createQuery(
					"FROM EsUser e WHERE e.username=\'"+ userLogin.username +"\' AND e.password=\'" + userLogin.password +"\'")
					.list();
			
			if(esUserList.size()>0 && esUserList!=null) {
				esUser = esUserList.get(0);
				esUser.setLastLoginDate(now);
			}
			HibernateUtil.closeSession();
			return esUser;
		} catch (Exception e){
			log.warn(e);
			HibernateUtil.closeSession();
			return null;
		}	
		
	}

	@Override
	public boolean registerUser(EsUser esUser) {
		Session ses = HibernateUtil.getSession();
		long current = System.currentTimeMillis();
		Date now = new Date(current);
		esUser.setRegistedDate(now);
		List<EsCart> esCarts = null;
		esUser.setUserCartItem(esCarts);
		System.err.println("Register User: " +esCarts);
		try {
			ses.save(esUser);
			HibernateUtil.closeSession();
			return true;
		} catch (Exception e){
			log.warn(e);
			HibernateUtil.closeSession();
			return false;
		}
	}

	@Override
	public boolean updateUser(EsUser esUser) {
		System.out.println("Updating User:" + esUser);
		Session ses = HibernateUtil.getSession();
		try {
			ses.merge(esUser);
			HibernateUtil.closeSession();
			return true;
		} catch (Exception e){
			log.warn(e);
			HibernateUtil.closeSession();
			return false;
		}	
	}

}
