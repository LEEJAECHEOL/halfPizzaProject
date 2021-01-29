package com.cos.halfPizza.domain.order.dto;

import lombok.Data;

@Data
public class OrderSearchUserReqDto {
	private int id;
	private String date;
	
	public void setId(String value) {
		this.id = Integer.parseInt(value);
	}
}
