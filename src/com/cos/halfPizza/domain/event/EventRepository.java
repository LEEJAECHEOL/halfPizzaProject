package com.cos.halfPizza.domain.event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.halfPizza.config.DBConn;
import com.cos.halfPizza.domain.CommonDto;
import com.cos.halfPizza.domain.event.dto.EventReqDto;
import com.google.gson.Gson;

public class EventRepository {
	public List<Event> findAll() {
		List<Event> list = new ArrayList<>();
		String sql = "SELECT * FROM event";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(Event.builder()
							.id(rs.getInt("id"))
							.title(rs.getString("title"))
							.fromDate(rs.getDate("fromDate"))
							.toDate(rs.getDate("toDate"))
							.changeFileName1(rs.getString("changeFileName1"))
							.path(rs.getString("path"))
							.build()
						);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
	public Event findById(EventReqDto dto) {
		String sql = "SELECT * FROM event WHERE id=?";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Gson gson = new Gson();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getId());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				return Event.builder()
				.id(rs.getInt("id"))
				.title(rs.getString("title"))
				.fromDate(rs.getDate("fromDate"))
				.toDate(rs.getDate("toDate"))
				.changeFileName2(rs.getString("changeFileName2"))
				.path(rs.getString("path"))
				.build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {	
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
}
