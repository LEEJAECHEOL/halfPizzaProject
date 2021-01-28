package com.cos.halfPizza.domain.admin.dto;

import lombok.Data;

@Data
public class EventUpdateReqDto {
	private int id;
	private String title;
	private String fromDate;
	private String toDate;
	private String originFileName1;
	private String changeFileName1;
	private String originFileName2;
	private String changeFileName2;
	private String path;
	public void setId(String value) {
		this.id = Integer.parseInt(value);
	}
}
