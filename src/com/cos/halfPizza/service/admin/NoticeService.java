package com.cos.halfPizza.service.admin;

import java.util.List;
import com.cos.halfPizza.domain.admin.NoticeRepository;
import com.cos.halfPizza.domain.admin.dto.NoticeUpdateReqDto;
import com.cos.halfPizza.domain.admin.dto.NoticeUpdateRespDto;
import com.cos.halfPizza.domain.admin.dto.RegistNoticeReqDto;
import com.cos.halfPizza.domain.notice.Notice;

public class NoticeService {
	private NoticeRepository noticeRepository;
	
	public NoticeService() {
		this.noticeRepository = new NoticeRepository();
	}
	public int 공지등록하기(RegistNoticeReqDto dto) {
		return noticeRepository.save(dto);
	}
	public List<Notice> 공지목록가져오기() {
		return noticeRepository.findAll();
	}
	public int 공지삭제하기(int id) {
		return noticeRepository.delete(id);
	}
	public NoticeUpdateRespDto 공지수정페이지(int id) {
		return noticeRepository.updateForm(id);
	}
	public int 공지수정하기(NoticeUpdateReqDto dto) {
		return noticeRepository.update(dto);
	}
}
