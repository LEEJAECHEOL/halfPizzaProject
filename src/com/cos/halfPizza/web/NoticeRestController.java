package com.cos.halfPizza.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.anno.RestController;
import com.cos.halfPizza.domain.CommonDto;
import com.cos.halfPizza.domain.notice.Notice;
import com.cos.halfPizza.service.NoticeService;
import com.google.gson.Gson;

@RestController
public class NoticeRestController {
	
	private NoticeService noticeService = new NoticeService();
	
	@RequestMapping("/community/notice/more")
	public String list(HttpServletRequest req) {
		int page = Integer.parseInt(req.getParameter("page"));
		List<Notice> notices = noticeService.공지목록가져오기(page);
		CommonDto<List<Notice>> dto = new CommonDto<List<Notice>>();
		
		if(notices != null) {
			dto.setStatusCode(400);
			dto.setData(notices);
		}else {
			dto.setStatusCode(400);
		}
		
		Gson gson = new Gson();
		return gson.toJson(dto);
	}
	
}
