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

import com.cos.halfPizza.domain.auth.User;
import com.cos.halfPizza.util.Script;

public class AdminFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		HttpSession session = req.getSession();
		
		if(session.getAttribute("user") == null) {
			Script.back(resp, "로그인 후 이용해주세요.");
			return;
		}
		User user = (User)session.getAttribute("user");
		if(user.getRole().equals("USER")) {
			Script.back(resp, "이용권한이 없습니다. 관리자에게 문의해주세요.");
			return;
		}
		chain.doFilter(req, resp);
	}

}
