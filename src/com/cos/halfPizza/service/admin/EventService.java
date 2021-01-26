package com.cos.halfPizza.service.admin;

import java.util.List;

import com.cos.halfPizza.domain.admin.EventRepository;
import com.cos.halfPizza.domain.admin.dto.RegistEventReqDto;
import com.cos.halfPizza.domain.event.Event;

public class EventService {
private EventRepository eventRepository;
	
	public EventService() {
		this.eventRepository = new EventRepository();
	}
	public int 이벤트등록하기(RegistEventReqDto dto) {
		return eventRepository.save(dto);
	}
	public List<Event> 이벤트목록가져오기() {
		return eventRepository.findAll();
	}
}
