package com.cos.halfPizza.domain.auth.dto;

import lombok.Data;

@Data
public class UpdateChkReqDto {
	private int id; 
	private String password;
	
	public void setId(String value) {
		this.id = Integer.parseInt(value);
	}
}
