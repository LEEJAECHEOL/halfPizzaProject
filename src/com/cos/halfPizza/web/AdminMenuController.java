package com.cos.halfPizza.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.domain.admin.dto.CommonRespDto;
import com.cos.halfPizza.domain.admin.dto.MenuFileDeleteRespDto;
import com.cos.halfPizza.domain.admin.dto.MenuUpdateReqDto;
import com.cos.halfPizza.domain.admin.dto.MenuUpdateRespDto;
import com.cos.halfPizza.domain.admin.dto.MenuRegistReqDto;
import com.cos.halfPizza.domain.menu.Menu;
import com.cos.halfPizza.service.admin.MenuService;
import com.cos.halfPizza.util.FileManage;
import com.cos.halfPizza.util.Script;
import com.google.gson.Gson;

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
	public void registProc(MenuRegistReqDto dto, HttpServletResponse resp, HttpServletRequest req) {
		
		int result = adminMenuService.메뉴등록하기(dto);
		if(result == 1) {
			try {
				resp.sendRedirect("/halfPizza/admin/menu/list");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			// 디비에 정보를 넣기전에 이미지는 이미 업로드가 되기때문이 지워주어야 함.
			FileManage.deleteFile(dto.getPath(), dto.getChangeFileName1(), req);
			Script.back(resp, "입력하신 정보를 다시 확인해주세요.");
		}
	}
	
	@RequestMapping("/admin/menu/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("아이디 : "+id);
		int result = adminMenuService.메뉴삭제하기(id);
		CommonRespDto<String> commonRespDto = new CommonRespDto();
		
		commonRespDto.setStatusCode(result);
		commonRespDto.setData("성공");
		
		Gson gson = new Gson();
		String respData = gson.toJson(commonRespDto);
		PrintWriter out = response.getWriter();
		out.print(respData);
		out.flush();
	}
	
	@RequestMapping("/admin/menu/updateForm")
	public String updateForm(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		MenuUpdateRespDto dto = adminMenuService.메뉴수정페이지(id);
		request.setAttribute("dto", dto);
		return "/admin/menu/updateForm.jsp";
	}
	
	@RequestMapping("/admin/menu/updateProc")
	public void update(MenuUpdateReqDto dto, HttpServletResponse response, HttpServletRequest request) {
		MenuFileDeleteRespDto file = adminMenuService.파일명가져오기(dto.getId());
		int result = adminMenuService.메뉴수정하기(dto);
		if(result == 1) {
			FileManage.deleteFile(file.getPath(), file.getChangeFileName1(), request);
			try {
				response.sendRedirect("/halfPizza/admin/menu/list");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			// 디비에 정보를 넣기전에 이미지는 이미 업로드가 되기때문이 지워주어야 함.
			FileManage.deleteFile(dto.getPath(), dto.getChangeFileName1(), request);
			Script.back(response, "입력하신 정보를 다시 확인해주세요.");
		}
	}
}