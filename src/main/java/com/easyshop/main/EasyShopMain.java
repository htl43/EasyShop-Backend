package com.easyshop.main;

import java.sql.Date;

import com.easyshop.dao.UserDAO;
import com.easyshop.dao.impl.UserDAOImpl;
import com.easyshop.models.EsUser;
import com.easyshop.models.EsUserContact;

public class EasyShopMain {
	
	private static UserDAO userDAO = new UserDAOImpl();

	public static void main(String[] args) {

		long current = System.currentTimeMillis();
		Date now = new Date(current);
		EsUserContact esUserContact = new EsUserContact("Ben", "Petruzziello", "bp@gmail.com", "11111111", 
				"767 N 44th", "", "Philadelphia", "PA", "19104", "USA");
		EsUser esUser = new EsUser("htl", "htl43", now, now, esUserContact);

		userDAO.registerUser(esUser);

	}

}
