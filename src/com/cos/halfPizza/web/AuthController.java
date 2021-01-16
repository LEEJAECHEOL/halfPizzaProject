package com.cos.halfPizza.web;


import javax.servlet.http.HttpSession;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.domain.auth.dto.LoginReqDto;

@Controller
public class AuthController {
	
	@RequestMapping("/auth/login")
	public String login(LoginReqDto dto, HttpSession session) {
		return "/auth/loginForm.jsp";
	}
	@RequestMapping("/auth/loginProc")
	public void loginProc() {
		System.out.println("loginProc()");
	}
	
	@RequestMapping("/auth/registerTerms")
	public String registerTerms() {
		System.out.println("registerTerms()");
		return "/auth/registerTerms.jsp";
	}
	
	@RequestMapping("/auth/register")
	public void register() {
		System.out.println("register()");
	}
	
	@RequestMapping("/auth/fintId")
	public void findID() {
		System.out.println("findID()");
	}
	
	@RequestMapping("/auth/findPassword")
	public void findPassword() {
		System.out.println("findPassword()");
	}
}
