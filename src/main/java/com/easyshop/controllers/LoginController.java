package com.easyshop.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.easyshop.models.UserLoginProfile;
import com.easyshop.services.LoginService;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoginController {
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	private LoginService loginService = new LoginService();
		
	
	private static final Logger logger = LogManager.getLogger(LoginController.class);

	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		logger.info("login controller is invoked !!...");
		
		if(request.getMethod().equals("POST")) {
			
			BufferedReader bufferReader = request.getReader();
			
			StringBuilder stringBuilder = new StringBuilder();
			
			String line = bufferReader.readLine();
			
			while(line != null) {
				
				stringBuilder.append(line);
				line = bufferReader.readLine();
			}
			
			String body = new String(stringBuilder);
			
			logger.info(" String Body" + body);
			
			UserLoginProfile userLoginProfile =  objectMapper.readValue(body, UserLoginProfile.class);
			
			if(loginService.isLogin(userLoginProfile)) {
				
				System.out.println(" Successfully logined !!......");
			}
			
			
		}
		
		
		
		
	}

	public void registerUser(HttpServletRequest request, HttpServletResponse response) {
		
		
	}

}
