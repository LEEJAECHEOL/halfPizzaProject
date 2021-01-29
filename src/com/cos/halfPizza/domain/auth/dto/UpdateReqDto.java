package com.cos.halfPizza.domain.auth.dto;

import lombok.Data;

@Data
public class UpdateReqDto {
	private int id;
	private String password;
	private String email;
	private int emailAd;
	private int smsAd;
	
	public void setId(String value) {
		this.id = Integer.parseInt(value);
	}
	
	public void setEmailAd(String value) {
		this.emailAd = Integer.parseInt(value);
	}
	
	public void setSmsAd(String value) {
		this.smsAd = Integer.parseInt(value);
	}
}
