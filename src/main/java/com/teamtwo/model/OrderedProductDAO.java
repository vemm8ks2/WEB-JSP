package com.teamtwo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class OrderedProductDAO implements BaseDAO<OrderedProductDTO> {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private static OrderedProductDAO instance = null;
	
	private OrderedProductDAO() {}
	
	public static OrderedProductDAO getInstance() {
		if (instance == null) 
			instance = new OrderedProductDAO();
		
		return instance;
	}
	
	private void open() {
		try {
			Context initCtx = new InitialContext();
			Context ctx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) ctx.lookup("jdbc/myoracle");

			conn = ds.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	private void close() {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public OrderedProductDTO get(int id) {
		OrderedProductDTO dto = null;

		try {
			open();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return dto;
	}

	@Override
	public List<OrderedProductDTO> getAll() {
		List<OrderedProductDTO> list = new ArrayList<>();

		try {
			open();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}

	@Override
	public void save(OrderedProductDTO dto) {
		try {
			open();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public void update(OrderedProductDTO dto) {
		try {
			open();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public void delete(int id) {
		try {
			open();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

}
