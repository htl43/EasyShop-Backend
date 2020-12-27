package com.easyshop.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.easyshop.controllers.LoginController;

public class CorsFilter implements Filter {
	
	private static final Logger logger = LogManager.getLogger(CorsFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		logger.info("doFilter is invoked !! ...");
		
		System.out.println("CORS Filter leveraged ...");
		
		if(!(response instanceof HttpServletResponse)) {
			
			chain.doFilter(request, response);
			return;
			
		}
		
		// For Setting headers which is specified to HTTP
		
		HttpServletResponse res = (HttpServletResponse) response;
		
		res.setHeader("Access-Control-Allow-Origin", "null"); // Allow all origins
		
		res.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
		// Allow specific HTTP Verbs
				
		res.setHeader("Access-Control-Allow-Headers", "Origin, Accept, X-Requested-With, Content-Type,"
						+ "Access-Control-Request-Method, Access-Control-Request-Headers");
		// Allow specific HTTP Headers (there's a fair few)
				
		res.setHeader("Access-Control-Allow-Credentials", "true");
		// Credentials are allowed
				
		chain.doFilter(request, response);
		// Continue the filter chain
	
		
		
	}

}
