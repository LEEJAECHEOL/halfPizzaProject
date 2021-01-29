package com.cos.halfPizza.service.admin;

import java.util.List;

import com.cos.halfPizza.domain.admin.OrderRepository;
import com.cos.halfPizza.domain.order.Order;

public class OrderService {
	public OrderRepository orderRepository;
	
	public OrderService() {
		this.orderRepository = new OrderRepository();
	}
	
	public List<Order> 주문목록가져오기() {
		return orderRepository.findAll();
	}
}
