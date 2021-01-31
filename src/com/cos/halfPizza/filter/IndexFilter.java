package com.cos.halfPizza.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		String endPoint = req.getRequestURI().replaceAll(req.getContextPath(), "");
		if(endPoint.equals("/index.jsp")){
			resp.sendRedirect("/halfPizza/");
			return;
		}
		
		chain.doFilter(req, resp);
	}

}