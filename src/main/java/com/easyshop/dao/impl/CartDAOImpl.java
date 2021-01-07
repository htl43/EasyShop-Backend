package com.easyshop.dao.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.easyshop.dao.CartDAO;
import com.easyshop.dao.dbutil.HibernateUtil;
import com.easyshop.models.EsCart;
import com.easyshop.models.EsProduct;

public class CartDAOImpl implements CartDAO {
	
	private static Logger log=Logger.getLogger(UserDAOImpl.class);

	@Override
	public boolean addToCart(EsCart cart) {
		Session ses = HibernateUtil.getSession();
		try {
			ses.save(cart);
			HibernateUtil.closeSession();
			return true; //if product successfully added
		} catch (Exception e) {
			log.warn(e);
			return false; //if product fails to add
		}
	}

	@Override
	public List<EsCart> showCartItems(int esUserId) {
		Session ses = HibernateUtil.getSession();
		List<EsCart> esCartList = null;
		System.out.println("Loading item form userID=" + esUserId);
		try {
//			esCartList = ses.createQuery("FROM EsCart).list();
			esCartList = ses.createQuery("FROM EsCart  WHERE esUser.id=" + esUserId).list();
			if(esCartList.size()>0) {
				System.out.println(esCartList); //to see if it worked		
			} 
			return esCartList;
		} catch (Exception e){
			log.warn(e);
			HibernateUtil.closeSession();

			return null;
		}	
		
	}	
	
	//should we just have a boolean in EsCart called "isOrdered"?
	//and then have a method in CartDAOImpl that changes the boolean from false to true when we click order on a product
	//and another method called showOrderedItems that returns all cart items with isOrdered = true?
	
	
}
