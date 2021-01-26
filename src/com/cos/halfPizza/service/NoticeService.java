package com.cos.halfPizza.service;

import java.util.List;

import com.cos.halfPizza.domain.faq.Faq;
import com.cos.halfPizza.domain.faq.FaqRepository;
import com.cos.halfPizza.domain.notice.Notice;
import com.cos.halfPizza.domain.notice.NoticeRepository;

public class NoticeService {
	private NoticeRepository noticeRepository = new NoticeRepository();
	
	public List<Notice> 공지목록가져오기() {
		return noticeRepository.findAll();
	}
}
