package com.cos.halfPizza.domain.admin.dto;

import lombok.Data;

@Data
public class EventUpdateRespDto {
	private int id;
	private String title;
	private String content;
	private String fromDate;
	private String toDate;
	private String originFileName;
	private String changeFileName;
	private String path;
}
