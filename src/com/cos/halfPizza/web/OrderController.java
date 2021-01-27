package com.cos.halfPizza.web;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.domain.cart.Cart;
import com.google.gson.Gson;

@Controller
public class OrderController {
	
	@RequestMapping("/cart")
	public String cart(HttpServletRequest req) {
		
		return "/order/cart.jsp";
	}
	
}
