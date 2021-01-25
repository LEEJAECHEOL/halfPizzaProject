package com.cos.halfPizza.domain.menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.halfPizza.config.DBConn;
import com.cos.halfPizza.domain.menu.dto.MenuListRespDto;
import com.cos.halfPizza.domain.menu.dto.MenuViewReqDto;
import com.cos.halfPizza.domain.menu.dto.MenuViewRespDto;

public class MenuRepository {
	
	public List<MenuListRespDto> findAll() {
		List<MenuListRespDto> list = new ArrayList<>();
		String sql = "SELECT * FROM menu";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(MenuListRespDto.builder()
							.id(rs.getInt("id"))
							.changeFileName(rs.getString("changeFileName"))
							.path(rs.getString("path"))
							.title(rs.getString("title"))
							.price(rs.getInt("price"))
							.isR(rs.getInt("isR"))
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
	public MenuViewRespDto findById(MenuViewReqDto dto) {
		String sql = "SELECT id, path, changeFileName, title, content, price, isR FROM menu WHERE id = ?";
		Connection conn = DBConn.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				MenuViewRespDto respDto = new MenuViewRespDto();
				respDto.setId(rs.getInt("id"));
				respDto.setPath(rs.getString("path"));
				respDto.setChangeFileName(rs.getString("changeFileName"));
				respDto.setTitle(rs.getString("title"));
				respDto.setContent(rs.getString("content"));
				respDto.setPrice(rs.getInt("price"));
				respDto.setIsR(rs.getInt("isR"));
				return respDto;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(conn, pstmt, rs);
		}
		return null;
	}
	
}
