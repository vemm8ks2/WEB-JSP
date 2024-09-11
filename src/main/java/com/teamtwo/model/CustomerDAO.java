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

public class CustomerDAO implements BaseDAO<CustomerDTO> {

  private Connection conn = null;
  private PreparedStatement pstmt = null;
  private ResultSet rs = null;

  private static CustomerDAO instance = null;

  private CustomerDAO() {}

  public static CustomerDAO getInstance() {
    if (instance == null)
      instance = new CustomerDAO();

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
  public CustomerDTO get(int id) {

    CustomerDTO dto = null;

    try {
      open();

      String sql = "SELECT * FROM T_customer WHERE customer_id = ?";

      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, id);

      rs = pstmt.executeQuery();

      if (rs.next()) {
        dto = new CustomerDTO();

        dto.setCustomerId(rs.getInt("customer_id"));
        dto.setCustomerLoginId(rs.getString("customer_login_id"));
        dto.setCustomerPassword(rs.getString("customer_password"));
        dto.setCustomerName(rs.getString("customer_name"));
        dto.setCustomerEmail(rs.getString("customer_email"));
        dto.setCustomerPhoneNumber(rs.getString("customer_phone_number"));
        dto.setCustomerGender(rs.getString("customer_gender"));
        dto.setCustomerBirth(rs.getString("customer_birth"));
        dto.setCustomerCreatedAt(rs.getString("customer_created_at"));
        dto.setCustomerUpdatedAt(rs.getString("customer_updated_at"));
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }

    return dto;
  }

  @Override
  public List<CustomerDTO> getAll() {

    List<CustomerDTO> list = new ArrayList<>();

    try {
      open();
      String sql = "SELECT * FROM T_customer";

      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        CustomerDTO dto = new CustomerDTO();

        dto.setCustomerId(rs.getInt("customer_id"));
        dto.setCustomerLoginId(rs.getString("customer_login_id"));
        dto.setCustomerPassword(rs.getString("customer_password"));
        dto.setCustomerName(rs.getString("customer_name"));
        dto.setCustomerEmail(rs.getString("customer_email"));
        dto.setCustomerPhoneNumber(rs.getString("customer_phone_number"));
        dto.setCustomerGender(rs.getString("customer_gender"));
        dto.setCustomerBirth(rs.getString("customer_birth"));
        dto.setCustomerCreatedAt(rs.getString("customer_created_at"));
        dto.setCustomerUpdatedAt(rs.getString("customer_updated_at"));

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
  public void save(CustomerDTO dto) {
    try {
      open();

      String sql = "INSERT INTO T_customer VALUES(?,?,?,?,'',?,'','',sysdate,'')";

      pstmt = conn.prepareStatement(sql);

      pstmt.setInt(1, dto.getCustomerId());
      pstmt.setString(2, dto.getCustomerLoginId());
      pstmt.setString(3, dto.getCustomerPassword());
      pstmt.setString(4, dto.getCustomerName());
      pstmt.setString(5 , dto.getCustomerPhoneNumber());

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  }

  @Override
  public void update(CustomerDTO dto) {
    try {
      open();

      String sql = "SELECT * FROM T_customer WHERE customer_id=?";

      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, dto.getCustomerId());

      rs = pstmt.executeQuery();

      if (rs.next()) {
        sql = "UPDATE T_customer SET customer_password = ?, customer_name = ?,"
            + "customer_email = ?, customer_phone_number = ?,"
            + "customer_birth = ?, customer_updated_at = sysdate where customer_id = ?";

        pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, dto.getCustomerPassword());
        pstmt.setString(2, dto.getCustomerName());
        pstmt.setString(3, dto.getCustomerEmail());
        pstmt.setString(4, dto.getCustomerPhoneNumber());
        pstmt.setString(5, dto.getCustomerBirth());
        pstmt.setInt(6, dto.getCustomerId());

        pstmt.executeUpdate(sql);
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

      String sql = "SELECT * FROM T_customer WHERE customer_id = ?";

      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, id);

      rs = pstmt.executeQuery();

      if (rs.next()) {
        sql = "DELETE FROM T_customer WHERE customer_id = ?";

        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);

        pstmt.executeUpdate();
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  }

  public CustomerDTO getCustomerByLoginId(String customerLoginId) {

    CustomerDTO dto = null;

    try {
      open();

      String sql = "SELECT * FROM T_customer WHERE customer_login_id = ?";

      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, customerLoginId);

      rs = pstmt.executeQuery();

      if (rs.next()) {
        dto = new CustomerDTO();

        dto.setCustomerId(rs.getInt("customer_id"));
        dto.setCustomerLoginId(rs.getString("customer_login_id"));
        dto.setCustomerPassword(rs.getString("customer_password"));
        dto.setCustomerName(rs.getString("customer_name"));
        dto.setCustomerEmail(rs.getString("customer_email"));
        dto.setCustomerPhoneNumber(rs.getString("customer_phone_number"));
        dto.setCustomerGender(rs.getString("customer_gender"));
        dto.setCustomerBirth(rs.getString("customer_birth"));
        dto.setCustomerCreatedAt(rs.getString("customer_created_at"));
        dto.setCustomerUpdatedAt(rs.getString("customer_updated_at"));
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }

    return dto;
  }

  // 로그인
  public int customerCheck(String customerLoginId, String customerLoginPwd) {
    
    int result = 0;
    
    try {
       open();
      
       String sql = "select * from T_customer where customer_login_id = ?";
       
       pstmt = conn.prepareStatement(sql);
       
       pstmt.setString(1, customerLoginPwd);
       
       rs = pstmt.executeQuery();
       
       if(rs.next()) {
        
         if(customerLoginPwd.equals(rs.getString("customer_password"))) {
           System.out.println("환영합니다 회원님."); // 확인용
           result = 1;
           
        } else { // 비번이 틀린 경우 or 로그인 정보가 없는 경우
          result = -1;
        }
      }
      
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        close();
    }
    
    return result;
    
  }
  
  public Integer getCustomerId() {
    Integer id = null;
    
    try {
      open();
      
      String sql = "SELECT max(customer_id) from t_customer";
      
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      
      if(rs.next())
        id = rs.getInt(1) + 1;
      
    } catch (Exception e) {
      e.printStackTrace();
    
    } finally {
      close();
    }
    
    return id;
  }


}