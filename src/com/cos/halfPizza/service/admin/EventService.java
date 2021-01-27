package com.cos.halfPizza.service.admin;

import java.util.List;

import com.cos.halfPizza.domain.admin.EventRepository;
import com.cos.halfPizza.domain.admin.dto.EventUpdateReqDto;
import com.cos.halfPizza.domain.admin.dto.EventUpdateRespDto;
import com.cos.halfPizza.domain.admin.dto.FaqUpdateReqDto;
import com.cos.halfPizza.domain.admin.dto.FaqUpdateRespDto;
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
	
	public int 이벤트삭제하기(int id) {
		return eventRepository.delete(id);
	}
	
	public EventUpdateRespDto 이벤트수정페이지(int id) {
		return eventRepository.updateForm(id);
	}
	
	public int 이벤트수정하기(EventUpdateReqDto dto) {
		return eventRepository.update(dto);
	}
}
