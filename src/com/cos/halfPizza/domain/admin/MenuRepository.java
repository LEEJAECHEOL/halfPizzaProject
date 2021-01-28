package com.cos.halfPizza.domain.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.halfPizza.config.DBConn;
import com.cos.halfPizza.domain.admin.dto.MenuUpdateReqDto;
import com.cos.halfPizza.domain.admin.dto.MenuUpdateRespDto;
import com.cos.halfPizza.domain.admin.dto.EventFileRespDto;
import com.cos.halfPizza.domain.admin.dto.MenuFileDeleteRespDto;
import com.cos.halfPizza.domain.admin.dto.MenuRegistReqDto;
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
							.originFileName1(rs.getString("originFileName1"))
							.changeFileName1(rs.getString("changeFileName1"))
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
	
	public int save(MenuRegistReqDto dto) {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO menu(gubun, originFileName1, changeFileName1, path, title, content, price, isR, createDate) ");
		sb.append("VALUES(?, ?, ?, ?, ?, ?, ?, ?, now())");
		String sql = sb.toString();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getGubun());
			pstmt.setString(2, dto.getOriginFileName1());
			pstmt.setString(3, dto.getChangeFileName1());
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
	
	public int delete(int id) {
		StringBuffer sb = new StringBuffer();
		sb.append("DELETE FROM menu ");
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
	
	public MenuUpdateRespDto updateForm(int id) {
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT id, gubun, originFileName1, changeFileName1, path, title, content, path, price, isR ");
		sb.append("FROM menu WHERE id = ?");
		String sql = sb.toString();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				MenuUpdateRespDto dto = new MenuUpdateRespDto();
				dto.setId(rs.getInt("id"));
				dto.setGubun(rs.getString("gubun"));
				dto.setOriginFileName1(rs.getString("originFileName1"));
				dto.setChangeFileName1(rs.getString("changeFileName1"));
				dto.setPath(rs.getString("path"));
				dto.setTitle(rs.getString("title"));
				dto.setContent(rs.getString("content"));
				dto.setPrice(rs.getInt("price"));
				dto.setIsR(rs.getInt("isR"));
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
	
	public int update(MenuUpdateReqDto dto) {
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE menu SET gubun = ?, originFileName1 = ?, changeFileName1 = ?, path = ?, title = ?, content = ?, path = ?, price = ?, isR = ? ");
		sb.append("WHERE id = ?");
		String sql = sb.toString();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getGubun());
			pstmt.setString(2, dto.getOriginFileName1());
			pstmt.setString(3, dto.getChangeFileName1());
			pstmt.setString(4,dto.getPath());
			pstmt.setString(5, dto.getTitle());
			pstmt.setString(6, dto.getContent());
			pstmt.setString(7, dto.getPath());
			pstmt.setInt(8, dto.getPrice());
			pstmt.setInt(9, dto.getIsR());
			pstmt.setInt(10,dto.getId());
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
	public MenuFileDeleteRespDto findFileById(int id) {
		String sql = "SELECT changeFileName1, path FROM menu WHERE id = ?";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				MenuFileDeleteRespDto dto = new MenuFileDeleteRespDto();
				dto.setChangeFileName1(rs.getString("changeFileName1"));
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
