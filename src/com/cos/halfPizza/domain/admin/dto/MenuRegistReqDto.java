package com.cos.halfPizza.domain.admin.dto;


import lombok.Data;

@Data
public class MenuRegistReqDto {
	private String originFileName1;
	private String changeFileName1;
	private String path;
	private String gubun;
	private String title;
	private String content;
	private int price;
	private int isR;
	
	public void setPrice(String value) {
		this.price = Integer.parseInt(value);
	}
	public void setIsR(String value) {
		this.isR = Integer.parseInt(value);
	}
	
}
