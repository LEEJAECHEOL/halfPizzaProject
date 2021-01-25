package com.cos.halfPizza.service;

import java.util.List;

import com.cos.halfPizza.domain.menu.MenuRepository;
import com.cos.halfPizza.domain.menu.dto.MenuListRespDto;
import com.cos.halfPizza.domain.menu.dto.MenuViewReqDto;
import com.cos.halfPizza.domain.menu.dto.MenuViewRespDto;

public class MenuService {
	
	private MenuRepository menuRepository = new MenuRepository();
	
	public List<MenuListRespDto> findAll(){
		return menuRepository.findAll();
	}
	public MenuViewRespDto 메뉴상세보기(MenuViewReqDto dto) {
		return menuRepository.findById(dto);
	}
	
}
