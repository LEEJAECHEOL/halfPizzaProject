package com.cos.halfPizza.domain.order.dto;

import lombok.Data;

@Data
public class OrderReqDto {
	private int userId; 
	private String name;
	private String phone;
	private String addr;
	private String info;
	private String impId;
	private String merchantId;
	private int paidAmount;
	public void setUserId(String value) {
		this.userId = Integer.parseInt(value);
	}
	public void setPaidAmount(String value) {
		this.paidAmount = Integer.parseInt(value);
	}
}
