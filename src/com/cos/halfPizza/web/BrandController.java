package com.cos.halfPizza.web;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;

@Controller
public class BrandController {
	@RequestMapping("/brand")
	public String index() {
		return "/brand/company.jsp";
	}
	@RequestMapping("/brand/slogan")
	public String slogan() {
		return "/brand/slogan.jsp";
	}
}
