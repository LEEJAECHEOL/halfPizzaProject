package com.cos.halfPizza.service;

import java.util.List;

import com.cos.halfPizza.domain.menu.MenuRepository;
import com.cos.halfPizza.domain.menu.dto.MenuListRespDto;

public class MenuService {
	
	private MenuRepository menuRepository = new MenuRepository();
	
	public List<MenuListRespDto> findAll(){
		return menuRepository.findAll();
	}
	
}
