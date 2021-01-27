package com.cos.halfPizza.domain.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.halfPizza.config.DBConn;
import com.cos.halfPizza.domain.admin.dto.EventUpdateReqDto;
import com.cos.halfPizza.domain.admin.dto.EventUpdateRespDto;
import com.cos.halfPizza.domain.admin.dto.FaqUpdateReqDto;
import com.cos.halfPizza.domain.admin.dto.FaqUpdateRespDto;
import com.cos.halfPizza.domain.admin.dto.RegistEventReqDto;
import com.cos.halfPizza.domain.event.Event;

public class EventRepository {
	public List<Event> findAll() {
		List<Event> list = new ArrayList<>();
		String sql = "SELECT * FROM event";
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
							.content(rs.getString("content"))
							.fromDate(rs.getDate("fromDate"))
							.toDate(rs.getDate("toDate"))
							.originFileName(rs.getString("originFileName"))
							.changeFileName(rs.getString("changeFileName"))
							.path(rs.getString("path"))
							.build()
						);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {	// �׻� ����
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public int save(RegistEventReqDto dto) {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO event(title, content, fromDate, toDate, originFileName, changeFileName, path) ");
		sb.append("VALUES(?, ?, ?, ?, ?, ?, ?)");
		String sql = sb.toString();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getFromDate());
			pstmt.setString(4, dto.getToDate());
			pstmt.setString(5, dto.getOriginFileName());
			pstmt.setString(6, dto.getChangeFileName());
			pstmt.setString(7,dto.getPath());
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
	
	public EventUpdateRespDto updateForm(int id) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT id, title, content, fromDate, toDate, originFileName, changeFileName, path ");
		sb.append("FROM event WHERE id = ?");
		String sql = sb.toString();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				EventUpdateRespDto dto = new EventUpdateRespDto();
				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setFromDate(rs.getString("fromDate"));
				dto.setToDate(rs.getString("toDate"));
				dto.setOriginFileName(rs.getString("originFileName"));
				dto.setChangeFileName(rs.getString("changeFileName"));
				dto.setPath(rs.getString("path"));
				System.out.println(dto);
				return dto;	
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public int update(EventUpdateReqDto dto) {
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE event SET title = ?, content = ?, fromDate = ?, toDate = ?, originFileName = ?, changeFileName = ?, path = ? ");
		sb.append("WHERE id = ?");
		String sql = sb.toString();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getFromDate());
			pstmt.setString(4, dto.getToDate());
			pstmt.setString(5, dto.getOriginFileName());
			pstmt.setString(6, dto.getChangeFileName());
			pstmt.setString(7,dto.getPath());
			pstmt.setInt(8,dto.getId());
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
