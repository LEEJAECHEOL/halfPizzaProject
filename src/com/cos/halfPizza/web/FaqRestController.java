package com.cos.halfPizza.web;

import java.util.List;


import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.anno.RestController;
import com.cos.halfPizza.domain.CommonDto;
import com.cos.halfPizza.domain.faq.Faq;
import com.cos.halfPizza.domain.faq.dto.SelectReqDto;
import com.cos.halfPizza.service.FaqService;
import com.google.gson.Gson;

@RestController
public class FaqRestController {
	private FaqService faqService = new FaqService();
	
	@RequestMapping("/community/faq/more")
	public String faqMore(SelectReqDto dto) {
		List<Faq> faqs = faqService.FAQ목록가져오기(dto);
		CommonDto<List<Faq>> entity = new CommonDto<>();
		
		if(faqs != null) {
			entity.setStatusCode(200);
			entity.setData(faqs);
		}else {
			entity.setStatusCode(400);
		}
		
		Gson gson = new Gson();
		return gson.toJson(entity);
		
	}
}
