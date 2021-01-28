package com.cos.halfPizza.service.admin;

import java.util.List;

import com.cos.halfPizza.domain.admin.MenuRepository;
import com.cos.halfPizza.domain.admin.dto.EventUpdateReqDto;
import com.cos.halfPizza.domain.admin.dto.EventUpdateRespDto;
import com.cos.halfPizza.domain.admin.dto.MenuUpdateReqDto;
import com.cos.halfPizza.domain.admin.dto.MenuUpdateRespDto;
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
	public int 메뉴삭제하기(int id) {
		return menuRepository.delete(id);
	}
	public MenuUpdateRespDto 메뉴수정페이지(int id) {
		return menuRepository.updateForm(id);
	}
	public int 메뉴수정하기(MenuUpdateReqDto dto) {
		return menuRepository.update(dto);
	}
}