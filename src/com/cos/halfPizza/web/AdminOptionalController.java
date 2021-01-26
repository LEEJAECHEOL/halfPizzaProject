package com.cos.halfPizza.web;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.domain.admin.dto.RegistOptionalReqDto;
import com.cos.halfPizza.domain.menu.Menu;
import com.cos.halfPizza.domain.menu.Optional;
import com.cos.halfPizza.service.admin.OptionalService;
import com.cos.halfPizza.util.Script;

@Controller
public class AdminOptionalController {
	
	OptionalService optionalService = new OptionalService();
	
	@RequestMapping("/admin/optional")
	public String index(HttpServletRequest req) {
		List<Optional> opt = optionalService.추가선택목록가져오기();
		req.setAttribute("optional", opt);
		
		return "/admin/optional/index.jsp";
	}
	@RequestMapping("/admin/optional/regist")
	public String regist() {
		return "/admin/optional/registForm.jsp";
	}
	@RequestMapping("/admin/optional/registProc")
	public void registProc(RegistOptionalReqDto dto, HttpServletResponse resp) {
		int result = optionalService.추가선택등록하기(dto);
		if(result == 1) {
			try {
				resp.sendRedirect("/halfPizza/admin/optional");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			Script.back(resp, "입력하신 정보를 다시 확인해주세요.");
		}
	}
}