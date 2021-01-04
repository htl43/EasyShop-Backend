package com.easyshop.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.easyshop.models.EsProduct;
import com.easyshop.services.CartService;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CartController {
	
	private static Logger log=Logger.getLogger(LoginController.class);
	private ObjectMapper objectMapper = new ObjectMapper();
	private CartService cartService = new CartService();

	public void addToCart(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

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
			System.out.println(body);
			
			EsProduct product = objectMapper.readValue(body, EsProduct.class);
			System.out.println(product);
			
			if(cartService.addToCart(product)) { //if addToCart method returns true (indicating successful add)
				res.setStatus(200);
				res.getWriter().print("Product added to Cart!");
			}else {
				HttpSession ses = req.getSession(false);
				if (ses != null) {
					ses.invalidate();
				}
				res.setStatus(400);

				res.getWriter().print("Bad POST Request!!");	

			}
			
			
		}
		
		
	}
	
	public void viewCartItems(HttpServletRequest req, HttpServletResponse res) throws IOException {
		List<EsProduct> list = cartService.showCartItems(cartId);
		String json = om.writeValueAsString(list);
		res.getWriter().print(json);
		res.setStatus(200);
	}
	
}
