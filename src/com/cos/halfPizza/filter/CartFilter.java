package com.cos.halfPizza.filter;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.halfPizza.domain.cart.CartWrap;
import com.cos.halfPizza.domain.delivery.AddrWrap;
import com.google.gson.Gson;

public class CartFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		Cookie[] cookies = req.getCookies();
		String data = null;
		for(int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals("cart")){
				data = URLDecoder.decode(cookies[i].getValue()).replace("path=/halfPizza", "");
				break;
			}
		}
		Gson gson = new Gson();
		CartWrap cart = new CartWrap();
		if(data != null) {
			cart = gson.fromJson(data, CartWrap.class);
		}else {
			cart = null;
		}
		req.setAttribute("cart", cart);
		chain.doFilter(req, resp);	
	}

}
