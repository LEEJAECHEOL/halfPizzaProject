package com.cos.halfPizza.domain.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.halfPizza.config.DBConn;
import com.cos.halfPizza.domain.admin.dto.RegistFaqReqDto;
import com.cos.halfPizza.domain.event.Event;
import com.cos.halfPizza.domain.faq.Faq;

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
	
	public int save(RegistFaqReqDto dto) {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO faq(gubun, title, content, createDate, updateDate) ");
		sb.append("VALUES(?, ?, ?, now(), now())");
		String sql = sb.toString();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getGubun());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
}
