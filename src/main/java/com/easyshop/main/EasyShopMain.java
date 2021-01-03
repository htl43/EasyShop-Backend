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
		
		EsCategory esCategory = new EsCategory("Phone","Electronics item",1,true);
		
		
		//EsColor esColor = new EsColor("Black");
		EsColor esColor = new EsColor();
		esColor.setId(1);
		esColor.setColorName("Black");
		//EsColor esColor1 = new EsColor("Red");
//		EsColor esColor2 = new EsColor("Blue",null);
//		EsColor esColor3 = new EsColor("White",null);
//		EsColor esColor4 = new EsColor("Yello",null);
//		
//		
//		
		//EsSize esSize = new EsSize("Large");
		EsSize esSize = new EsSize();
		esSize.setId(1);
		esSize.setSizename("Large");
		//EsSize esSize1 = new EsSize("medium");
//		
//		EsCategory esCategory = new EsCategory("Phone", "All Brand", 1, true);
//		list.add(esCategory);
//		
		EsProduct esProduct = new EsProduct(34578, "iphone7", "iphone11 64 gb", "Apple product", "K23412346", 775.00, esSize, esColor , 0.20, 12, 1, 10, true, true, now, 1, 1, "Good", esCategory);

		
		EsProduct esProduct2 = new EsProduct(34579, "iphoneXR", "iphone11 64 gb", "Apple product", "K23412347", 600.00, esSize, esColor , 0.20, 12, 1, 10, true, true, now, 1, 1, "Good", esCategory);
//		
		productDAO.addProduct(esProduct);
		productDAO.addProduct(esProduct2);
		
		//productDAO.addColor(esColor);
//		productDAO.addColor(esColor1);
//		productDAO.addColor(esColor2);
//		productDAO.addColor(esColor3);
//		productDAO.addColor(esColor4);
		
		
	}

}
