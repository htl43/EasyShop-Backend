package com.easyshop.main;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.easyshop.dao.ProductDAO;
import com.easyshop.dao.UserDAO;
import com.easyshop.dao.impl.ProductDAOImp;
import com.easyshop.dao.impl.UserDAOImpl;
import com.easyshop.models.EsCategory;
import com.easyshop.models.EsColor;
import com.easyshop.models.EsProduct;
import com.easyshop.models.EsSize;
import com.easyshop.models.EsUser;
import com.easyshop.models.EsUserContact;

public class EasyShopMain {
	
	private static UserDAO userDAO = new UserDAOImpl();
	
	private static ProductDAO productDAO = new ProductDAOImp();

	public static void main(String[] args) {
		
		List<EsCategory> list = new ArrayList<>();

		long current = System.currentTimeMillis();
		Date now = new Date(current);
//		EsUserContact esUserContact = new EsUserContact("Ben", "Petruzziello", "bp@gmail.com", "11111111", 
//				"767 N 44th", "", "Philadelphia", "PA", "19104", "USA");
//		EsUser esUser = new EsUser("htl", "htl43", now, now, esUserContact);
//
//		userDAO.registerUser(esUser);
		
		
		EsColor esColor = new EsColor("Balck");
		
		EsSize esSize = new EsSize("Large");
		
		EsCategory esCategory = new EsCategory("Phone", "All Brand", 1, true);
		list.add(esCategory);
		
		EsProduct esProduct = new EsProduct(34562, "iphone11", "iphone11 64 gb", "Apple product", "K23412337", 900.00, esSize, esColor, 0.20, 12, 1, 10, true, true, now, 1, 1, "Good", list);
		
		productDAO.addProduct(esProduct);
		
		
	}

}
