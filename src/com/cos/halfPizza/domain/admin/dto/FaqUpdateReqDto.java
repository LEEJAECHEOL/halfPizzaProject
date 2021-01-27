package com.cos.halfPizza.domain.admin.dto;

import lombok.Data;

@Data
public class FaqUpdateReqDto {
	private int id;
	private String gubun;
	private String title;
	private String content;
	
	public void setId(String value) {
		this.id = Integer.parseInt(value);
	}
}
