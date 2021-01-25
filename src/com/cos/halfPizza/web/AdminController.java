package com.cos.halfPizza.web;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.service.admin.AdminService;

@Controller
public class AdminController {

	private AdminService adminService = new AdminService();
	
	@RequestMapping("/admin")
	public String index() {
		return "/admin/index.jsp";
	}
	
	
}
