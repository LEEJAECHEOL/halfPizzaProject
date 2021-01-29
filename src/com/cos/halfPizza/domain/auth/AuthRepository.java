package com.cos.halfPizza.domain.auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cos.halfPizza.config.DBConn;
import com.cos.halfPizza.domain.CommonDto;
import com.cos.halfPizza.domain.auth.dto.LoginReqDto;
import com.cos.halfPizza.domain.auth.dto.RegisterReqDto;
import com.cos.halfPizza.domain.auth.dto.SelectIdReqDto;
import com.cos.halfPizza.domain.auth.dto.SelectPassReqDto;
import com.cos.halfPizza.domain.auth.dto.UpdateChkReqDto;
import com.cos.halfPizza.domain.auth.dto.UpdateReqDto;
import com.cos.halfPizza.domain.auth.dto.UserEmailCheckReqDto;
import com.cos.halfPizza.domain.auth.dto.UsernameCheckReqDto;
import com.google.gson.Gson;

public class AuthRepository {
	
	public int save(RegisterReqDto dto) {
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO users(name, username, password, birth, phone, email, role, emailAd, smsAd, createDate, updateDate) ");
		sb.append("VALUES(?, ?, ?, ?, ?, ?, 'USER', ?, ?, now(), now())");
		String sql = sb.toString();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getUsername());
			pstmt.setString(3, dto.getPassword());
			pstmt.setString(4, dto.getBirth());
			pstmt.setString(5, dto.getPhone());
			pstmt.setString(6, dto.getEmail());
			pstmt.setInt(7, dto.getEmailAd());
			pstmt.setInt(8, dto.getSmsAd());
			
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
	
	public int update(UpdateReqDto dto) {
		StringBuffer sb = new StringBuffer();
		sb.append("UPDATE users set password = ?, email = ?, emailAd = ?, smsAd = ? ");
		sb.append("where id = ?");
		String sql = sb.toString();
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getPassword());
			pstmt.setString(2, dto.getEmail());
			pstmt.setInt(3, dto.getEmailAd());
			pstmt.setInt(4, dto.getSmsAd());
			pstmt.setInt(5, dto.getId());
			
			int result = pstmt.executeUpdate();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt);
		}
		return -1;
	}
	
	public String findByUsername(UsernameCheckReqDto dto) {
		String sql = "SELECT * FROM users WHERE username=?";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Gson gson = new Gson();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUsername());
			rs = pstmt.executeQuery();
			CommonDto<String> responseDto = new CommonDto<String>();
			responseDto.setStatusCode(200);
			if(rs.next()) {
				responseDto.setData("ok");
			}else {
				responseDto.setData("no");
			}
			return gson.toJson(responseDto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {	
			DBConn.close(conn, pstmt, rs);
		}
		CommonDto<String> responseDto = new CommonDto<String>();
		responseDto.setStatusCode(400);
		return gson.toJson(responseDto);
	}
	
	public String findByEmail(UserEmailCheckReqDto dto) {
		String sql = "SELECT * FROM users WHERE email=?";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Gson gson = new Gson();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEmail());
			rs = pstmt.executeQuery();
			CommonDto<String> responseDto = new CommonDto<String>();
			responseDto.setStatusCode(200);
			if(rs.next()) {
				responseDto.setData("ok");
			}else {
				responseDto.setData("no");
			}
			return gson.toJson(responseDto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {	
			DBConn.close(conn, pstmt, rs);
		}
		CommonDto<String> responseDto = new CommonDto<String>();
		responseDto.setStatusCode(400);
		return gson.toJson(responseDto);
	}
	
	public String findByNameAndEmail(SelectIdReqDto dto) {
		String sql = "SELECT username FROM users WHERE email=? and name = ?";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Gson gson = new Gson();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEmail());
			pstmt.setString(2, dto.getName());
			rs = pstmt.executeQuery();
			CommonDto<String> responseDto = new CommonDto<String>();
			responseDto.setStatusCode(200);
			if(rs.next()) {
				responseDto.setData(rs.getString("username"));
			}else {
				responseDto.setData("no");
			}
			System.out.println(responseDto.getData());
			return gson.toJson(responseDto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {	
			DBConn.close(conn, pstmt, rs);
		}
		CommonDto<String> responseDto = new CommonDto<String>();
		responseDto.setStatusCode(400);
		return gson.toJson(responseDto);
	}
	
	public String findByUsernameAndEmail(SelectPassReqDto dto) {
		String sql = "SELECT password FROM users WHERE email = ? and name = ? and username = ?";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Gson gson = new Gson();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getEmail());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getUsername());
			rs = pstmt.executeQuery();
			CommonDto<String> responseDto = new CommonDto<String>();
			responseDto.setStatusCode(200);
			if(rs.next()) {
				responseDto.setData(rs.getString("password"));
			}else {
				responseDto.setData("no");
			}
			System.out.println(responseDto.getData());
			return gson.toJson(responseDto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {	
			DBConn.close(conn, pstmt, rs);
		}
		CommonDto<String> responseDto = new CommonDto<String>();
		responseDto.setStatusCode(400);
		return gson.toJson(responseDto);
	}
	
	public User findByUsernameAndPassword(LoginReqDto dto) {
		String sql = "SELECT id, name, username, birth, phone, email, role, emailAd, smsAd, createDate, updateDate FROM users WHERE username=? AND password=?";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUsername());
			pstmt.setString(2, dto.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return User.builder()
						.id(rs.getInt("id"))
						.name(rs.getString("name"))
						.username(rs.getString("username"))
						.birth(rs.getDate("birth"))
						.phone(rs.getString("phone"))
						.email(rs.getString("email"))
						.role(rs.getString("role"))
						.emailAd(rs.getInt("emailAd"))
						.smsAd(rs.getInt("smsAd"))
						.createDate(rs.getTimestamp("createDate"))
						.updateDate(rs.getTimestamp("updateDate"))
						.build();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {	// �빆�긽 �떎�뻾
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
	
	public int findByIdAndPassword(UpdateChkReqDto dto) {
		String sql = "SELECT * FROM users WHERE id=? AND password=?";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getId());
			pstmt.setString(2, dto.getPassword());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {	
			DBConn.close(conn, pstmt, rs);
		}
		return -1;
	}
	
	
}
