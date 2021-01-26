package com.cos.halfPizza.domain.event;
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
public class Event {
	private int id;
	private String title;
	private String content;
	private Date fromDate;
	private Date toDate;
	private String originFileName;
	private String changeFileName;
	private String path;
}