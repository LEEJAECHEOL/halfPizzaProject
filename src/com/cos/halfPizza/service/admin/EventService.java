package com.cos.halfPizza.service.admin;

import java.util.List;

import com.cos.halfPizza.domain.admin.EventRepository;
import com.cos.halfPizza.domain.admin.dto.EventUpdateReqDto;
import com.cos.halfPizza.domain.admin.dto.EventFileRespDto;
import com.cos.halfPizza.domain.admin.dto.EventRegistReqDto;
import com.cos.halfPizza.domain.event.Event;

public class EventService {
private EventRepository eventRepository;
	
	public EventService() {
		this.eventRepository = new EventRepository();
	}
	public int 이벤트등록하기(EventRegistReqDto dto) {
		return eventRepository.save(dto);
	}
	public List<Event> 이벤트목록가져오기() {
		return eventRepository.findAll();
	}
	
	public int 이벤트삭제하기(int id) {
		return eventRepository.delete(id);
	}
	
	public Event 이벤트수정페이지(int id) {
		return eventRepository.findById(id);
	}
	
	public int 이벤트수정하기(EventUpdateReqDto dto) {
		return eventRepository.updateById(dto);
	}
	public EventFileRespDto 파일명가져오기(int id) {
		return eventRepository.findFileById(id);
	}
}
