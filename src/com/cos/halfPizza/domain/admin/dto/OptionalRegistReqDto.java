package com.cos.halfPizza.domain.admin.dto;

import lombok.Data;

@Data
public class OptionalRegistReqDto {
	private String title;
	private int price;
	
	public void setPrice(String value) {
		this.price = Integer.parseInt(value);
	}
}
