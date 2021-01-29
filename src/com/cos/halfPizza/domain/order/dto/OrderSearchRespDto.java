package com.cos.halfPizza.domain.order.dto;

import java.sql.Timestamp;

import lombok.Data;
@Data
public class OrderSearchRespDto {
	private int id;
	private String text;
	private int paidAmount;
	private Timestamp createDate;
}
