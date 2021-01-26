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
		Cookie[] cookies = req.getCookies();
		List<String> data = new ArrayList<String>();
		for(int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().contains("cart")){
				System.out.println(cookies[i].getName());
				data.add(URLDecoder.decode(cookies[i].getValue()).replace("path=/halfPizza", ""));
			}
		}
		Gson gson = new Gson();
		List<Cart> cart = new ArrayList<Cart>();
		for (String str : data) {
			cart.add(gson.fromJson(str, Cart.class));
		}
		req.setAttribute("cart", cart);
//		List<Cart> cart = gson.fromJson(data, new TypeToken<List<Cart>>(){}.getType());
		return "/order/cart.jsp";
	}
	
}
