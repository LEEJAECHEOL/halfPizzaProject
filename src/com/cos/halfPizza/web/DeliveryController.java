package com.cos.halfPizza.web;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.domain.delivery.Addr;
import com.google.gson.Gson;

@Controller
public class DeliveryController {
	
	@RequestMapping("/delivery")
	public String index(HttpServletRequest req) {
		Cookie[] cookies = req.getCookies();
		List<String> data = new ArrayList<String>();
		for(int i = 0; i < cookies.length; i++) {
			if(cookies[i].getName().contains("addr")){
				System.out.println(cookies[i].getName());
				data.add(URLDecoder.decode(cookies[i].getValue()).replace("path=/halfPizza", ""));
			}
		}
		Gson gson = new Gson();
		List<Addr> addr = new ArrayList<Addr>();
		for (String str : data) {
			addr.add(gson.fromJson(str, Addr.class));
		}
		if(addr.size() == 0) {
			addr = null;
		}
		req.setAttribute("addr", addr);
		return "/delivery/index.jsp";
	}
}
