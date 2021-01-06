package com.easyshop.dao.impl;

import java.sql.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.easyshop.dao.UserDAO;
import com.easyshop.dao.dbutil.HibernateUtil;
import com.easyshop.models.EsUser;
import com.easyshop.models.LoginDTO;

public class UserDAOImpl implements UserDAO{
	
	private static Logger log=Logger.getLogger(UserDAOImpl.class);

	@Override
	public EsUser isLogin(LoginDTO userLogin) {
		
		Session ses = HibernateUtil.getSession();
		Transaction trans = ses.beginTransaction();
		EsUser esUser = null;
		List<EsUser> esUserList = null;
		long current = System.currentTimeMillis();
		Date now = new Date(current);
		try {
			esUserList = ses.createQuery(
					"FROM EsUser e WHERE e.username=\'"+ userLogin.username +"\' AND e.password=\'" + userLogin.password +"\'")
					.list();
			if(esUserList.size()>0 && esUserList!=null) {
				esUser = esUserList.get(0);
				esUser.setLastLoginDate(now);
				ses.merge(esUser);
			}
			ses.flush();
			trans.commit();
			return esUser;
		} catch (Exception e){
			log.warn(e);
			trans.rollback();
			return null;
		}	
		
	}

	@Override
	public boolean registerUser(EsUser esUser) {
		System.out.println("Update User:" + esUser);
		Session ses = HibernateUtil.getSession();
		Transaction trans = ses.beginTransaction();
		long current = System.currentTimeMillis();
		Date now = new Date(current);
		esUser.setRegistedDate(now);
		try {
			ses.save(esUser);
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
	public boolean updateUser(EsUser esUser) {
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
