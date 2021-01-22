package com.cos.halfPizza.domain.auth;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
	private int id;
	private String name;
	private String username;
	private Date birth;
	private String phone;
	private String email;
	private String role;
	private int emailAd;
	private int smsAd;
	private Timestamp createDate;
	private Timestamp updateDate;
}
