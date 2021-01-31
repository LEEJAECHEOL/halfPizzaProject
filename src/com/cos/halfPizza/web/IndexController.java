package com.cos.halfPizza.web;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.domain.menu.dto.MenuListRespDto;
import com.cos.halfPizza.service.MenuService;

@Controller
public class IndexController {
	
	private MenuService menuService = new MenuService();
	
	@RequestMapping("/index")
	public void index(HttpServletResponse resp, HttpServletRequest req) {
		System.out.println("실행됨?");
//		List<MenuListRespDto> menu = menuService.findAll();
//		req.setAttribute("menu", menu);	
	}
}
