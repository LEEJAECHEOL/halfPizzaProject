package com.cos.halfPizza.service;

import java.util.List;

import com.cos.halfPizza.domain.admin.dto.FaqCountDto;
import com.cos.halfPizza.domain.faq.Faq;
import com.cos.halfPizza.domain.faq.FaqRepository;

public class FaqService {
	private FaqRepository faqRepository = new FaqRepository();
	
	public List<Faq> FAQ목록가져오기() {
		return faqRepository.findAll();
	}
	
	public List<Faq> FAQ목록가져오기(FaqCountDto dto) {
		return faqRepository.findAll(dto);
	}
}
