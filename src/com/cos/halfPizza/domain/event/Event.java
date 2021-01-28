package com.cos.halfPizza.domain.event;
import java.sql.Date;

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
	private Date fromDate;
	private Date toDate;
	private String originFileName1;
	private String changeFileName1;
	private String originFileName2;
	private String changeFileName2;
	private String path;
}