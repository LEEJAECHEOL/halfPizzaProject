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
		List<Event> events = EventService.�̺�Ʈ��ϰ�������();
		req.setAttribute("events", events);
		return "/admin/event/index.jsp";
	}
	
	@RequestMapping("/admin/event/regist")
	public String regist() {
		return "/admin/event/addEvent.jsp";
	}
	
	@RequestMapping("/admin/event/registProc")
	public void registProc(RegistEventReqDto dto, HttpServletResponse resp, HttpServletRequest req) {		
		int result = EventService.�̺�Ʈ����ϱ�(dto);
		if(result == 1) {
			try {
				resp.sendRedirect("/halfPizza/admin/event/list");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			// ��� ������ �ֱ����� �̹����� �̹� ���ε尡 �Ǳ⶧���� �����־�� ��.
			File file = new File(req.getSession().getServletContext().getRealPath(dto.getPath()) + dto.getChangeFileName());
			if(file.exists()) {
				file.delete();
			}
			Script.back(resp, "�Է��Ͻ� ������ �ٽ� Ȯ�����ּ���.");
		}
	}
}
