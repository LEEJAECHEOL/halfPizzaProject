package com.cos.halfPizza.domain.menu.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MenuListRespDto {
	private int id;
	private String path;
	private String changeFileName;
	private String title;
	private int price;
	private int isR;
}
