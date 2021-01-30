package com.cos.halfPizza.service.admin;

import java.util.List;

import com.cos.halfPizza.domain.admin.AdminRepository;
import com.cos.halfPizza.domain.auth.User;

public class AdminService {
	private AdminRepository adminRepository;
	
	public AdminService() {
		this.adminRepository = new AdminRepository();
	}
	
	public List<User> 회원목록가져오기() {
		return adminRepository.findAll();
	}
}
