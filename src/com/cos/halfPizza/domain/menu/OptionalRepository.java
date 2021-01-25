package com.cos.halfPizza.domain.menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.halfPizza.config.DBConn;

public class OptionalRepository {
	
	public List<Optional> findAll() {
		List<Optional> list = new ArrayList<>();
		String sql = "SELECT * FROM optional";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(Optional.builder()
							.id(rs.getInt("id"))
							.title(rs.getString("title"))
							.price(rs.getInt("price"))
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
