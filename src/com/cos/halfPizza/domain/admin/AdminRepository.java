package com.cos.halfPizza.domain.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.halfPizza.config.DBConn;
import com.cos.halfPizza.domain.auth.User;

public class AdminRepository {
	public List<User> findAll() {
		List<User> list = new ArrayList<>();
		String sql = "SELECT id, name, username, birth, phone, email, role, emailAd, smsAd, createDate, updateDate FROM users";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(User.builder()
							.id(rs.getInt("id"))
							.name(rs.getString("name"))
							.username(rs.getString("username"))
							.birth(rs.getDate("birth"))
							.phone(rs.getString("phone"))
							.email(rs.getString("email"))
							.role(rs.getString("role"))
							.emailAd(rs.getInt("emailAd"))
							.smsAd(rs.getInt("smsAd"))
							.createDate(rs.getTimestamp("createDate"))
							.updateDate(rs.getTimestamp("updateDate"))
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
