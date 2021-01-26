package com.cos.halfPizza.service.admin;

import java.util.List;
import com.cos.halfPizza.domain.admin.NoticeRepository;
import com.cos.halfPizza.domain.admin.dto.RegistNoticeReqDto;
import com.cos.halfPizza.domain.notice.Notice;

public class NoticeService {
	private NoticeRepository noticeRepository;
	
	public NoticeService() {
		this.noticeRepository = new NoticeRepository();
	}
	public int ��������ϱ�(RegistNoticeReqDto dto) {
		return noticeRepository.save(dto);
	}
	public List<Notice> ������ϰ�������() {
		return noticeRepository.findAll();
	}
}
