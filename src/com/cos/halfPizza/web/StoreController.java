package com.cos.halfPizza.web;

import javax.servlet.http.HttpServletRequest;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.domain.store.Store;
import com.cos.halfPizza.service.admin.StoreService;

@Controller
public class StoreController {
	
	private StoreService storeService = new StoreService();

	@RequestMapping("/store")
	public String index(HttpServletRequest req) {
		Store entity = storeService.스토어하나가져오기();
		req.setAttribute("dto", entity);
		return "/store/index.jsp";
	}
}
