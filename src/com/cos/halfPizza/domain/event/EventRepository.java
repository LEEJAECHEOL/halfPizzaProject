package com.cos.halfPizza.domain.event;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.halfPizza.config.DBConn;

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
							.content(rs.getString("content"))
							.fromDate(rs.getDate("fromDate"))
							.toDate(rs.getDate("toDate"))
							.originFileName(rs.getString("originFileName"))
							.changeFileName(rs.getString("changeFileName"))
							.path(rs.getString("path"))
							.build()
						);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {	// 항상 실행
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
}
