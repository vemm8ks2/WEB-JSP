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

      if (rs.next()) {
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

      while (rs.next()) {
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

      String sql;

      boolean hasParentFk = dto.getCategoryParentFk() != null;

      if (hasParentFk)
        sql = "INSERT INTO T_category VALUES(?, ?, ?)";
      else
        sql = "INSERT INTO T_category VALUES(?, ?, '')";

      pstmt = conn.prepareStatement(sql);

      pstmt.setInt(1, dto.getCategoryId());
      pstmt.setString(2, dto.getCategoryName());

      if (hasParentFk)
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

      /**
       * Q(24.09.03): 카테고리 부모 외래키를 수정해도 될지 생각해보아야 한다.
       */
      String sql =
          "UPDATE T_category SET category_name = ?, category_parent_fk = ? WHERE category_id = ?";

      pstmt = conn.prepareStatement(sql);
      
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
    /**
     * TODO(24.09.03): 카테고리는 부모 카테고리 외래키가 있기 떄문에 구조 상 자식 카테고리가 있다면 오라클에서 에러를 발생시킨다.
     * 이에 대한 에러를 던져주고 Action에서 처리하도록 한다.
     * 
     *  고민해볼 점: 자식 카테고리가 있는 카테고리를 지울 수는 없을까? 상식적으로 자식 카테고리가 있다면 자식만 남겨두고 부모 카테고리만
     *  삭제해서는 안 될 것이다. 그렇기 때문에 부모 카테고리가 삭제되는 경우 자식 카테고리까지 함께 삭제하는 방향으로 생각할 수 있다. 
     */
    
    try {
      open();

      String sql = "DELETE FROM T_category WHERE category_id = ?";
      
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, id);

      pstmt.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  }

  public Integer getCategoryId() {
    Integer id = null;

    try {
      open();

      String sql = "SELECT max(category_id) FROM T_category";

      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      if (rs.next())
        id = rs.getInt(1) + 1;

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }

    return id;
  }

}
