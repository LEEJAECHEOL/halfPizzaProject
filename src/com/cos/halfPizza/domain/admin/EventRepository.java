package com.cos.halfPizza.domain.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.halfPizza.config.DBConn;
import com.cos.halfPizza.domain.admin.dto.EventUpdateReqDto;
import com.cos.halfPizza.domain.admin.dto.EventFileRespDto;
import com.cos.halfPizza.domain.admin.dto.EventRegistReqDto;
import com.cos.halfPizza.domain.event.Event;

public class EventRepository {
	public List<Event> findAll() {
		List<Event> list = new ArrayList<>();
		String sql = "SELECT id, title, toDate, fromDate, changeFileName1, path FROM event";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(Event.builder()
							.id(rs.getInt("id"))
							.title(rs.getString("title"))
							.fromDate(rs.getDate("fromDate"))
							.toDate(rs.getDate("toDate"))
							.changeFileName1(rs.getString("changeFileName1"))
							.path(rs.getString("path"))
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
	
	public int save(EventRegistReqDto dto) {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO event(title, fromDate, toDate, originFileName1, changeFileName1, originFileName2, changeFileName2, path, createDate) ");
		sb.append("VALUES(?, ?, ?, ?, ?, ?, ?, ? , now())");
		String sql = sb.toString();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getFromDate());
			pstmt.setString(3, dto.getToDate());
			pstmt.setString(4, dto.getOriginFileName1());
			pstmt.setString(5, dto.getChangeFileName1());
			pstmt.setString(6, dto.getOriginFileName2());
			pstmt.setString(7, dto.getChangeFileName2());
			pstmt.setString(8, dto.getPath());
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
	
	public int delete(int id) {
		StringBuffer sb = new StringBuffer();
		sb.append("DELETE FROM event ");
		sb.append("WHERE id = ?");
		String sql = sb.toString();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
	
	public Event findById(int id) {
		String sql = "SELECT * FROM event WHERE id = ?";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				Event dto = new Event();
				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setFromDate(rs.getDate("fromDate"));
				dto.setToDate(rs.getDate("toDate"));
				dto.setOriginFileName1(rs.getString("originFileName1"));
				dto.setChangeFileName1(rs.getString("changeFileName1"));
				dto.setOriginFileName2(rs.getString("originFileName2"));
				dto.setChangeFileName2(rs.getString("changeFileName2"));
				dto.setPath(rs.getString("path"));
				return dto;	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public int updateById(EventUpdateReqDto dto) {
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE event SET title = ?, fromDate = ?, toDate = ?, originFileName1 = ?, changeFileName1 = ?, originFileName2 = ?, changeFileName2 = ?, path = ? ");
		sb.append("WHERE id = ?");
		String sql = sb.toString();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getFromDate());
			pstmt.setString(3, dto.getToDate());
			pstmt.setString(4, dto.getOriginFileName1());
			pstmt.setString(5, dto.getChangeFileName1());
			pstmt.setString(6, dto.getOriginFileName2());
			pstmt.setString(7, dto.getChangeFileName2());
			pstmt.setString(8,dto.getPath());
			pstmt.setInt(9,dto.getId());
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
	public EventFileRespDto findFileById(int id) {
		String sql = "SELECT changeFileName1, changeFileName2, path FROM event WHERE id = ?";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				EventFileRespDto dto = new EventFileRespDto();
				dto.setChangeFileName1(rs.getString("changeFileName1"));
				dto.setChangeFileName2(rs.getString("changeFileName2"));
				dto.setPath(rs.getString("path"));
				return dto;	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
}
