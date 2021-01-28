package com.cos.halfPizza.domain.admin.dto;

import lombok.Data;

@Data
public class MenuUpdateRespDto {
	private int id;
	private String originFileName1;
	private String changeFileName1;
	private String path;
	private String gubun;
	private String title;
	private String content;
	private int price;
	private int isR;
}
