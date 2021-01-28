package com.cos.halfPizza.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.anno.RestController;
import com.cos.halfPizza.domain.order.dto.OrderReqDto;
import com.cos.halfPizza.service.OrderService;

@RestController
public class OrderRestController {
	
	OrderService oderService = new OrderService();
	
	@RequestMapping("/order/complete")
	public String orderComplete(OrderReqDto dto, HttpServletRequest req, HttpServletResponse resp) {
		// 주문 완료 후 쿠키제거
		Cookie[] cookies = req.getCookies();
		for(int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().equals("cart")) {
				Cookie cookie = new Cookie("cart", "");
				cookie.setMaxAge(0);
				resp.addCookie(cookie);
			}
		}
		return oderService.save(dto);
	}
}
