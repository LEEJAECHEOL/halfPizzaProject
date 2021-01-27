package com.cos.halfPizza.web;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.domain.admin.dto.CommonRespDto;
import com.cos.halfPizza.domain.admin.dto.FaqUpdateReqDto;
import com.cos.halfPizza.domain.admin.dto.FaqUpdateRespDto;
import com.cos.halfPizza.domain.admin.dto.NoticeUpdateReqDto;
import com.cos.halfPizza.domain.admin.dto.NoticeUpdateRespDto;
import com.cos.halfPizza.domain.admin.dto.RegistFaqReqDto;
import com.cos.halfPizza.domain.faq.Faq;
import com.cos.halfPizza.service.admin.FaqService;
import com.cos.halfPizza.util.Script;
import com.google.gson.Gson;

@Controller
public class AdminFaqController {
	private FaqService faqService = new FaqService();

	@RequestMapping("/admin/faq/list")
	public String index(HttpServletRequest req) {
		List<Faq> faqs = faqService.FAQ목록가져오기();
		req.setAttribute("faqs", faqs);
		return "/admin/faq/index.jsp";
	}

	@RequestMapping("/admin/faq/regist")
	public String regist() {
		return "/admin/faq/addFaq.jsp";
	}

	@RequestMapping("/admin/faq/registProc")
	public void registProc(RegistFaqReqDto dto, HttpServletResponse resp, HttpServletRequest req) {
		int result = faqService.FAQ등록하기(dto);
		if (result == 1) {
			try {
				resp.sendRedirect("/halfPizza/admin/faq/list");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			Script.back(resp, "입력실패");
		}
	}
	
	@RequestMapping("/admin/faq/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int result = faqService.FAQ삭제하기(id);
		CommonRespDto<String> commonRespDto = new CommonRespDto();
		
		commonRespDto.setStatusCode(result);
		commonRespDto.setData("성공");
		
		Gson gson = new Gson();
		String respData = gson.toJson(commonRespDto);
		PrintWriter out = response.getWriter();
		out.print(respData);
		out.flush();
	}
	
	@RequestMapping("/admin/faq/updateForm")
	public String updateForm(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		FaqUpdateRespDto dto = faqService.FAQ수정페이지(id);
		System.out.println(dto);
		request.setAttribute("dto", dto);
		return "/admin/faq/updateForm.jsp";
	}
	
	@RequestMapping("/admin/faq/updateProc")
	public void update(FaqUpdateReqDto dto, HttpServletResponse response) {
		System.out.println(dto.getId());
		System.out.println(dto.getGubun());
		System.out.println(dto.getTitle());
		System.out.println(dto.getContent());
		int result = faqService.FAQ수정하기(dto);
		if (result == 1) {
			try {
				response.sendRedirect("/halfPizza/admin/faq/list");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			Script.back(response, "수정실패");
		}
	}
	
}