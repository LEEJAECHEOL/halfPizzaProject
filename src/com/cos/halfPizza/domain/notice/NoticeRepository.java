package com.cos.halfPizza.domain.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.cos.halfPizza.config.DBConn;
import com.cos.halfPizza.domain.notice.dto.SelectReqDto;

public class NoticeRepository {
	public List<Notice> findAll() {
		List<Notice> list = new ArrayList<>();
		String sql = "SELECT * FROM notice";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(Notice.builder()
							.id(rs.getInt("id"))
							.title(rs.getString("title"))
							.content(rs.getString("content"))
							.updateDate(rs.getTimestamp("updateDate"))
							.createDate(rs.getTimestamp("createDate"))
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
	public Notice findById(SelectReqDto dto) {
		String sql = "SELECT * FROM notice WHERE id = ?";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getId());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				return Notice.builder()
				.id(rs.getInt("id"))
				.title(rs.getString("title"))
				.content(rs.getString("content"))
				.createDate(rs.getTimestamp("createDate"))
				.updateDate(rs.getTimestamp("updateDate"))
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
