package com.cos.halfPizza.web;

import java.util.List;

import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.anno.RestController;
import com.cos.halfPizza.domain.admin.dto.FaqCountDto;
import com.cos.halfPizza.domain.faq.Faq;
import com.cos.halfPizza.service.FaqService;

@RestController
public class FaqRestController {
	private FaqService faqService = new FaqService();
	
	@RequestMapping("/community/faqMore")
	public String faqMore(FaqCountDto dto) {
		List<Faq> faqs = faqService.FAQ목록가져오기(dto);
//		req.setAttribute("faqs", faqs);
		return "/community/faq.jsp";
	}
}
