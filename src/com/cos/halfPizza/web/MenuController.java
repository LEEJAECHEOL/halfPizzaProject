package com.cos.halfPizza.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.domain.menu.Optional;
import com.cos.halfPizza.domain.menu.dto.MenuListRespDto;
import com.cos.halfPizza.domain.menu.dto.MenuViewReqDto;
import com.cos.halfPizza.domain.menu.dto.MenuViewRespDto;
import com.cos.halfPizza.service.MenuService;
import com.cos.halfPizza.service.OptionalService;

@Controller
public class MenuController {
	
	private MenuService menuService = new MenuService();
	private OptionalService OptionalService = new OptionalService();
	
	@RequestMapping("/menu")
	public String index(HttpServletRequest req, HttpServletResponse resp) {
		String gubun = req.getParameter("gubun");
		if(gubun == null) {
			gubun ="pizza";
		}
		List<MenuListRespDto> menu = menuService.findAll(gubun);
		req.setAttribute("menu", menu);	
		if(gubun.equals("pizza")) {
			return "/menu/index.jsp";
		}else if(gubun.equals("oneplus")) {
			return "/menu/onePlus.jsp";
		}else if(gubun.equals("set")) {
			return "/menu/set.jsp";
		}else if(gubun.equals("side")) {
			return "/menu/side.jsp";
		}else {
			try {
				resp.sendRedirect("/halfPizza/menu");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	@RequestMapping("/menu/menuView")
	public String detail(MenuViewReqDto dto, HttpServletRequest req) {
		String gubun = req.getParameter("gubun");
		if(gubun == null) {
			gubun ="pizza";
		}
		MenuViewRespDto respDto = menuService.메뉴상세보기(dto);
		List<Optional> opt = OptionalService.추가선택목록가져오기();
		req.setAttribute("menu", respDto);
		req.setAttribute("optional", opt);
		if(gubun.equals("pizza")) {
			return "/menu/menuView.jsp";
		}else if(gubun.equals("oneplus")) {
			return "/menu/onePlusView.jsp";
		}else if(gubun.equals("set")) {
			return "/menu/setView.jsp";
		}else if(gubun.equals("side")) {
			return "/menu/sideView.jsp";
		}
		return "/menu/menuView.jsp";
	}
}