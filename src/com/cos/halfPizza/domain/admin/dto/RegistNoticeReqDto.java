package com.cos.halfPizza.domain.admin.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class RegistNoticeReqDto {
	private String title;
	private String content;
	private Timestamp createDate;
	private Timestamp updateDate;
}
