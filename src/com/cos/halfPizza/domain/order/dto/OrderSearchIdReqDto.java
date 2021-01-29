package com.cos.halfPizza.domain.order.dto;

import lombok.Data;

@Data
public class OrderSearchIdReqDto {
	private int id;
	
	public void setId(String value) {
		this.id = Integer.parseInt(value);
	}
}
