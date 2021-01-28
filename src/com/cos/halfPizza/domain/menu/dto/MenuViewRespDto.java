package com.cos.halfPizza.domain.menu.dto;

import lombok.Data;

@Data
public class MenuViewRespDto {
	private int id;
	private String changeFileName1;
	private String path;
	private String gubun;
	private String title;
	private String content;
	private int price;
	private int isR;
}
