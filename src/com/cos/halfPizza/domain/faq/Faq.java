package com.cos.halfPizza.domain.faq;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Faq {
	private int id;
	private String gubun;
	private String title;
	private String content;
	private Timestamp createDate;
	private Timestamp updateDate;
}
