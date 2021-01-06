package com.easyshop.web;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.easyshop.controllers.CartController;
import com.easyshop.controllers.LoginController;
import com.easyshop.controllers.ProductController;



public class EasyShopServlet extends HttpServlet{
	
	private LoginController loginController = new LoginController();
	private CartController cartController = new CartController();
	private ProductController productController = new ProductController();
	
	private static Logger log=Logger.getLogger(EasyShopServlet.class);
	
	
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
	  
	  log.info(" Program is starting ....");
	  
	  response.setContentType("application.json");
	  
	  
	  response.setStatus(404);
	  
	  final String URI = request.getRequestURI().replace("/EasyShop/","");
	  
	  switch(URI) {
	  
	  	case "login" :		  
			  log.info("login request is invoked !!....");
			  loginController.login(request,response);
			  break;
			  
	  	case "register" :
	  		  System.out.println("Register is invoked!!");
			  log.info("Register request is invoked !!....");
			  loginController.registerUser(request, response);
			  break;    
			  
	  	case "viewCart" :
	  		  System.out.println("View cart is invoked!!");
			  log.info("View cart request is invoked !!....");
			  cartController.viewCartItems(request, response);
			  break;

			  
	  	case "getProduct" :
	  		  System.out.println("getProduct is invoked!!");
			  log.info("getProduct request is invoked !!....");
			  productController.getProduct(request, response);

			  break;
			  
	  	case "getProductByCategoryId" :
	  		  System.out.println("getProductByCategoryId is invoked!!");
			  log.info("getProductByCategoryId request is invoked !!....");
			  productController.getProductByCategoryId(request, response);

			  break;
//			  
//	  	case "category" :
//	  		  System.out.println("Register is invoked!!");
//			  log.info("Register request is invoked !!....");
//			  loginController.registerUser(request, response);
//
//			  break;	
			  
			  
	  	case "addToCart" :
	  		  System.out.println("Add to cart is invoked!!");
			  log.info("Add to cart request is invoked !!....");
			  cartController.addToCart(request, response);
			  break;
		  
	  }
	  
  }
  
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	 log.info(" doPost method is invoked !!....");
	 doGet(request, response);
	 
	 
	  
  }
	

}
