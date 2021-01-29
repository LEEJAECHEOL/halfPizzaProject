package com.cos.halfPizza.web;

import javax.servlet.http.HttpServletRequest;

import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.anno.RestController;
import com.cos.halfPizza.domain.auth.dto.SelectIdReqDto;
import com.cos.halfPizza.domain.auth.dto.SelectPassReqDto;
import com.cos.halfPizza.domain.auth.dto.UserEmailCheckReqDto;
import com.cos.halfPizza.domain.auth.dto.UsernameCheckReqDto;
import com.cos.halfPizza.service.AuthService;

@RestController
public class AuthRestController {
	
	private AuthService authService = new AuthService();
	
	@RequestMapping("/auth/findCheck")
	public String findByUsername(UsernameCheckReqDto dto) {
		return authService.findByUsername(dto);
	}
	
	@RequestMapping("/auth/findEmailCheck")
	public String findByEmail(UserEmailCheckReqDto dto) {
		System.out.println(dto.getEmail());
		return authService.findByEmail(dto);
	}
	
	@RequestMapping("/auth/findMyEmail")
	public String findByNameAndEmail(SelectIdReqDto dto,HttpServletRequest request) {
		System.out.println(dto.getName());
		System.out.println(dto.getEmail());
		return authService.findByNameAndEmail(dto);
	}
	
	@RequestMapping("/auth/findByUsername")
	public String findByUsernameAndEmail(SelectPassReqDto dto,HttpServletRequest request) {
		System.out.println(dto.getName());
		System.out.println(dto.getEmail());
		System.out.println(dto.getUsername());
		return authService.findByUsernameAndEmail(dto);
	}
}
