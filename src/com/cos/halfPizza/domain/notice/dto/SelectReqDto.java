package com.cos.halfPizza.domain.notice.dto;

import lombok.Data;

@Data
public class SelectReqDto {
	private int id;

	public void setId(String value) {
		this.id = Integer.parseInt(value);
	}
}
