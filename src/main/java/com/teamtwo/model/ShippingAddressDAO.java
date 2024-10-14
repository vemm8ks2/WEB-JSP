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

  /**
   * @param 배송지의 식별자를 인자로 받습니다.
   * @author bborib
   */
  @Override
  public ShippingAddressDTO get(int id) {

    ShippingAddressDTO dto = null;

    try {
      open();

      String sql = "SELECT * FROM T_shipping_address WHERE shipping_address_id = ?";

      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, id);

      rs = pstmt.executeQuery();

      if (rs.next()) {
        dto = new ShippingAddressDTO();

        dto.setShippingAddressId(rs.getInt("shipping_address_id"));
        dto.setShippingAddressDestination(rs.getString("shipping_address_destination"));
        dto.setShippingAddressIsDefault(rs.getString("shipping_address_is_default"));
        dto.setShippingAddressCustomerFk(rs.getInt("shipping_address_customer_Fk"));
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }

    return dto;
  }

  /**
   * @author bborib
   */
  @Override
  public List<ShippingAddressDTO> getAll() {
    List<ShippingAddressDTO> list = new ArrayList<>();

    try {
      open();

      String sql = "SELECT * FROM T_shipping_address ORDER BY shipping_address_id DESC";

      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        ShippingAddressDTO dto = new ShippingAddressDTO();

        dto.setShippingAddressId(rs.getInt("shipping_address_id"));
        dto.setShippingAddressDestination(rs.getString("shipping_address_destination"));
        dto.setShippingAddressIsDefault(rs.getString("shipping_address_is_default"));
        dto.setShippingAddressCustomerFk(rs.getInt("shipping_address_customer_Fk"));

        list.add(dto);
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }

    return list;
  }

  /**
   * @param 배송지 DTO를 인자로 받아서 새롭게 저장하는 메소드입니다.
   * @author bborib
   */
  @Override
  public void save(ShippingAddressDTO dto) {
    try {
      open();

      String sql = "INSERT INTO T_shipping_address VALUES(?, ?, 'N', ?)";

      pstmt = conn.prepareStatement(sql);

      pstmt.setInt(1, dto.getShippingAddressId());
      pstmt.setString(2, dto.getShippingAddressDestination());
      pstmt.setInt(3, dto.getShippingAddressCustomerFk());

      pstmt.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  }

  /**
   * @param 배송지 DTO 객체를 인자로 받습니다.
   * @author bborib
   */
  @Override
  public void update(ShippingAddressDTO dto) {
    try {
      open();

      /**
       * TODO(24.09.03): 유저의 외래키를 수정할 일은 없어야 합니다.
       */
      String sql = "UPDATE T_shipping_address " + "SET shipping_address_destination = ?,"
          + " shipping_address_is_default = ?, " + " WHERE shipping_address_id = ?";

      pstmt = conn.prepareStatement(sql);

      pstmt.setString(1, dto.getShippingAddressDestination());
      pstmt.setString(2, dto.getShippingAddressIsDefault());
      pstmt.setInt(3, dto.getShippingAddressId());

      pstmt.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  }

  /**
   * @param 배송지의 식별자를 인자로 받습니다.
   * @author bborib
   */
  @Override
  public void delete(int id) {
    /**
     * TODO(24.09.03): 에러 발생 시 throw
     */

    try {
      open();

      String sql = "DELETE FROM T_shipping_address WHERE shipping_address_id = ?";

      pstmt = conn.prepareStatement(sql);

      pstmt.setInt(1, id);
      pstmt.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  }

  /**
   * 배송지의 식별자를 인자로 받아서 해당하는 배송지를 기본 배송지로 설정해주는 메소드입니다.
   * 
   * @param 배송지의 식별자를 인자로 받습니다.
   * @author joohp
   */
  public void setDefault(int id) {
    /**
     * TODO(24.10.12): 무조건 기본 배송지로 업데이트 해주는데 이전에 기본 배송지가 있는지 확인이 필요합니다.
     */

    try {
      open();

      String sql =
          "UPDATE T_shipping_address SET shipping_address_is_default = 'Y' WHERE shipping_address_id = ?";

      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, id);

      pstmt.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      close();
    }
  } // getupdate(id) end

  public void unsetDefault(int customerId) {
    try {
      open();

      String sql = "UPDATE T_shipping_address " + "SET shipping_address_is_default = 'N' "
          + "WHERE shipping_address_customer_fk = ? AND shipping_address_is_default = 'Y'";

      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, customerId);

      pstmt.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  }

  public Integer getNewId() {
    Integer id = null;

    try {
      open();

      String sql = "SELECT max(shipping_address_id) FROM T_shipping_address";

      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      if (rs.next()) {
        id = rs.getInt(1) + 1;
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }

    return id;
  }

  /**
   * 유저의 식별자를 인자로 받아서 해당하는 유저의 모든 배송지 리스트를 반환해주는 메소드입니다.
   * 
   * @param 유저의 식별자를 인자로 받습니다.
   * @author vemm8ks2
   */
  public List<ShippingAddressDTO> getShippingAddressByCustomer(int id) {

    List<ShippingAddressDTO> list = new ArrayList<>();

    try {
      open();

      String sql = "SELECT * FROM T_shipping_address WHERE shipping_address_customer_fk = ?";

      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, id);

      rs = pstmt.executeQuery();

      while (rs.next()) {
        ShippingAddressDTO dto = new ShippingAddressDTO();

        dto.setShippingAddressId(rs.getInt("shipping_address_id"));
        dto.setShippingAddressDestination(rs.getString("shipping_address_destination"));
        dto.setShippingAddressIsDefault(rs.getString("shipping_address_is_default"));
        dto.setShippingAddressCustomerFk(rs.getInt("shipping_address_customer_fK"));

        list.add(dto);
      }

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      close();
    }

    return list;
  }

  public void modifyShippingAddressDestination(ShippingAddressDTO dto) {
    try {
      open();

      String sql =
          "UPDATE T_shipping_address SET shipping_address_destination = ? WHERE shipping_address_id = ?";

      pstmt = conn.prepareStatement(sql);

      pstmt.setString(1, dto.getShippingAddressDestination());
      pstmt.setInt(2, dto.getShippingAddressId());

      pstmt.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  }

}
