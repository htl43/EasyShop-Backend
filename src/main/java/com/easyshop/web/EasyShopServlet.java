package com.easyshop.web;


import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.easyshop.controllers.LoginController;

public class EasyShopServlet extends HttpServlet{
	
	private LoginController loginController = new LoginController();
	
	private static final Logger logger = LogManager.getLogger(EasyShopServlet.class);
	
	
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
	  
	  
	  logger.info(" Program is starting ....");
	  
	  response.setContentType("application.json");
	  
	  
	  response.setStatus(404);
	  
	  final String URI = request.getRequestURI().replace("/EasyShop/","");
	  
	  switch(URI) {
	  
	  case "login" :
		  
		  System.out.println("Hello EasyShop Welcome....");
		  
		  logger.info("login request is invoked !!....");
		  loginController.login(request,response);
		  break;
		  
	  case "register" :
		  
		  //if(request.getSession(false) != null) {
			  System.out.println("Hello EasyShop Welcome....");
			  
			  logger.info("login request is invoked !!....");
			  loginController.registerUser(request,response);
		  
		  //}else {
			 // response.setStatus(403);
		 // }
		  
		  break;	  
		  
		  
	  }
	  
  }
  
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
	 
	 logger.info(" doPost method is invoked !!....");
	 doGet(request, response);
	 
	 
	  
  }
	

}
