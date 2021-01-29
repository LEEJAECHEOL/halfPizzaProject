package com.cos.halfPizza.web;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.domain.order.dto.OrderSearchReqDto;
import com.cos.halfPizza.domain.order.dto.OrderSearchRespDto;
import com.cos.halfPizza.service.OrderService;
import com.cos.halfPizza.util.Script;

@Controller
public class OrderController {
	
	OrderService oderService = new OrderService();
	
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
	
	@RequestMapping("/order/noMemberOrderSearchProc")
	public String noMemberOrderSearchProc(OrderSearchReqDto dto, HttpServletRequest req, HttpServletResponse resp) {
		List<OrderSearchRespDto> entityDto = oderService.비회원주문목록가져오기(dto);
		if(entityDto != null) {
			req.setAttribute("dto", entityDto);
		}else{
			Script.back(resp, "주문하신 내역이 없습니다.");
		}
		return "/order/noMemberOrderList.jsp";
	}
	
}
