package com.cos.halfPizza.domain.admin.dto;

import lombok.Data;

@Data
public class StoreDeleteReqDto {
	private int id;
	
	public void setId(String value) {
		this.id = Integer.parseInt(value);
	}
}
