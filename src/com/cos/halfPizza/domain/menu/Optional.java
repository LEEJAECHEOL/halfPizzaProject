package com.cos.halfPizza.domain.menu;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Optional {
	private int id;
	private String title;
	private int price;
}
