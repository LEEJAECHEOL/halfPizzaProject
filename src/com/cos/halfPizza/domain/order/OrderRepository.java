package com.cos.halfPizza.domain.order;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.cos.halfPizza.config.DBConn;
import com.cos.halfPizza.domain.order.dto.OrderReqDto;

public class OrderRepository {
	
	public String save(OrderReqDto dto) {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO orders(userId, name, phone, addr, info, impId, merchantId, paidAmount, createDate) ");
		sb.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, now())");
		String sql = sb.toString();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getUserId());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getPhone());
			pstmt.setString(4, dto.getAddr());
			pstmt.setString(5, dto.getInfo());
			pstmt.setString(6, dto.getImpId());
			pstmt.setString(7, dto.getMerchantId());
			pstmt.setInt(8, dto.getPaidAmount());
			
			int result = pstmt.executeUpdate();
			if(result == 1) {
				return "ok";
			}else {
				return "no";
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
		return "no";
	}
}
