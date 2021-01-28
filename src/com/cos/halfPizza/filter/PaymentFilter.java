package com.cos.halfPizza.filter;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.halfPizza.domain.cart.CartWrap;
import com.cos.halfPizza.util.Script;
import com.google.gson.Gson;

public class PaymentFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		Cookie[] cookies = req.getCookies();
		String cartData = null;
		String addrData = null;
		Gson gson = new Gson();
		for(int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals("cart")){
				cartData = URLDecoder.decode(cookies[i].getValue()).replace("path=/halfPizza", "");
				break;
			}
		}
		for(int i = 0; i < cookies.length; i++ ) {
			if(cookies[i].getName().equals("selectedAddr")) {
				addrData =  URLDecoder.decode(cookies[i].getValue()).replace("path=/halfPizza", "");
				break;
			}
		}
		if(cartData == null || cartData.equals("")) {
			Script.flash(resp, "선택하신 메뉴가 없습니다.주문하실 메뉴를 선택해주세요.", "/halfPizza/menu");
			return;
		}
		if(addrData == null) {
			Script.flash(resp, "등록된 배송지가 없습니다.배송지를 선택해주세요.", "/halfPizza/delivery");
			return;
		}
		CartWrap cart = new CartWrap();
		cart = gson.fromJson(cartData, CartWrap.class);
		req.setAttribute("cart", cart);
		req.setAttribute("selectedAddr", addrData);
		
		chain.doFilter(req, resp);
	}

}
