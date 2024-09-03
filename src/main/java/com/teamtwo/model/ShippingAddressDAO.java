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

public class ShippingAddressDAO implements BaseDAO<ShippingAddressDTO> {

  private Connection conn = null;
  private PreparedStatement pstmt = null;
  private ResultSet rs = null;

  private static ShippingAddressDAO instance = null;

  private ShippingAddressDAO() {}

  public static ShippingAddressDAO getInstance() {
    if (instance == null)
      instance = new ShippingAddressDAO();

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
  public ShippingAddressDTO get(int id) {
    ShippingAddressDTO dto = null;

    try {
      open();

      String sql = "select * from T_shipping_address where shipping_address_id = ?";

      pstmt = conn.prepareStatement(sql);

      pstmt.setInt(1, id);

      rs = pstmt.executeQuery();

      if (rs.next()) {

        dto = new ShippingAddressDTO();

        dto.setShippingAddressId(rs.getInt("shipping_address_id"));
        dto.setShippingAddressAddress(rs.getString("shipping_address_destination"));
        dto.setShippingAddressIsDefault(rs.getString("shipping_address_is_default"));
        dto.setShippingAddressUserIdFk(rs.getInt("shipping_address_customer_fk"));

      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }

    return dto;
  }

  @Override
  public List<ShippingAddressDTO> getAll() {
    List<ShippingAddressDTO> list = new ArrayList<>();

    try {
      open();

      String sql = "select * from T_shipping_address order by shipping_address_id desc";

      pstmt = conn.prepareStatement(sql);

      rs = pstmt.executeQuery();

      while (rs.next()) {

        ShippingAddressDTO dto = new ShippingAddressDTO();

        dto.setShippingAddressId(rs.getInt("shipping_address_id"));
        dto.setShippingAddressAddress(rs.getString("shipping_address_destination"));
        dto.setShippingAddressIsDefault(rs.getString("shipping_address_is_default"));
        dto.setShippingAddressUserIdFk(rs.getInt("shipping_address_customer_fk"));

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
  public void save(ShippingAddressDTO dto) {
    try {
      open();

      String sql = "SELECT max(shipping_address_id) FROM T_shipping_address";

      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      Integer count = null;

      if (rs.next())
        count = rs.getInt(1) + 1;

      /**
       * TODO(24.09.03): 에러 핸들링
       */
      if (count == null)
        throw new SQLException();

      sql = "INSERT INTO T_shipping_address VALUES(?, ?, ?, ?)";

      pstmt = conn.prepareStatement(sql);

      pstmt.setInt(1, count);
      pstmt.setString(2, dto.getShippingAddressAddress());
      pstmt.setString(3, dto.getShippingAddressIsDefault());
      pstmt.setInt(4, dto.getShippingAddressUserIdFk());

      pstmt.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  }

  @Override
  public void update(ShippingAddressDTO dto) {
    try {
      open();

      /**
       * TODO(24.09.03): 유저의 외래키를 수정할 일은 없어야 합니다.
       */
      String sql = "update T_shipping_address set " + "shipping_address_destination = ?,"
          + "shipping_address_is_default = ?, " + "shipping_address_customer_fk = ?,"
          + "where shipping_address_id = ?";

      pstmt = conn.prepareStatement(sql);

      pstmt.setString(1, dto.getShippingAddressAddress());
      pstmt.setString(2, dto.getShippingAddressIsDefault());
      pstmt.setInt(3, dto.getShippingAddressUserIdFk());
      pstmt.setInt(4, dto.getShippingAddressId());

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

      String sql = "delete from T_shipping_address where shipping_address_id = ?";

      pstmt = conn.prepareStatement(sql);

      pstmt.setInt(1, id);

      pstmt.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  }

}
