package com.easyshop.controllers;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.easyshop.models.EsProduct;
import com.easyshop.models.EsUser;
import com.easyshop.services.ProductService;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ProductController {
	
	private static Logger log=Logger.getLogger(ProductController.class);
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	private ProductService productService = new ProductService();

	public void addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		objectMapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
		
		if(request.getMethod().equals("POST")) {
			BufferedReader reader = request.getReader();
			StringBuilder sb = new StringBuilder();
			String line = reader.readLine();
			
			while (line!=null) {
				sb.append(line);
				line = reader.readLine();
			}
			
			String body = new String(sb);
			System.out.println(body);
			EsProduct esProduct = objectMapper.readValue(body, EsProduct.class);
			System.out.println(esProduct);
			
			if(productService.addProduct(esProduct)) {
				response.setStatus(200);
				response.getWriter().print("Product is added Successfully !!...");
			}else {
				HttpSession ses = request.getSession(false);
				if (ses != null) {
					ses.invalidate();
				}
				response.setStatus(400);

				response.getWriter().print("Bad Requested Using Http POST Method");	

			}
			
			
		}
		
		
	}

}
