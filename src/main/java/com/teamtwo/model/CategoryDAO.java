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

public class CategoryDAO implements BaseDAO<CategoryDTO> {

  private Connection conn = null;
  private PreparedStatement pstmt = null;
  private ResultSet rs = null;

  private static CategoryDAO instance = null;

  private CategoryDAO() {}

  public static CategoryDAO getInstance() {
    if (instance == null)
      instance = new CategoryDAO();

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
      if (rs != null)
        rs.close();
      if (pstmt != null)
        pstmt.close();
      if (conn != null)
        conn.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public CategoryDTO get(int id) {
    CategoryDTO dto = null;

    try {
      open();
      
      String sql = "select * from T_category where category_id = ?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, id);
      
      rs = pstmt.executeQuery();
      
      if(rs.next()) {
        dto = new CategoryDTO();
        
        dto.setCategoryId(rs.getInt("category_id"));
        dto.setCategoryName(rs.getString("category_name"));
        dto.setCategoryParentFk(rs.getInt("category_parent_fk"));
        
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }

    return dto;
  }

  @Override
  public List<CategoryDTO> getAll() {
    List<CategoryDTO> list = new ArrayList<>();

    try {
      open();
      
      String sql = "select * from T_category";
      pstmt = conn.prepareStatement(sql);
      
      rs = pstmt.executeQuery();
      
      while(rs.next()) {
        CategoryDTO dto = new CategoryDTO();
        
        dto.setCategoryId(rs.getInt("category_id"));
        dto.setCategoryName(rs.getString("category_name"));
        dto.setCategoryParentFk(rs.getInt("category_parent_fk"));
        
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
  public void save(CategoryDTO dto) {
    try {
      open();
      
      String sql = "insert into T_category values(?,?,?)";
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, dto.getCategoryId());
      pstmt.setString(2, dto.getCategoryName());
      pstmt.setInt(3, dto.getCategoryParentFk());
      
     pstmt.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  }

  @Override
  public void update(CategoryDTO dto) {
    try {
      open();
      
      String sql = "update T_category set category_name = ?, category_parent_fk = ? where category_id = ?";
      pstmt= conn.prepareStatement(sql);
      pstmt.setString(1, dto.getCategoryName());
      pstmt.setInt(2, dto.getCategoryParentFk());
      pstmt.setInt(3, dto.getCategoryId());
      
      pstmt.executeUpdate();

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
      
      String sql = "delete from T_category where category_id = ?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1,id);
      
      pstmt.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  }

}
