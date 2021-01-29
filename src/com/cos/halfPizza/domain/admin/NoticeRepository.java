package com.cos.halfPizza.domain.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.cos.halfPizza.config.DBConn;
import com.cos.halfPizza.domain.admin.dto.NoticeUpdateReqDto;
import com.cos.halfPizza.domain.admin.dto.NoticeUpdateRespDto;
import com.cos.halfPizza.domain.admin.dto.RegistNoticeReqDto;
import com.cos.halfPizza.domain.notice.Notice;

public class NoticeRepository {
	public List<Notice> findAll() {
		List<Notice> list = new ArrayList<>();
		String sql = "SELECT * FROM notice";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(Notice.builder().id(rs.getInt("id")).title(rs.getString("title"))
						.content(rs.getString("content")).updateDate(rs.getTimestamp("updateDate"))
						.createDate(rs.getTimestamp("createDate")).build());
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}

	public int save(RegistNoticeReqDto dto) {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO notice(title, content, createDate, updateDate) ");
		sb.append("VALUES(?, ?, now(), now())");
		String sql = sb.toString();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
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
		sb.append("DELETE FROM notice ");
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

	public NoticeUpdateRespDto updateForm(int id) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT id, title, content ");
		sb.append("FROM notice WHERE id = ?");
		String sql = sb.toString();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				NoticeUpdateRespDto dto = new NoticeUpdateRespDto();
				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
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
	
	public int update(NoticeUpdateReqDto dto) {
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE notice SET title = ?, content = ?, updateDate = now() ");
		sb.append("WHERE id = ?");
		String sql = sb.toString();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getContent());
			pstmt.setInt(3, dto.getId());
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
