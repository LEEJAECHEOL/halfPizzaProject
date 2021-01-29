package com.cos.halfPizza.service;

import java.util.List;

import com.cos.halfPizza.domain.order.Order;
import com.cos.halfPizza.domain.order.OrderRepository;
import com.cos.halfPizza.domain.order.dto.OrderReqDto;
import com.cos.halfPizza.domain.order.dto.OrderSearchIdReqDto;
import com.cos.halfPizza.domain.order.dto.OrderSearchReqDto;
import com.cos.halfPizza.domain.order.dto.OrderSearchRespDto;

public class OrderService {
	private OrderRepository orderRepository = new OrderRepository();
	
	public String save(OrderReqDto dto) {
		return orderRepository.save(dto);
	}
	
	public List<OrderSearchRespDto> 비회원주문목록가져오기(OrderSearchReqDto dto) {
		return orderRepository.findAllByPhone(dto);
	}
	
	public Order 주문상세보기(OrderSearchIdReqDto dto) {
		return orderRepository.findById(dto);
	}
}
