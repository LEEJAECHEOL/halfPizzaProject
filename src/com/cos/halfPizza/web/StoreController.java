package com.cos.halfPizza.web;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;

@Controller
public class StoreController {

	@RequestMapping("/store")
	public String index() {
		return "/store/index.jsp";
	}
}
