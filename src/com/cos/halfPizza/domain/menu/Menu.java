package com.cos.halfPizza.domain.menu;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Menu {
	private int id;
	private String originFileName1;
	private String changeFileName1;
	private String path;
	private String gubun;
	private String title;
	private String content;
	private int price;
	private int isR;
	private Timestamp createDate;
}
