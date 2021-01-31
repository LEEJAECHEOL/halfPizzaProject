package com.cos.halfPizza.web;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;

@Controller
public class EmployController {
	@RequestMapping("/community/employment")
	public String slogan() {
		return "/community/employment.jsp";
	}
}
