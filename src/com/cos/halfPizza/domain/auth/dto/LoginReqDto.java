package com.cos.halfPizza.domain.auth.dto;

import lombok.Data;

@Data
public class LoginReqDto {
	private String username;
	private String password;
}
