package com.cos.halfPizza.domain.admin.dto;

import lombok.Data;

@Data
public class RegistOptionalReqDto {
	private String title;
	private int price;
	private String gubun;
	
	public void setPrice(String value) {
		this.price = Integer.parseInt(value);
	}
}
