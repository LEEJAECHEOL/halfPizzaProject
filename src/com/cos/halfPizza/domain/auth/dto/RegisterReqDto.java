package com.cos.halfPizza.domain.auth.dto;

import lombok.Data;

@Data

public class RegisterReqDto {
	private String name;
	private String username;
	private String password;
	private String birth;
	private String phone;
	private String email;
	private int emailAd;
	private int smsAd;
	
	public void setEmailAd(String value) {
		this.emailAd = Integer.parseInt(value);
	}
	public void setSmsAd(String value) {
		this.smsAd = Integer.parseInt(value);
	}
}
