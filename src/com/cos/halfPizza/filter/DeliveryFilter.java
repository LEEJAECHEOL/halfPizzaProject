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

import com.cos.halfPizza.domain.delivery.AddrWrap;
import com.google.gson.Gson;

public class DeliveryFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		Cookie[] cookies = req.getCookies();
		String data = null;
		for(int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals("addr")){
				data = URLDecoder.decode(cookies[i].getValue()).replace("path=/halfPizza", "");
				break;
			}
		}
		Gson gson = new Gson();
		
		AddrWrap addr = new AddrWrap();
		if(data != null) {
			addr = gson.fromJson(data, AddrWrap.class);
		}else {
			addr = null;
		}
		System.out.println(addr);
		
		req.setAttribute("addr", addr);
		chain.doFilter(req, resp);
	}

}
