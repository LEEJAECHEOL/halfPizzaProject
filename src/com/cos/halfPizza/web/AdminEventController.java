package com.cos.halfPizza.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.domain.admin.dto.RegistEventReqDto;
import com.cos.halfPizza.domain.event.Event;
import com.cos.halfPizza.service.admin.EventService;
import com.cos.halfPizza.util.Script;

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
}