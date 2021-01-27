package com.cos.halfPizza.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.domain.admin.dto.CommonRespDto;
import com.cos.halfPizza.domain.admin.dto.EventUpdateReqDto;
import com.cos.halfPizza.domain.admin.dto.EventUpdateRespDto;
import com.cos.halfPizza.domain.admin.dto.FaqUpdateReqDto;
import com.cos.halfPizza.domain.admin.dto.FaqUpdateRespDto;
import com.cos.halfPizza.domain.admin.dto.RegistEventReqDto;
import com.cos.halfPizza.domain.event.Event;
import com.cos.halfPizza.service.admin.EventService;
import com.cos.halfPizza.util.Script;
import com.google.gson.Gson;

@Controller
public class AdminEventController {
	private EventService EventService = new EventService();
	
	@RequestMapping("/admin/event/list")
	public String index(HttpServletRequest req) {
		List<Event> events = EventService.이벤트목록가져오기();
		req.setAttribute("events", events);
		return "/admin/event/index.jsp";
	}
	
	@RequestMapping("/admin/event/regist")
	public String regist() {
		return "/admin/event/addEvent.jsp";
	}
	
	@RequestMapping("/admin/event/registProc")
	public void registProc(RegistEventReqDto dto, HttpServletResponse resp, HttpServletRequest req) {		
		int result = EventService.이벤트등록하기(dto);
		if(result == 1) {
			try {
				resp.sendRedirect("/halfPizza/admin/event/list");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			// 디비에 정보를 넣기전에 이미지는 이미 업로드가 되기때문이 지워주어야 함.
			File file = new File(req.getSession().getServletContext().getRealPath(dto.getPath()) + dto.getChangeFileName());
			if(file.exists()) {
				file.delete();
			}
			Script.back(resp, "입력하신 정보를 다시 확인해주세요.");
		}
	}
	
	@RequestMapping("/admin/event/delete")
	public void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("아이디 : "+id);
		int result = EventService.이벤트삭제하기(id);
		CommonRespDto<String> commonRespDto = new CommonRespDto();
		
		commonRespDto.setStatusCode(result);
		commonRespDto.setData("성공");
		
		Gson gson = new Gson();
		String respData = gson.toJson(commonRespDto);
		PrintWriter out = response.getWriter();
		out.print(respData);
		out.flush();
	}
	
	@RequestMapping("/admin/event/updateForm")
	public String updateForm(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		EventUpdateRespDto dto = EventService.이벤트수정페이지(id);
		System.out.println(dto);
		request.setAttribute("dto", dto);
		return "/admin/event/updateForm.jsp";
	}
	
	@RequestMapping("/admin/event/updateProc")
	public void update(EventUpdateReqDto dto, HttpServletResponse response, HttpServletRequest request) {
		int result = EventService.이벤트수정하기(dto);
		if(result == 1) {
			try {
				response.sendRedirect("/halfPizza/admin/event/list");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			// 디비에 정보를 넣기전에 이미지는 이미 업로드가 되기때문이 지워주어야 함.
			File file = new File(request.getSession().getServletContext().getRealPath(dto.getPath()) + dto.getChangeFileName());
			if(file.exists()) {
				file.delete();
			}
			Script.back(response, "입력하신 정보를 다시 확인해주세요.");
		}
	}
}