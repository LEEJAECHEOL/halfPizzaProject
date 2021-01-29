package com.cos.halfPizza.domain.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.halfPizza.config.DBConn;
import com.cos.halfPizza.domain.order.dto.OrderReqDto;
import com.cos.halfPizza.domain.order.dto.OrderSearchIdReqDto;
import com.cos.halfPizza.domain.order.dto.OrderSearchReqDto;
import com.cos.halfPizza.domain.order.dto.OrderSearchRespDto;

public class OrderRepository {
	
	public String save(OrderReqDto dto) {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO orders(userId, name, phone, addr, info, text, impId, merchantId, paidAmount, state, createDate) ");
		sb.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, '주문완료',now())");
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
			pstmt.setString(6, dto.getText());
			pstmt.setString(7, dto.getImpId());
			pstmt.setString(8, dto.getMerchantId());
			pstmt.setInt(9, dto.getPaidAmount());
			
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
	
	public List<OrderSearchRespDto> findAllByPhone(OrderSearchReqDto dto) {
		List<OrderSearchRespDto> list = new ArrayList<>();
		String sql = "SELECT id, text, paidAmount, createDate FROM orders WHERE phone = ? AND Date(createDate) = Date(now())";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPhone());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				OrderSearchRespDto entityDto = new OrderSearchRespDto();
				entityDto.setId(rs.getInt("id"));
				entityDto.setText(rs.getString("text"));
				entityDto.setPaidAmount(rs.getInt("paidAmount"));
				entityDto.setCreateDate(rs.getTimestamp("createDate"));
				list.add(entityDto);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
	public Order findById(OrderSearchIdReqDto dto) {
		String sql = "SELECT * FROM orders WHERE id = ?";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getId());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				return Order.builder()
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
						.build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
}
