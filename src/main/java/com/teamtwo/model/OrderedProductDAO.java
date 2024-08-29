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
  String sql = null;

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
  public OrderedProductDTO get(int id) {
    OrderedProductDTO dto = null;

    try {
      open();
      
      sql = "select * from t_ordered_product where ordered_product_id = ?";
      
      pstmt = conn.prepareStatement(sql);
      
      pstmt.setInt(1, id);
      
      rs = pstmt.executeQuery();
      
      if(rs.next()) {
        dto = new OrderedProductDTO();
        dto.getOrderedProductId();
        dto.getOrderedProductQunatity();
        dto.getOrderedProductUserIdFk();
        dto.getOrderedProductProdIdFk();
        
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }

    return dto;
  } // OrderedProduct() end

  @Override
  public List<OrderedProductDTO> getAll() {
    List<OrderedProductDTO> list = new ArrayList<>();

    try {
      open();

      sql = "select * from t_ordered_product";

      pstmt = conn.prepareStatement(sql);

      rs = pstmt.executeQuery();

      while (rs.next()) {

        OrderedProductDTO dto = new OrderedProductDTO();

        dto.setOrderedProductId(rs.getInt("orderedproductid"));
        dto.setOrderedProductQunatity(rs.getInt("orderedproductqunatity"));
        dto.setOrderedProductUserIdFk(rs.getInt("orderedproductuseridfk"));
        dto.setOrderedProductProdIdFk(rs.getInt("orderedproductprodidfk"));

        list.add(dto);

      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }

    return list;
  } // List end

  @Override
  public void save(OrderedProductDTO dto) {
    try {
      open();
      
      sql = "insert into t_ordered_product (ordered_product_id, "
          + "ordered_product_qunatity, ordered_product_order_fk, "
          + "ordered_product_product_fk)"
          + " values(?,?,?,?)";
      
      pstmt = conn.prepareStatement(sql);
      
      pstmt.setInt(1, dto.getOrderedProductId());
      pstmt.setInt(2, dto.getOrderedProductQunatity());
      pstmt.setInt(3, dto.getOrderedProductUserIdFk());
      pstmt.setInt(4, dto.getOrderedProductProdIdFk());
      
      pstmt.executeUpdate();
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  } // save() end

  @Override
  public void update(OrderedProductDTO dto) {

    try {
      open();
      
      sql = "update t_ordered_product set ordered_product_qunatity = ? "
          + " where ordered_product_id = ?";
      
      pstmt = conn.prepareStatement(sql);
      
      
      pstmt.setInt(1, dto.getOrderedProductQunatity());
      pstmt.setInt(2, dto.getOrderedProductId());
      
      pstmt.executeUpdate();
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  } // update end
 
  @Override
  public void delete(int id) {

    try {
      open();
      
      sql = "select * from t_ordered_product where ordered_product_id = ?";
      
      pstmt = conn.prepareStatement(sql);
      
      pstmt.setInt(1, id);
      
      rs = pstmt.executeQuery();
      
      if(rs.next()) {
        
        sql = "delete from t_ordered_product where ordered_product_id = ?";
        
        pstmt = conn.prepareStatement(sql);
        
        pstmt.setInt(1, id);
        
        pstmt.executeUpdate();
      
      } // if end
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
    
  } // delete end

} // class end
