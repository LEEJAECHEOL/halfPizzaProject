package com.cos.halfPizza.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.domain.admin.dto.RegistMenuReqDto;
import com.cos.halfPizza.domain.menu.Menu;
import com.cos.halfPizza.service.admin.MenuService;
import com.cos.halfPizza.util.Script;

@Controller
public class AdminMenuController {
	
	private MenuService adminMenuService = new MenuService();
	
	@RequestMapping("/admin/menu/list")
	public String index(HttpServletRequest req) {
		List<Menu> menu = adminMenuService.메뉴목록가져오기();
		req.setAttribute("menu", menu);
		return "/admin/menu/index.jsp";
	}
	
	@RequestMapping("/admin/menu/regist")
	public String regist() {
		return "/admin/menu/registForm.jsp";
	}
	
	@RequestMapping("/admin/menu/registProc")
	public void registProc(RegistMenuReqDto dto, HttpServletResponse resp, HttpServletRequest req) {
		int result = adminMenuService.메뉴등록하기(dto);
		if(result == 1) {
			try {
				resp.sendRedirect("/halfPizza/admin/menu/list");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			// 디비에 정보를 넣기전에 이미지는 이미 업로드가 되기때문이 지워주어야 함.
			File file = new File(req.getSession().getServletContext().getRealPath(dto.getPath()) + dto.getChangeFileName());
			if(file.exists()) {
				file.delete();
			}
			Script.back(resp, "입력하신 정보를 다시 확인해주세요.");
		}
	}
	
	
}
