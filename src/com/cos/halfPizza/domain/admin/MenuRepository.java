package com.cos.halfPizza.domain.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.halfPizza.config.DBConn;
import com.cos.halfPizza.domain.admin.dto.RegistMenuReqDto;
import com.cos.halfPizza.domain.menu.Menu;

public class MenuRepository {
	
	public List<Menu> findAll() {
		List<Menu> list = new ArrayList<>();
		String sql = "SELECT * FROM menu";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(Menu.builder()
							.id(rs.getInt("id"))
							.gubun(rs.getString("gubun"))
							.originFileName(rs.getString("originFileName"))
							.changeFileName(rs.getString("changeFileName"))
							.path(rs.getString("path"))
							.title(rs.getString("title"))
							.content(rs.getString("content"))
							.price(rs.getInt("price"))
							.isR(rs.getInt("isR"))
							.createDate(rs.getTimestamp("createDate"))
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
	
	public int save(RegistMenuReqDto dto) {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO menu(gubun, originFileName, changeFileName, path, title, content, price, isR, createDate) ");
		sb.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, now())");
		String sql = sb.toString();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getGubun());
			pstmt.setString(2, dto.getOriginFileName());
			pstmt.setString(3, dto.getChangeFileName());
			pstmt.setString(4, dto.getPath());
			pstmt.setString(5, dto.getTitle());
			pstmt.setString(6, dto.getContent());
			pstmt.setInt(7, dto.getPrice());
			pstmt.setInt(8, dto.getIsR());
			
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
