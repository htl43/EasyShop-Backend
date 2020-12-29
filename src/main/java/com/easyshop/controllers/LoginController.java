package com.easyshop.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.easyshop.models.EsUser;
import com.easyshop.models.LoginDTO;
import com.easyshop.services.LoginService;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;


public class LoginController {
	
	private static Logger log=Logger.getLogger(LoginController.class);
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	private LoginService loginService = new LoginService();
		
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		objectMapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
		
		log.info("login controller is invoked !!...");
		
		BufferedReader bufferReader = request.getReader();
		
		StringBuilder stringBuilder = new StringBuilder();
		
		String line = bufferReader.readLine();
		
		while(line != null) {
			
			stringBuilder.append(line);
			line = bufferReader.readLine();
		}
		
		String body = new String(stringBuilder);
		
		log.info(" String Body" + body);
		
		LoginDTO userLogin =  objectMapper.readValue(body, LoginDTO.class);
		userLogin.password = loginService.encryptPassword(userLogin.password);
				
		EsUser esUser = loginService.isLogin(userLogin);
		if(esUser!=null) {		
			esUser.setPassword(""); // send empty password to fron-tend
			String json = objectMapper.writeValueAsString(esUser);
			response.getWriter().print(json);
			response.setStatus(200);		
			HttpSession ses = request.getSession();	
			ses.setAttribute("user", esUser);
			ses.setAttribute("loggedin", true);
			log.info("Successfully logined !!......");
		} else {
			response.setStatus(401);
			response.getWriter().print("Failed logined !!......");
			log.info("Failed logined !!......");
		}
									
	}

	public void registerUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		objectMapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
		if(req.getMethod().equals("POST")) {		
			BufferedReader reader = req.getReader();
			StringBuilder sb = new StringBuilder();
			String line = reader.readLine();
			
			while (line!=null) {
				sb.append(line);
				line = reader.readLine();
			}
			
			String body = new String(sb);
			EsUser ersUser = objectMapper.readValue(body, EsUser.class);
			System.out.println(ersUser);
			ersUser.setPassword(loginService.encryptPassword(ersUser.getPassword()));
			if(loginService.create(ersUser)) {
				resp.setStatus(200);
				resp.getWriter().print("Account has been created successfully");
			} else {
				resp.setStatus(403);
			}											
			
		} else {
			HttpSession ses = req.getSession(false);
			if (ses != null) {
				ses.invalidate();
			}
			resp.setStatus(400);
			resp.getWriter().print("Bad Requested Using Http GET Method");	
		}
		
	}

}
