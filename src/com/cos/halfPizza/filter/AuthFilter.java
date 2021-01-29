package com.cos.halfPizza.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.halfPizza.util.Script;

public class AuthFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		String[] exclusions = {"/auth/myPage", "/auth/updateChk", "/auth/updateProc", "/auth/updateChkProc"};
		
		String endPoint = req.getRequestURI().replaceAll(req.getContextPath(), "");
		
		HttpSession session = req.getSession();
		for (String exclusion : exclusions) {
			if(endPoint.contains(exclusion)) {
				if(session.getAttribute("user") == null) {
					Script.back(resp, "로그인 후 이용해주세요.");
				}
			}
		}
		
		
		chain.doFilter(req, resp);
	}

}
