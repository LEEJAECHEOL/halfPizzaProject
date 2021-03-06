package com.cos.halfPizza.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.domain.notice.Notice;
import com.cos.halfPizza.domain.notice.dto.SelectReqDto;
import com.cos.halfPizza.service.NoticeService;

@Controller
public class NoticeController {
	private NoticeService noticeService = new NoticeService();
	
	@RequestMapping("/community/notice")
	public String list(HttpServletRequest req) {
		List<Notice> notices = noticeService.공지목록가져오기(0);
		req.setAttribute("notices", notices);
		return "/community/notice.jsp";
	}
	
	@RequestMapping("/community/detail")
	public String detail(SelectReqDto dto, HttpServletRequest req) {
		Notice entityDto = noticeService.공지상세보기(dto);
		req.setAttribute("dto", entityDto);
		return "/community/noticeDetail.jsp";
	}
}
