package com.cos.halfPizza.domain.auth.dto;

import lombok.Data;

@Data
public class SelectPassReqDto {
	private String username;
	private String email;
	private String name;
}
