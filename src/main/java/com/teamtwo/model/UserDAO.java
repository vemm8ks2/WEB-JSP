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

public class UserDAO implements BaseDAO<UserDTO> {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private static UserDAO instance = null;
	
	private UserDAO() {}
	
	public static UserDAO getInstance() {
		if (instance == null) 
			instance = new UserDAO();
		
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
	public UserDTO get(int id) {
		UserDTO dto = null;
		try {
			open();
			String sql = "select * from T_customer where customer_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			if(rs.next()) {
             dto.setUserId(rs.getInt("customer_id"));
             dto.setUserLoginId(rs.getString("customer_login_id"));
             dto.setUserPassword(rs.getString("customer_password"));
             dto.setUserName(rs.getString("customer_name"));
             dto.setUserEmail(rs.getString("customer_email"));
             dto.setUserPhoneNumber(rs.getString("customer_phone_number"));
             dto.setUserGender(rs.getString("customer_gender"));
             dto.setUserBirth(rs.getString("customer_birth"));
             dto.setUserCreatedAt(rs.getString("customer_created_at"));
             dto.setUserUpdatedAt(rs.getString("customer_updated_at"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return dto;
	}

	@Override
	public List<UserDTO> getAll() {
		List<UserDTO> list = new ArrayList<>();
		try {
			open();
			String sql = "select * from T_customer";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
              UserDTO dto = new UserDTO();
              dto.setUserId(rs.getInt("customer_id"));
              dto.setUserLoginId(rs.getString("customer_login_id"));
              dto.setUserPassword(rs.getString("customer_password"));
              dto.setUserName(rs.getString("customer_name"));
              dto.setUserEmail(rs.getString("customer_email"));
              dto.setUserPhoneNumber(rs.getString("customer_phone_number"));
              dto.setUserGender(rs.getString("customer_gender"));
              dto.setUserBirth(rs.getString("customer_birth"));
              dto.setUserCreatedAt(rs.getString("customer_created_at"));
              dto.setUserUpdatedAt(rs.getString("customer_updated_at"));
              
              list.add(dto);
            }
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return list;
	}

	@Override
	public void save(UserDTO dto) {
		try {
			open();
			String sql = "insert into T_customer values(?,?,?,?,?,?,?,?,sysdate,'')";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getUserId());
			pstmt.setString(2, dto.getUserLoginId());
			pstmt.setString(3, dto.getUserPassword());
			pstmt.setString(4, dto.getUserName());
			pstmt.setString(5, dto.getUserEmail());
			pstmt.setString(6, dto.getUserPhoneNumber());
			pstmt.setString(7, dto.getUserGender());
			pstmt.setString(8, dto.getUserBirth());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	@Override
	public void update(UserDTO dto) {
		try {
			open();
			String sql = "select * from T_customer where customer_id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getUserId());
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
			  if(dto.getUserPassword().equals(rs.getString("customer_password"))) {
			    sql = "update T_customer set customer_password=?, customer_name=?,"
			        + "customer_email=?, customer_phone_number=?,"
			        + "customer_birth=?, customer_updated_at=sysdate";
			    pstmt = conn.prepareStatement(sql);
			    
			    pstmt.setString(1, dto.getUserPassword());
			    pstmt.setString(2, dto.getUserName());
			    pstmt.setString(3, dto.getUserEmail());
			    pstmt.setString(4, dto.getUserPhoneNumber());
			    pstmt.setString(5, dto.getUserBirth());
			    
			  }
			}
			
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
			String sql = "select * from T_customer where customer_id =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
			  sql = "delete from T_customer where customer_id=?";
			  pstmt = conn.prepareStatement(sql);
			  pstmt.setInt(1, id);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

}
