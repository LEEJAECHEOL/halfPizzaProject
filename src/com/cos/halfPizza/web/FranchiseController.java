package com.cos.halfPizza.web;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;

@Controller
public class FranchiseController {
	@RequestMapping("/franchise")
	public String support() {
		return "/franchise/support.jsp";
	}
	@RequestMapping("/franchise/inquiry")
	public String inquiry() {
		return "/franchise/inquiry.jsp";
	}
}
