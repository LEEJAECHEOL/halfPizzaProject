package com.cos.halfPizza.service;

import java.util.List;

import com.cos.halfPizza.domain.event.Event;
import com.cos.halfPizza.domain.event.EventRepository;

public class EventService {
	private EventRepository eventRepository = new EventRepository();
	
	public List<Event> 이벤트목록가져오기() {
		return eventRepository.findAll();
	}
}
