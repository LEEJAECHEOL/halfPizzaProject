package com.cos.halfPizza.web;


import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.domain.auth.dto.LoginReqDto;
import com.cos.halfPizza.domain.auth.dto.RegisterReqDto;
import com.cos.halfPizza.service.AuthService;
import com.cos.halfPizza.util.Script;

@Controller
public class AuthController {
	
	private AuthService authService = new AuthService();
	
	@RequestMapping("/auth/login")
	public String login() {
		return "/auth/loginForm.jsp";
	}
	@RequestMapping("/auth/loginProc")
	public void loginProc(LoginReqDto dto, HttpSession session) {
		System.out.println("loginProc()");
	}
	
	@RequestMapping("/auth/registerTerms")
	public String registerTerms() {
		return "/auth/registerTerms.jsp";
	}
	
	@RequestMapping("/auth/register")
	public String register() {
		System.out.println("register()");
		return "/auth/registerForm.jsp";
	}

	@RequestMapping("/auth/registerProc")
	public String registerProc(RegisterReqDto dto, HttpServletResponse response) {
//		System.out.println("registerProc() dto : " + dto);
		int result = authService.save(dto);
		if(result == 1) {
			return "/auth/loginForm.jsp";
		}else {
			Script.back(response, "입력정보를 다시 확인해주세요.");
			return null;
		}
	}
	
	
	@RequestMapping("/auth/findPassword")
	public void findPassword() {
		System.out.println("findPassword()");
	}
}
