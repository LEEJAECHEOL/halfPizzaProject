package com.cos.halfPizza.web;

import javax.servlet.http.HttpServletResponse;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;

@Controller
public class ContactUsController {

	@RequestMapping("/community/contact")
	public String contact(HttpServletResponse response) {
		return "/community/contactus.jsp";
	}
}
