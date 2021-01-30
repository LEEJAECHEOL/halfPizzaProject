package com.cos.halfPizza.domain.admin.dto;

import lombok.Data;

@Data
public class StoreSaveReqDto {
	private double xPos;
	private double yPos;
	private String name;
	private String tel;
	private String addr;
	private String addr2;
	
	public void setXPos(String value) {
		this.xPos = Double.parseDouble(value);
	}
	public void setYPos(String value) {
		this.yPos = Double.parseDouble(value);
	}
}
