package com.cos.halfPizza.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.domain.admin.dto.StoreSaveReqDto;
import com.cos.halfPizza.domain.store.Store;
import com.cos.halfPizza.service.admin.StoreService;
import com.cos.halfPizza.util.Script;

@Controller
public class AdminStoreController {
	
	private StoreService storeService = new StoreService();
	
	@RequestMapping("/admin/store")
	public String index(HttpServletRequest req) {
		List<Store> entityDto = storeService.스토어리스트가져오기();
		req.setAttribute("dto", entityDto);
		return "/admin/store/index.jsp";
	}
	
	@RequestMapping("/admin/store/regist")
	public String regist() {
		return "/admin/store/registForm.jsp";
	}
	
	@RequestMapping("/admin/store/registProc")
	public void registProc(StoreSaveReqDto dto, HttpServletResponse resp) {
		int result = storeService.스토어저장(dto);
		if(result == 1) {
			try {
				resp.sendRedirect("/halfPizza/admin/store");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			Script.back(resp, "입력정보를 확인해주세요.");
		}
	}
}
