package com.cos.halfPizza.service;

import com.cos.halfPizza.domain.order.OrderRepository;
import com.cos.halfPizza.domain.order.dto.OrderReqDto;

public class OrderService {
	private OrderRepository orderRepository = new OrderRepository();
	
	public String save(OrderReqDto dto) {
		return orderRepository.save(dto);
	}
}
