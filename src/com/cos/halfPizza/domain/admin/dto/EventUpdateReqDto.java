package com.cos.halfPizza.domain.admin.dto;

import lombok.Data;

@Data
public class EventUpdateReqDto {
	private int id;
	private String title;
	private String content;
	private String fromDate;
	private String toDate;
	private String originFileName;
	private String changeFileName;
	private String path;
	public void setId(String value) {
		this.id = Integer.parseInt(value);
	}
}
