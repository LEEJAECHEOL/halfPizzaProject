package com.cos.halfPizza.service;

import java.util.List;

import com.cos.halfPizza.domain.notice.Notice;
import com.cos.halfPizza.domain.notice.NoticeRepository;
import com.cos.halfPizza.domain.notice.dto.SelectReqDto;

public class NoticeService {
	private NoticeRepository noticeRepository = new NoticeRepository();
	
	public List<Notice> 공지목록가져오기() {
		return noticeRepository.findAll();
	}
	
	public Notice 공지상세보기(SelectReqDto dto) {
		return noticeRepository.findById(dto);
	}
}
