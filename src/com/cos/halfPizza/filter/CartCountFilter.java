package com.cos.halfPizza.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartCountFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		Cookie[] cookies = req.getCookies();
		int cartCount = 0;
		for(int i = 0; i < cookies.length; i++ ) {
			if(cookies[i].getName().contains("cart")) {
				cartCount++;
			}
		}
		req.setAttribute("cartCount", cartCount);
		
		chain.doFilter(req, resp);
	}

}
