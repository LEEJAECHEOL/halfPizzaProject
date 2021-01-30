package com.cos.halfPizza.domain.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.halfPizza.config.DBConn;
import com.cos.halfPizza.domain.admin.dto.StoreDeleteReqDto;
import com.cos.halfPizza.domain.admin.dto.StoreSaveReqDto;
import com.cos.halfPizza.domain.store.Store;

public class StoreRepository {
	
	public List<Store> findAll() {
		List<Store> list = new ArrayList<>();
		String sql = "SELECT * FROM store";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(Store.builder()
							.id(rs.getInt("id"))
							.xPos(rs.getDouble("xPos"))
							.yPos(rs.getDouble("yPos"))
							.name(rs.getString("name"))
							.tel(rs.getString("tel"))
							.addr(rs.getString("addr"))
							.addr2(rs.getString("addr2"))
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
	
	public int save(StoreSaveReqDto dto) {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO store(xPos, yPos, name, tel, addr, addr2, createDate) ");
		sb.append("VALUES(?, ?, ?, ?, ?, ?, now())");
		String sql = sb.toString();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, dto.getXPos());
			pstmt.setDouble(2, dto.getYPos());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getAddr());
			pstmt.setString(6, dto.getAddr2());
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
	public int deleteById(StoreDeleteReqDto dto) {
		String sql = "DELETE FROM store WHERE id=?";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getId());
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {	// 항상 실행
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
}
