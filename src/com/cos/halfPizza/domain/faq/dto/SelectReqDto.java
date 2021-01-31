package com.cos.halfPizza.domain.faq.dto;

import lombok.Data;

@Data
public class SelectReqDto {
	private int page;
	private String gubun = "";
	private String keyword = "";
	
	public void setPage(String value) {
		this.page = Integer.parseInt(value);
	}
}
