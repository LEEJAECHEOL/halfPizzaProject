package com.cos.halfPizza.service;

import java.util.List;

import com.cos.halfPizza.domain.event.Event;
import com.cos.halfPizza.domain.event.EventRepository;
import com.cos.halfPizza.domain.event.dto.EventReqDto;

public class EventService {
	private EventRepository eventRepository = new EventRepository();
	
	public List<Event> 이벤트목록가져오기() {
		return eventRepository.findAll();
	}
	public Event 이벤트상세보기(EventReqDto dto) {
		return eventRepository.findById(dto);
	}
}
