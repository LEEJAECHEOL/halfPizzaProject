package com.cos.halfPizza.web;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;

@Controller
public class OrderController {
	
	@RequestMapping("/order/cart")
	public String cart(HttpServletRequest req) {
		
		return "/order/cart.jsp";
	}
	@RequestMapping("/order/payment")
	public String payment(HttpServletRequest req, HttpServletResponse resp) {
		return "/order/payment.jsp";
	}
	@RequestMapping("/order/payment/success")
	public String success() {
		return "/order/success.jsp";
	}
	@RequestMapping("/order/noMemberOrderSearch")
	public String noMemberOrderSearch() {
		return "/order/noMemberOrderSearch.jsp";
	}
	
}
