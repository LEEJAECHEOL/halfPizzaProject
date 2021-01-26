package com.cos.halfPizza.service.admin;

import java.util.List;

import com.cos.halfPizza.domain.admin.MenuRepository;
import com.cos.halfPizza.domain.admin.dto.RegistMenuReqDto;
import com.cos.halfPizza.domain.menu.Menu;

public class MenuService {
	private MenuRepository menuRepository;
	
	public MenuService() {
		this.menuRepository = new MenuRepository();
	}
	public int 메뉴등록하기(RegistMenuReqDto dto) {
		return menuRepository.save(dto);
	}
	public List<Menu> 메뉴목록가져오기() {
		return menuRepository.findAll();
	}

}