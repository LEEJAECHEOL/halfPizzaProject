package com.cos.halfPizza.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.domain.menu.dto.MenuListRespDto;
import com.cos.halfPizza.domain.menu.dto.MenuViewReqDto;
import com.cos.halfPizza.domain.menu.dto.MenuViewRespDto;
import com.cos.halfPizza.service.MenuService;

@Controller
public class MenuController {
	
	private MenuService menuService = new MenuService();
	
	@RequestMapping("/menu")
	public String index(HttpServletRequest req) {
		List<MenuListRespDto> menu = menuService.findAll();
		req.setAttribute("menu", menu);
		return "/menu/index.jsp";
	}
	@RequestMapping("/menu/menuView")
	public String detail(MenuViewReqDto dto, HttpServletRequest req) {
		MenuViewRespDto respDto = menuService.메뉴상세보기(dto);
		req.setAttribute("menu", respDto);
		return "/menu/menuView.jsp";
	}
}
