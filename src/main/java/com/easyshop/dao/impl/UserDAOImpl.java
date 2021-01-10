package com.easyshop.dao.impl;

import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.easyshop.dao.UserDAO;
import com.easyshop.dao.dbutil.HibernateUtil;
import com.easyshop.models.EsCart;
import com.easyshop.models.EsUser;
import com.easyshop.models.EsUserContact;
import com.easyshop.models.LoginDTO;

public class UserDAOImpl implements UserDAO{
	
	private static Logger log=Logger.getLogger(UserDAOImpl.class);

	@Override
	public EsUser isLogin(LoginDTO userLogin) {	
		Session ses = HibernateUtil.getSession();
		Transaction trans = ses.beginTransaction();
		EsUser esUser = null;
		long current = System.currentTimeMillis();
		Date now = new Date(current);
		log.info("Get User Login= " + esUser);
		try {
			esUser = (EsUser)ses.createQuery(
					"FROM EsUser e WHERE e.username=:username AND e.password=:password").setParameter("username", userLogin.username)
					.setParameter("password", userLogin.password).uniqueResult();
			if(esUser!=null) {
//				esUser.setLastLoginDate(now);
//				log.info("User Login=" + esUser);
//				ses.merge(esUser);
				ses.flush();
				trans.commit();
			} else {
				trans.rollback();
			}
			return esUser;
		} catch (Exception e){
			log.warn(e);
			trans.rollback();
			return null;
		}	
		
	}

	@Override
	public boolean registerUser(EsUser esUser) {
		Session ses = HibernateUtil.getSession();
		long current = System.currentTimeMillis();
		Date now = new Date(current);
		esUser.setRegistedDate(now);
		log.info("Register User: " + esUser);
		try {
			ses.saveOrUpdate(esUser);
			HibernateUtil.closeSession();
			return true;
		} catch (Exception e){
			log.warn(e);
			HibernateUtil.closeSession();
			return false;
		}
	}

	@Override
	public boolean updateUser(EsUser newUser) {
		log.info("Updating User=" + newUser);
		Session ses = HibernateUtil.getSession();
		Transaction trans = ses.beginTransaction();
		try {
			ses.merge(newUser);
			ses.flush();
			trans.commit();

			return true;
		} catch (Exception e){
			log.warn(e);
			trans.rollback();

			return false;
		}
	}

	@Override
	public boolean removeItem(EsCart cart) {
		HibernateUtil.closeSession();
		Session ses = HibernateUtil.getSession();
		Transaction trans = ses.beginTransaction();
		try {	
			ses.delete(cart);
			log.info("Cart Item is Been Delete" + cart);
			ses.flush();
			trans.commit();
			return true;
		} catch (Exception e){
			log.warn(e);		
			trans.rollback();
			return false;
		} 
	}

}
