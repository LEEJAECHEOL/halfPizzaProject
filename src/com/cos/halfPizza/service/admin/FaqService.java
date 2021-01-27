package com.cos.halfPizza.service.admin;

import java.util.List;
import com.cos.halfPizza.domain.admin.FaqRepository;
import com.cos.halfPizza.domain.admin.dto.FaqUpdateReqDto;
import com.cos.halfPizza.domain.admin.dto.FaqUpdateRespDto;
import com.cos.halfPizza.domain.admin.dto.NoticeUpdateReqDto;
import com.cos.halfPizza.domain.admin.dto.RegistFaqReqDto;
import com.cos.halfPizza.domain.faq.Faq;


public class FaqService {
	private FaqRepository faqRepository;
	
	public FaqService() {
		this.faqRepository = new FaqRepository();
	}
	
	public int FAQ등록하기(RegistFaqReqDto dto) {
		return faqRepository.save(dto);
	}
	
	public List<Faq> FAQ목록가져오기() {
		return faqRepository.findAll();
	}
	
	public int FAQ삭제하기(int id) {
		return faqRepository.delete(id);
	}
	
	public FaqUpdateRespDto FAQ수정페이지(int id) {
		return faqRepository.updateForm(id);
	}
	
	public int FAQ수정하기(FaqUpdateReqDto dto) {
		return faqRepository.update(dto);
	}
}
