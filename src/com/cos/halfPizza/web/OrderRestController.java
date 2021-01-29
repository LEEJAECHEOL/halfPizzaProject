package com.cos.halfPizza.web;

import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.anno.RestController;
import com.cos.halfPizza.domain.CommonRespDto;
import com.cos.halfPizza.domain.order.Order;
import com.cos.halfPizza.domain.order.dto.OrderReqDto;
import com.cos.halfPizza.domain.order.dto.OrderSearchIdReqDto;
import com.cos.halfPizza.service.OrderService;
import com.google.gson.Gson;

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
	
	@RequestMapping("/order/findDetail")
	public String detailOrder(OrderSearchIdReqDto dto) {
		Order entityDto = oderService.주문상세보기(dto);
		CommonRespDto<Order> commonRespDto = new CommonRespDto();
		
		commonRespDto.setStatusCode(200);
		commonRespDto.setData(entityDto);
		
		Gson gson = new Gson();
		return gson.toJson(commonRespDto);
		
	}
}
