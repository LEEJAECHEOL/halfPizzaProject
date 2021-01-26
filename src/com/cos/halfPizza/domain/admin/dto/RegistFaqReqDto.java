package com.cos.halfPizza.domain.admin.dto;

import lombok.Data;

@Data
public class RegistFaqReqDto {
	private int id;
	private String gubun;
	private String title;
	private String content;
}
