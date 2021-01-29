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

public class AddrFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		Cookie[] cookies = req.getCookies();
		
		String value = null;
		for(int i = 0; i < cookies.length; i++ ) {
			if(cookies[i].getName().equals("selectedAddr")) {
				value =  URLDecoder.decode(cookies[i].getValue()).replace("path=/halfPizza", "");
				req.setAttribute("selectedAddr", value);
				break;
			}
		}
		chain.doFilter(req, resp);
	}

}
