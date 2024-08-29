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

public class OrderDAO implements BaseDAO<OrderDTO> {

  private Connection conn = null;
  private PreparedStatement pstmt = null;
  private ResultSet rs = null;

  private static OrderDAO instance = null;

  private OrderDAO() {}

  public static OrderDAO getInstance() {
    if (instance == null)
      instance = new OrderDAO();

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
  public OrderDTO get(int id) {
    OrderDTO dto = null;

    try {
      open();
      
      String sql = "select * from t_order where order_id = ?";
      
      pstmt = conn.prepareStatement(sql);
      
      pstmt.setInt(1, id);
      
      rs = pstmt.executeQuery();
      
      if(rs.next()) {
        dto = new OrderDTO();
        
        dto.setOrderId(rs.getInt("orderid"));
        dto.setOrderReceiverName(rs.getString("orderreceivername"));
        dto.setOrderReceiverPhone(rs.getString("orderreceiverphone"));
        dto.setOrderReceiverAddr(rs.getString("orderreceiveraddr"));
        dto.setOrderStatus(rs.getString("orderstatus"));
        dto.setOrderCreatedAt(rs.getString("ordercreatedat"));
        dto.setOrderDeliveredAt(rs.getString("orderdeliveredat"));
        dto.setOrderUserFk(rs.getInt("orderuserfk"));
        
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }

    return dto;
  } // get(id) end

  @Override
  public List<OrderDTO> getAll() {
    List<OrderDTO> list = new ArrayList<>();

    try {
      open();

      String sql = "select * from t_order";

      pstmt = conn.prepareStatement(sql);

      rs = pstmt.executeQuery();

      while (rs.next()) {
        OrderDTO dto = new OrderDTO();

        dto.setOrderId(rs.getInt("orderid"));
        dto.setOrderReceiverName(rs.getString("orderreceivername"));
        dto.setOrderReceiverPhone(rs.getString("orderreceiverphone"));
        dto.setOrderReceiverAddr(rs.getString("orderreceiveraddr"));
        dto.setOrderStatus(rs.getString("orderstatus"));
        dto.setOrderCreatedAt(rs.getString("ordercreatedat"));
        dto.setOrderDeliveredAt(rs.getString("orderdeliveredat"));
        dto.setOrderUserFk(rs.getInt("orderuserfk"));

        list.add(dto);

      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }

    return list;
  } // getAll() end

  @Override
  public void save(OrderDTO dto) {
    
    int count = 0;
    
    try {
      open();
      
      String sql = "select max(order_id) from t_order";
      
      pstmt = conn.prepareStatement(sql);
      
      rs = pstmt.executeQuery();
      
      if(rs.next()) {
        count = rs.getInt(1) + 1;
      }
      
      sql = "insert into T_order values (?,?,?,?,'발송대기',sysdate,'',?)";
      
      pstmt = conn.prepareStatement(sql);
      
      pstmt.setInt(1, count);
      pstmt.setString(2, dto.getOrderReceiverName());
      pstmt.setString(3, dto.getOrderReceiverPhone());
      pstmt.setString(4, dto.getOrderReceiverAddr());
      pstmt.setInt(5, dto.getOrderUserFk());
      
      pstmt.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  } // save(dto) end

  @Override
  public void update(OrderDTO dto) {
    try {
      open();
      
      String sql = "select * from t_order where order_id = ?";
            
      pstmt = conn.prepareStatement(sql);
      
      pstmt.setInt(1, dto.getOrderId());
      
      rs = pstmt.executeQuery();
      
      if(rs.next()) {
        if(dto.getOrderStatus().equals("발송대기")) {
          sql = "update t_order set order_status = '배송중'";
          
          pstmt = conn.prepareStatement(sql);
          
        } else if(dto.getOrderStatus().equals("배송중")) {
          sql = "update t_order set order_status = '배송완료', order_delivered_at = sysdate";
          
          pstmt = conn.prepareStatement(sql);
          
        }
        
        pstmt.executeUpdate();
        
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  } // update(dto) end

  @Override
  public void delete(int id) {
    try {
      open();
      
      String sql = "delete from t_order where order_id = ?";
      
      pstmt = conn.prepareStatement(sql);
      
      pstmt.setInt(1, id);
      
      pstmt.executeUpdate();
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  } // delete(id) end

}
