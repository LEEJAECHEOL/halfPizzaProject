package com.cos.halfPizza.domain.cart;

import java.util.List;

import lombok.Data;

@Data
public class Cart {
	private String name;
	private Menu menu;
	private Size size;
	private List<Option> option = null;
	private String totalPrice;
	private String count;
}
