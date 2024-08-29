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

public class CartDAO implements BaseDAO<CartDTO> {

  private Connection conn = null;
  private PreparedStatement pstmt = null;
  private ResultSet rs = null;

  private static CartDAO instance = null;

  private CartDAO() {}

  public static CartDAO getInstance() {
    if (instance == null)
      instance = new CartDAO();

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
  public CartDTO get(int id) {
    CartDTO dto = null;

    try {
      open();

      String sql = "SELECT * FROM T_cart WHERE = ?";

      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, id);

      rs = pstmt.executeQuery();

      if (rs.next()) {
        dto = new CartDTO();

        dto.setCartId(rs.getInt("cart_id"));
        dto.setCartProductCount(rs.getInt("cart_product_count"));
        dto.setCartCustomerFk(rs.getInt("cart_customer_fk"));
        dto.setCartProductFk(rs.getInt("cart_product_fk"));
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }

    return dto;
  }

  @Override
  public List<CartDTO> getAll() {
    List<CartDTO> list = new ArrayList<>();

    try {
      open();

      String sql = "SELECT * FROM T_cart";

      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        CartDTO dto = new CartDTO();

        dto.setCartId(rs.getInt("cart_id"));
        dto.setCartProductCount(rs.getInt("cart_product_count"));
        dto.setCartCustomerFk(rs.getInt("cart_customer_fk"));
        dto.setCartProductFk(rs.getInt("cart_product_fk"));

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
  public void save(CartDTO dto) {
    try {
      open();

      Integer newCartId = getCartId();
      if (newCartId == null)
        throw new SQLException();

      String sql = "INSERT INTO T_cart VALUES(?, ?, ?, ?)";

      pstmt = conn.prepareStatement(sql);

      pstmt.setInt(1, dto.getCartId());
      pstmt.setInt(2, dto.getCartProductCount());
      pstmt.setInt(3, dto.getCartCustomerFk());
      pstmt.setInt(4, dto.getCartProductFk());

      int result = pstmt.executeUpdate(sql);

      /*
       * TODO: 업데이트에 실패하였을 때 에러 핸들링
       */
      if (result > 0)
        throw new SQLException();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  }

  @Override
  public void update(CartDTO dto) {
    try {
      open();

      CartDTO prevDto = get(dto.getCartId());
      /*
       * TODO: 카트가 없는 경우 즉, id가 잘못된 경우 에러 핸들링
       */
      if (prevDto == null)
        new SQLException();

      String sql = "UPDATE T_cart SET cart_product_count = ? WHERE cart_id = ?";

      pstmt = conn.prepareStatement(sql);

      pstmt.setInt(1, dto.getCartProductCount());
      pstmt.setInt(2, dto.getCartId());

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

      CartDTO dto = get(id);
      /*
       * TODO: 카트가 없는 경우 즉, id가 잘못된 경우 에러 핸들링
       */
      if (dto == null)
        throw new SQLException();
      
      String sql = "DELETE FROM T_cart WHERE cart_id = ?";
      
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, id);
      
      int result = pstmt.executeUpdate();
      /*
       * TODO: 삭제에 실패하였을 때 에러 핸들링
       */
      if (result > 0)
        throw new SQLException();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  }

  /*
   * 데이터베이스에 저장되어 있는 데이터 중 cart_id가 가장 큰 값을 가져온 후
   * 1을 더하여 새로운 cart_id 번호를 반환합니다.
   */
  public Integer getCartId() {
    Integer id = null;

    try {
      open();

      String sql = "SELECT max(cart_id) FROM T_cart";

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
