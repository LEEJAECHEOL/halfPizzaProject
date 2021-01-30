package com.cos.halfPizza.domain.faq;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.halfPizza.config.DBConn;
import com.cos.halfPizza.domain.admin.dto.FaqCountDto;

public class FaqRepository {
	public List<Faq> findAll() {
		List<Faq> list = new ArrayList<>();
		String sql = "SELECT * FROM faq limit ?,5";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 5);
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
		} finally {	// �׻� ����
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public List<Faq> findAll(FaqCountDto dto) {
		List<Faq> list = new ArrayList<>();
		String sql = "SELECT * FROM faq limit ?,5";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getCount()*5);
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
		} finally {	// �׻� ����
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
	
}
