package com.cos.halfPizza.domain.menu.dto;

import lombok.Data;

@Data
public class MenuViewReqDto {
	private int id;
	
	public void setId(String value) {
		this.id = Integer.parseInt(value);
	}
}
