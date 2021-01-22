package com.cos.halfPizza.web;

import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.anno.RestController;
import com.cos.halfPizza.domain.auth.dto.UsernameCheckReqDto;
import com.cos.halfPizza.service.AuthService;

@RestController
public class AuthRestController {
	
	private AuthService authService = new AuthService();
	
	@RequestMapping("/auth/findCheck")
	public String findByUsername(UsernameCheckReqDto dto) {
		return authService.findByUsername(dto);
	}
}
