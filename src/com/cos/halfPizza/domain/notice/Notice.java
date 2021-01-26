package com.cos.halfPizza.domain.notice;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Notice {
	private int id;
	private String title;
	private String content;
	private Timestamp createDate;
	private Timestamp updateDate;
}
