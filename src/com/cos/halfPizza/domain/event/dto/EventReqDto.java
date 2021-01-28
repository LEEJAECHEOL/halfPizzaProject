package com.cos.halfPizza.domain.event.dto;

import lombok.Data;

@Data
public class EventReqDto {
	private int id;
	
	public void setId(String value) {
		this.id = Integer.parseInt(value);
	}
}
