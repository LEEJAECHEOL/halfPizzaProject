package com.cos.halfPizza.domain.faq;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.halfPizza.config.DBConn;

public class FaqRepository {
	public List<Faq> findAll() {
		List<Faq> list = new ArrayList<>();
		String sql = "SELECT * FROM faq";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(Faq.builder()
							.id(rs.getInt("id"))
							.gubun(rs.getString("gubun"))
							.title(rs.getString("title"))
							.content(rs.getString("content"))
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
