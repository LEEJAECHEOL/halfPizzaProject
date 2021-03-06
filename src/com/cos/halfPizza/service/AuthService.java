package com.cos.halfPizza.service;

import com.cos.halfPizza.domain.auth.AuthRepository;
import com.cos.halfPizza.domain.auth.User;
import com.cos.halfPizza.domain.auth.dto.LoginReqDto;
import com.cos.halfPizza.domain.auth.dto.RegisterReqDto;
import com.cos.halfPizza.domain.auth.dto.SelectIdReqDto;
import com.cos.halfPizza.domain.auth.dto.SelectPassReqDto;
import com.cos.halfPizza.domain.auth.dto.UpdateChkReqDto;
import com.cos.halfPizza.domain.auth.dto.UpdateReqDto;
import com.cos.halfPizza.domain.auth.dto.UserEmailCheckReqDto;
import com.cos.halfPizza.domain.auth.dto.UsernameCheckReqDto;

public class AuthService {
	
	private AuthRepository authRepository;
	
	public AuthService() {
		this.authRepository = new AuthRepository();
	}
	
	public int save(RegisterReqDto dto) {
		return authRepository.save(dto);
	}
	public String findByUsername(UsernameCheckReqDto dto) {
		return authRepository.findByUsername(dto);
	}
	public String findByEmail(UserEmailCheckReqDto dto) {
		return authRepository.findByEmail(dto);
	}
	public String findByNameAndEmail(SelectIdReqDto dto) {
		return authRepository.findByNameAndEmail(dto);
	}
	public String findByUsernameAndEmail(SelectPassReqDto dto) {
		return authRepository.findByUsernameAndEmail(dto);
	}
	public User findByUsernameAndPassword(LoginReqDto dto) {
		return authRepository.findByUsernameAndPassword(dto);
	}
	public int findByIdAndPassword(UpdateChkReqDto dto) {
		return authRepository.findByIdAndPassword(dto);
	}
	public int update(UpdateReqDto dto) {
		return authRepository.update(dto);
	}
	
}
