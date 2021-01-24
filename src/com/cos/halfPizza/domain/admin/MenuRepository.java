package com.cos.halfPizza.domain.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.cos.halfPizza.config.DBConn;
import com.cos.halfPizza.domain.admin.dto.RegistMenuReqDto;

public class MenuRepository {
	
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
