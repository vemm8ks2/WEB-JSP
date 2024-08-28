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

public class AdminDAO implements BaseDAO<AdminDTO> {

  private Connection conn = null;
  private PreparedStatement pstmt = null;
  private ResultSet rs = null;

  private static AdminDAO instance = null;

  private AdminDAO() {}

  public static AdminDAO getInstance() {
    if (instance == null)
      instance = new AdminDAO();

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
  public AdminDTO get(int id) {
    AdminDTO dto = null;

    try {
      open();

      String sql = "";
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }

    return dto;
  }

  @Override
  public List<AdminDTO> getAll() {
    List<AdminDTO> list = new ArrayList<>();

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
  public void save(AdminDTO dto) {
    try {
      open();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  }

  @Override
  public void update(AdminDTO dto) {
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
