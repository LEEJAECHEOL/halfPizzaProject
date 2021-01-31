package com.cos.halfPizza.domain.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.halfPizza.config.DBConn;
import com.cos.halfPizza.domain.order.Order;

public class OrderRepository {
	public List<Order> findAll() {
		List<Order> list = new ArrayList<>();
		String sql = "SELECT id, userId, name, phone, addr, info, text, impId, merchantId, paidAmount, state, createDate FROM orders order by id desc";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(Order.builder()
							.id(rs.getInt("id"))
							.userId(rs.getInt("userId"))
							.name(rs.getString("name"))
							.phone(rs.getString("phone"))
							.addr(rs.getString("addr"))
							.info(rs.getString("info"))
							.text(rs.getString("text"))
							.impId(rs.getString("impId"))
							.merchantId(rs.getString("merchantId"))
							.paidAmount(rs.getInt("paidAmount"))
							.state(rs.getString("state"))
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
}
