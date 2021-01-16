package com.cos.halfPizza.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.domain.auth.dto.LoginReqDto;

@Controller
public class AuthController {
	
	@RequestMapping("/auth/login")
	public void login(LoginReqDto dto,HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("login() : " + req.getParameter("username"));
		System.out.println("login()");
	}
	@RequestMapping("/auth/loginProc")
	public void loginProc() {
		System.out.println("loginProc()");
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
