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
	public List<EsProduct> showCartItems(int cartId) {
//		Session ses = HibernateUtil.getSession();
//		try {
//			List<EsProduct> esProductList = ses.createQuery(
//				"FROM es_cart where cartid =\'" + cartId + "'\'"); //is this correct lol
//			HibernateUtil.closeSession();
//			if(esProductList.size()>0) {
//				System.out.println(esProductList); //to see if it worked
//				return esProductList;
//			} else {
//				return null;
//			}
//		} catch (Exception e){
//			log.warn(e);
			return null;
//		}	
		
	}	
	
}
