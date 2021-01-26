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
	public int �̺�Ʈ����ϱ�(RegistEventReqDto dto) {
		return eventRepository.save(dto);
	}
	public List<Event> �̺�Ʈ��ϰ�������() {
		return eventRepository.findAll();
	}
}
