  
package com.cos.halfPizza.web;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cos.halfPizza.anno.Controller;
import com.cos.halfPizza.anno.RequestMapping;
import com.cos.halfPizza.domain.event.Event;
import com.cos.halfPizza.service.EventService;

@Controller
public class EventController {
	
	private EventService eventService = new EventService();
	
	@RequestMapping("/community/event")
	public String list(HttpServletRequest req) {
		List<Event> events = eventService.이벤트목록가져오기();
		req.setAttribute("events", events);
		return "/community/event.jsp";
	}
}