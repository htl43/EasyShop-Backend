package com.easyshop.dao.impl;

import java.util.List;

import org.hibernate.Session;

import com.easyshop.dao.ProductDAO;
import com.easyshop.dao.dbutil.HibernateUtil;
import com.easyshop.models.EsColor;
import com.easyshop.models.EsProduct;

public class ProductDAOImp implements ProductDAO {

	@Override
	public boolean addProduct(EsProduct esProduct) {
		Session ses = HibernateUtil.getSession();
		try {
			ses.save(esProduct);
			HibernateUtil.closeSession();
			return true;
		} catch (Exception e){
			//log.warn(e);
			return false;

		}		

	}

	@Override
	public boolean addColor(EsColor escolor) {
	   Session ses = HibernateUtil.getSession();
	   
	   try {
		   System.out.println("addColor DAO layer ...");
		   ses.save(escolor);
		   HibernateUtil.closeSession();
		   return true;
		   
	   }catch(Exception e) {
		return false;
	   }
	}

	@Override
	public List<EsProduct> getAllProduct() {

		Session ses = HibernateUtil.getSession();
		
		try {
			
			System.out.println("getAllProduct DAO is invoked ..");
			
			List<EsProduct> esProductList = ses.createQuery("FROM EsProduct").list();
			
			return esProductList;
			
		}catch(Exception e) {
			
			
			return null;
		}
		
		
	}

	@Override
	public List<EsProduct> getProductByCategoryId(EsProduct esProduct) {
		
		Session ses = HibernateUtil.getSession();
	
	   try {
			
			System.out.println("getAllProduct DAO is invoked ..");
			
			
			
			List<EsProduct> esProductList = ses.createQuery("From EsProduct Where categoryId =" + esProduct.getCategoryId()).list();
			
			//List<EsProduct> esProductList = ses.get(EsProduct.class,esProduct.getCategoryId().getCategoryId());
			
			return esProductList;
			
		}catch(Exception e) {
			
			
			return null;
		}
	}

}
