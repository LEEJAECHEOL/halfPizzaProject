package com.cos.halfPizza.web;


import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.domain.admin.dto.RegistFaqReqDto;
import com.cos.halfPizza.domain.faq.Faq;
import com.cos.halfPizza.service.admin.FaqService;
import com.cos.halfPizza.util.Script;

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
}
