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
import com.cos.halfPizza.util.Script;
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
		if(data != null && !data.equals("")) {
			cart = gson.fromJson(data, CartWrap.class);
			System.out.println(cart);
			if(cart.getCartWrap().size() == 0) {
				cart = null;
			}
		}else {
			cart = null;
		}
		if(cart == null) {
			Script.flash(resp, "선택하신 메뉴가 없습니다.주문하실 메뉴를 선택해주세요.", "/halfPizza/menu");
			return;
		}
		req.setAttribute("cart", cart);
		chain.doFilter(req, resp);	
	}

}
