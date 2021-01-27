package com.cos.halfPizza.domain.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.halfPizza.config.DBConn;
import com.cos.halfPizza.domain.admin.dto.FaqUpdateReqDto;
import com.cos.halfPizza.domain.admin.dto.FaqUpdateRespDto;
import com.cos.halfPizza.domain.admin.dto.NoticeUpdateReqDto;
import com.cos.halfPizza.domain.admin.dto.NoticeUpdateRespDto;
import com.cos.halfPizza.domain.admin.dto.RegistFaqReqDto;
import com.cos.halfPizza.domain.event.Event;
import com.cos.halfPizza.domain.faq.Faq;

public class FaqRepository {
	public List<Faq> findAll() {
		List<Faq> list = new ArrayList<>();
		String sql = "SELECT * FROM faq";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(Faq.builder()
							.id(rs.getInt("id"))
							.gubun(rs.getString("gubun"))
							.title(rs.getString("title"))
							.content(rs.getString("content"))
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
	
	public int save(RegistFaqReqDto dto) {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO faq(gubun, title, content, createDate, updateDate) ");
		sb.append("VALUES(?, ?, ?, now(), now())");
		String sql = sb.toString();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getGubun());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
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
		sb.append("DELETE FROM faq ");
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
	
	public FaqUpdateRespDto updateForm(int id) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT id, gubun, title, content ");
		sb.append("FROM faq WHERE id = ?");
		String sql = sb.toString();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				FaqUpdateRespDto dto = new FaqUpdateRespDto();
				dto.setId(rs.getInt("id"));
				dto.setGubun(rs.getString("gubun"));
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
	
	public int update(FaqUpdateReqDto dto) {
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE faq SET gubun = ?, title = ?, content = ? ");
		sb.append("WHERE id = ?");
		String sql = sb.toString();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getGubun());
			pstmt.setString(2, dto.getTitle());
			pstmt.setString(3, dto.getContent());
			pstmt.setInt(4, dto.getId());
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
