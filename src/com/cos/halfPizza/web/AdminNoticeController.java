package com.cos.halfPizza.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.domain.admin.dto.CommonRespDto;
import com.cos.halfPizza.domain.admin.dto.NoticeUpdateReqDto;
import com.cos.halfPizza.domain.admin.dto.NoticeUpdateRespDto;
import com.cos.halfPizza.domain.admin.dto.RegistNoticeReqDto;
import com.cos.halfPizza.domain.notice.Notice;
import com.cos.halfPizza.service.admin.NoticeService;
import com.cos.halfPizza.util.Script;
import com.google.gson.Gson;

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
	
	@RequestMapping("/admin/notice/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int result = noticeService.공지삭제하기(id);
		CommonRespDto<String> commonRespDto = new CommonRespDto();
		
		commonRespDto.setStatusCode(result);
		commonRespDto.setData("성공");
		
		Gson gson = new Gson();
		String respData = gson.toJson(commonRespDto);
		PrintWriter out = response.getWriter();
		out.print(respData);
		out.flush();
	}
	
	@RequestMapping("/admin/notice/updateForm")
	public String updateForm(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		NoticeUpdateRespDto dto = noticeService.공지수정페이지(id);
		System.out.println(dto);
		request.setAttribute("dto", dto);
		return "/admin/notice/updateForm.jsp";
	}
	
	@RequestMapping("/admin/notice/updateProc")
	public void update(NoticeUpdateReqDto dto, HttpServletResponse response) {
		System.out.println(dto.getId());
		System.out.println(dto.getTitle());
		System.out.println(dto.getContent());
		int result = noticeService.공지수정하기(dto);
		if (result == 1) {
			try {
				response.sendRedirect("/halfPizza/admin/notice/list");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			Script.back(response, "수정실패");
		}
	}
}