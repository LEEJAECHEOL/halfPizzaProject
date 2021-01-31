package com.cos.halfPizza.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.domain.auth.User;
import com.cos.halfPizza.domain.order.Order;
import com.cos.halfPizza.service.admin.AdminService;

@Controller
public class AdminController {

	private AdminService adminService = new AdminService();
	
	@RequestMapping("/admin")
	public String index(HttpServletRequest req) {
		List<User> users = adminService.회원목록가져오기();
		req.setAttribute("users", users);
		return "/admin/index.jsp";
	}
	
	
}
