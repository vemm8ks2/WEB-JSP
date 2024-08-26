package com.teamtwo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 앞으로 작성할 DAO는 BaseDAO 인터페이스를 구현하는 것을 전제로 진행합니다.
 * @author Kim
 */
public class _SampleDAO implements BaseDAO<_SampleDAO> {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private static _SampleDAO instance = null;
	
	private _SampleDAO() {}
	
	public static _SampleDAO getInstance() {
		if (instance == null) 
			instance = new _SampleDAO();
		
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
	public _SampleDAO get(int id) {
		try {
			open();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return null;
	}

	@Override
	public List<_SampleDAO> getAll() {
		try {
			open();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return null;
	}

	@Override
	public void save(_SampleDAO t) {
		try {
			open();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public void update(_SampleDAO t, String[] params) {
		try {
			open();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public void delete(_SampleDAO t) {
		try {
			open();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
}
