package com.cos.halfPizza.domain.faq;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.halfPizza.config.DBConn;
import com.cos.halfPizza.domain.faq.dto.SelectReqDto;

public class FaqRepository {
	public List<Faq> findAll(SelectReqDto dto) {
		List<Faq> list = new ArrayList<>();
		String sql = null;
		if(dto.getGubun() == null || dto.getGubun().equals("")) {
			sql = "SELECT * FROM faq WHERE title LIKE ? ORDER BY gubun LIMIT ?, 5";
		}else {
			sql = "SELECT * FROM faq WHERE title LIKE ? AND gubun = ? ORDER BY gubun LIMIT ?, 5";
		}
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + dto.getKeyword() + "%");
			if(dto.getGubun() == null || dto.getGubun().equals("")) {
				pstmt.setInt(2, dto.getPage() * 5);
			}else {
				pstmt.setString(2, dto.getGubun());
				pstmt.setInt(3, dto.getPage() * 5);
			}
			
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
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
}
