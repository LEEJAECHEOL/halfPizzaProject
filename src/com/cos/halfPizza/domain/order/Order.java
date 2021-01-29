package com.cos.halfPizza.domain.order;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Order {
	private int id;
	private int userId;
	private String name;
	private String phone;
	private String addr;
	private String info;
	private String text;
	private String impId;
	private String merchantId;
	private int paidAmount;
	private String state;
	private Timestamp createDate;
}
