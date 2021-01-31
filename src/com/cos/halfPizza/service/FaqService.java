package com.cos.halfPizza.service;

import java.util.List;

import com.cos.halfPizza.domain.faq.Faq;
import com.cos.halfPizza.domain.faq.FaqRepository;
import com.cos.halfPizza.domain.faq.dto.SelectReqDto;

public class FaqService {
	private FaqRepository faqRepository = new FaqRepository();
	
	public List<Faq> FAQ목록가져오기(SelectReqDto dto) {
		return faqRepository.findAll(dto);
	}
	
//	public List<Faq> FAQ목록가져오기(FaqCountDto dto) {
//		return faqRepository.findAll(dto);
//	}
}
