package com.cos.halfPizza.domain.store;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Store {
	private int id;
	private double xPos;
	private double yPos;
	private String name;
	private String tel;
	private String addr;
	private String addr2;
	private Timestamp createDate;
}
