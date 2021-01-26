package com.cos.halfPizza.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.domain.admin.dto.RegistFaqReqDto;
import com.cos.halfPizza.domain.admin.dto.RegistNoticeReqDto;
import com.cos.halfPizza.domain.faq.Faq;
import com.cos.halfPizza.domain.notice.Notice;
import com.cos.halfPizza.service.admin.NoticeService;
import com.cos.halfPizza.util.Script;

@Controller
public class AdminNoticeController {
	private NoticeService noticeService = new NoticeService();
	
	@RequestMapping("/admin/notice/list")
	public String index(HttpServletRequest req) {
		List<Notice> notices = noticeService.공지목록가져오기();
		req.setAttribute("notices", notices);
		return "/admin/notice/index.jsp";
	}

	@RequestMapping("/admin/notice/regist")
	public String regist() {
		return "/admin/notice/addNotice.jsp";
	}

	@RequestMapping("/admin/notice/registProc")
	public void registProc(RegistNoticeReqDto dto, HttpServletResponse resp, HttpServletRequest req) {
		int result = noticeService.공지등록하기(dto);
		if (result == 1) {
			try {
				resp.sendRedirect("/halfPizza/admin/notice/list");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			Script.back(resp, "입력실패");
		}
	}
}
