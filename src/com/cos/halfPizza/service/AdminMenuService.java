package com.cos.halfPizza.service;

import com.cos.halfPizza.domain.admin.MenuRepository;
import com.cos.halfPizza.domain.admin.dto.RegistMenuReqDto;

public class AdminMenuService {
	private MenuRepository menuRepository;
	
	public AdminMenuService() {
		this.menuRepository = new MenuRepository();
	}
	public int save(RegistMenuReqDto dto) {
		return menuRepository.save(dto);
	}

}
