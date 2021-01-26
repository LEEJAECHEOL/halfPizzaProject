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
		List<Menu> menu = adminMenuService.�޴���ϰ�������();
		req.setAttribute("menu", menu);
		return "/admin/menu/index.jsp";
	}
	
	@RequestMapping("/admin/menu/regist")
	public String regist() {
		return "/admin/menu/registForm.jsp";
	}
	
	@RequestMapping("/admin/menu/registProc")
	public void registProc(RegistMenuReqDto dto, HttpServletResponse resp, HttpServletRequest req) {
		int result = adminMenuService.�޴�����ϱ�(dto);
		if(result == 1) {
			try {
				resp.sendRedirect("/halfPizza/admin/menu/list");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			// ��� ������ �ֱ����� �̹����� �̹� ���ε尡 �Ǳ⶧���� �����־�� ��.
			File file = new File(req.getSession().getServletContext().getRealPath(dto.getPath()) + dto.getChangeFileName());
			if(file.exists()) {
				file.delete();
			}
			Script.back(resp, "�Է��Ͻ� ������ �ٽ� Ȯ�����ּ���.");
		}
	}
	
	
}