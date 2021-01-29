package com.cos.halfPizza.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.domain.order.Order;
import com.cos.halfPizza.service.admin.OrderService;

@Controller
public class AdminOrderController {
	
	private OrderService orderService = new OrderService();

	@RequestMapping("/admin/order/list")
	public String index(HttpServletRequest req) {
		List<Order> orders = orderService.주문목록가져오기();
		req.setAttribute("orders", orders);
		return "/admin/order/index.jsp";
	}
}
