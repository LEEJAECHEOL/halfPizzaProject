package com.cos.halfPizza.web;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;

@Controller
public class CouponController {
	@RequestMapping("/coupon")
	public String index() {
		return "/coupon/index.jsp";
	}
}
