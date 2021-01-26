package com.cos.halfPizza.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.domain.faq.Faq;
import com.cos.halfPizza.service.FaqService;

@Controller
public class FaqController {
	private FaqService faqService = new FaqService();
	
	@RequestMapping("/community/faq")
	public String list(HttpServletRequest req) {
		List<Faq> faqs = faqService.FAQ목록가져오기();
		req.setAttribute("faqs", faqs);
		return "/community/faq.jsp";
	}
}