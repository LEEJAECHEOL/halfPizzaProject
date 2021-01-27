package com.cos.halfPizza.web;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.domain.auth.AuthRepository;
import com.cos.halfPizza.domain.auth.User;
import com.cos.halfPizza.domain.auth.dto.LoginReqDto;
import com.cos.halfPizza.domain.auth.dto.RegisterReqDto;
import com.cos.halfPizza.domain.auth.dto.UpdateChkReqDto;
import com.cos.halfPizza.domain.auth.dto.UpdateReqDto;
import com.cos.halfPizza.service.AuthService;
import com.cos.halfPizza.util.Script;

@Controller
public class AuthController {
	
	private AuthService authService = new AuthService();
	
	@RequestMapping("/auth/login")
	public String login() {
		return "/auth/loginForm.jsp";
	}
	
	@RequestMapping("/auth/myPage")
	public String myPage(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if(session!=null) {
			User user = (User)session.getAttribute("user");
//			int id = user.getId();
//			System.out.println(user);
//			System.out.println(id);
			return "/auth/myPageOrder.jsp";
		}
		else {
			Script.back(response, "로그인 해주세요");
			return "/auth/login";
		}		
	}
	
	@RequestMapping("/auth/updateChk")
	public String updateChk() {
		return "/auth/updateChkForm.jsp";
	}
	
	@RequestMapping("/auth/updateProc")
	public String updateProc(UpdateReqDto dto, HttpServletResponse response, HttpSession session) {
		int result = authService.update(dto);
		if(result == 1) {
			try {
				session.invalidate();
				return "/auth/loginForm.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			Script.back(response, "회원 수정에 실패했습니다.");
		}
		return null;
	}
	
	
	@RequestMapping("/auth/updateChkProc")
	public String updateChkProc(UpdateChkReqDto dto, HttpServletRequest request, HttpServletResponse response) {
		int result = authService.findByIdAndPassword(dto);
		if(result == 1) {
			try {
				return "/auth/update.jsp";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			Script.back(response, "비밀번호를 확인해주세요");
		}
		return null;
	}
	
	@RequestMapping("/auth/loginProc")
	public void loginProc(LoginReqDto dto, HttpSession session, HttpServletResponse response) {
		try {
			User user = authService.findByUsernameAndPassword(dto);
			if(user != null) {
				session.setAttribute("user", user);
				response.sendRedirect("/halfPizza/");
			}else {
				Script.back(response, "로그인 실패.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	public void registerProc(RegisterReqDto dto, HttpServletResponse response) {
//		System.out.println("registerProc() dto : " + dto);
		int result = authService.save(dto);
		if(result == 1) {
			try {
				response.sendRedirect("/halfPizza/");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			Script.back(response, "회원가입실패.");
		}
	}
	@RequestMapping("/auth/logout")
	public void loginout(HttpSession session, HttpServletResponse response) {
		try {
			session.invalidate();
			response.sendRedirect("/halfPizza/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/auth/findPassword")
	public void findPassword() {
		System.out.println("findPassword()");
	}
}