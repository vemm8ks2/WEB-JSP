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

  /**
   * @param 주문의 식별자를 인자로 받습니다.
   * @author skwns0472
   */
  @Override
  public OrderDTO get(int id) {
    OrderDTO dto = null;

    try {
      open();

      String sql = "SELECT * FROM t_order WHERE order_id = ?";

      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, id);

      rs = pstmt.executeQuery();

      if (rs.next()) {
        dto = new OrderDTO();

        dto.setOrderId(rs.getInt("orderid"));
        dto.setOrderReceiverName(rs.getString("orderreceivername"));
        dto.setOrderReceiverPhone(rs.getString("orderreceiverphone"));
        dto.setOrderReceiverAddr(rs.getString("orderrecipientaddr"));
        dto.setOrderStatus(rs.getString("orderstatus"));
        dto.setOrderCreatedAt(rs.getString("ordercreatedat"));
        dto.setOrderDeliveredAt(rs.getString("orderdeliveredat"));
        dto.setOrderCustomerFk(rs.getInt("ordercustomerfk"));
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }

    return dto;
  } // get(id) end

  /**
   * @author skwns0472
   */
  @Override
  public List<OrderDTO> getAll() {
    List<OrderDTO> list = new ArrayList<>();

    try {
      open();

      String sql = "SELECT * FROM t_order";

      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        OrderDTO dto = new OrderDTO();

        dto.setOrderId(rs.getInt("orderid"));
        dto.setOrderReceiverName(rs.getString("orderreceivername"));
        dto.setOrderReceiverPhone(rs.getString("orderreceiverphone"));
        dto.setOrderReceiverAddr(rs.getString("orderRecipientaddr"));
        dto.setOrderStatus(rs.getString("orderstatus"));
        dto.setOrderCreatedAt(rs.getString("ordercreatedat"));
        dto.setOrderDeliveredAt(rs.getString("orderdeliveredat"));
        dto.setOrderCustomerFk(rs.getInt("ordercustomerfk"));

        list.add(dto);

      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }

    return list;
  } // getAll() end

  /**
   * @param 주문 DTO를 인자로 받아서 새롭게 저장하는 메소드입니다.
   * @author skwns0472
   */
  @Override
  public void save(OrderDTO dto) {

    int count = 0;

    try {
      open();

      /**
       * Q(24.09.05): 주문의 식별자를 가져오는 역할을 하는 메소드를 새롭게 만드는 것을 고려해보자.
       */
      String sql = "SELECT max(order_id) FROM t_order";

      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();

      if (rs.next())
        count = rs.getInt(1) + 1;

      sql = "INSERT INTO T_order VALUES (?, ?, ?, ?, '발송대기', sysdate, '', ?)";

      pstmt = conn.prepareStatement(sql);

      pstmt.setInt(1, count);
      pstmt.setString(2, dto.getOrderReceiverName());
      pstmt.setString(3, dto.getOrderReceiverPhone());
      pstmt.setString(4, dto.getOrderReceiverAddr());
      pstmt.setInt(5, dto.getOrderCustomerFk());

      pstmt.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  } // save(dto) end

  /**
   * @param 주문 DTO 객체를 인자로 받습니다.
   * @author skwns0472
   */
  @Override
  public void update(OrderDTO dto) {
    try {
      open();

      String sql = "SELELCT * FROM t_order WHERE order_id = ?";

      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, dto.getOrderId());

      rs = pstmt.executeQuery();

      /**
       * Q(24.09.03): 적절한 코드인지 고민해볼 필요가 있음.
       */
      if (rs.next()) {
        if (dto.getOrderStatus().equals("발송대기")) {
          sql = "UPDATE t_order SET order_status = '배송중' where order_id = ?";
          pstmt = conn.prepareStatement(sql);
          pstmt.setInt(1, dto.getOrderId());

        } else if (dto.getOrderStatus().equals("배송중")) {
          sql = "UPDATE t_order SET order_status = '배송완료', order_delivered_at = sysdate where order_id = ?";
          pstmt = conn.prepareStatement(sql);
          pstmt.setInt(1, dto.getOrderId());

        }

        pstmt.executeUpdate();

      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  } // update(dto) end

  /**
   * @param 주문의 식별자를 인자로 받습니다.
   * @author skwns0472
   */
  @Override
  public void delete(int id) {
    try {
      open();

      String sql = "DELETE FROM t_order WHERE order_id = ?";

      pstmt = conn.prepareStatement(sql);

      pstmt.setInt(1, id);
      pstmt.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }
  } // delete(id) end

  /**
   * 유저의 식별자를 인자로 받아서 해당하는 유저의 모든 주문 목록을 불러오는 메소드입니다.
   * 
   * @param 고객의 식별자를 인자로 받습니다.
   * @return 고객의 모든 주문 목록을 리스트 형태로 반환합니다.
   * @author vemm8ks2
   */
  public List<OrderDTO> getOrderListByCustomerId(int customerId) {

    List<OrderDTO> list = new ArrayList<>();

    try {
      open();

      String sql = "SELECT * FROM t_order WHERE order_customer_fk = ?";

      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, customerId);

      rs = pstmt.executeQuery();

      while (rs.next()) {

        OrderDTO dto = new OrderDTO();

        dto.setOrderId(rs.getInt("order_id"));
        dto.setOrderReceiverName(rs.getString("orderr_eceiver_name"));
        dto.setOrderReceiverPhone(rs.getString("order_receiver_phone"));
        dto.setOrderReceiverAddr(rs.getString("order_recipient_addr")); 
        dto.setOrderStatus(rs.getString("order_status"));
        dto.setOrderCreatedAt(rs.getString("order_created_at"));
        dto.setOrderDeliveredAt(rs.getString("order_delivered_at"));
        dto.setOrderCustomerFk(rs.getInt("order_customer_fk"));

        list.add(dto);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      close();
    }

    return list;
  }
  
  //주문 상태 변경 메서드
  public void switchOrderStatus(int orderId, String orderStatus) {
	  
	  try {
		open();

		//주문 테이블에서 주문번호로 모든 정보 불러오기
		String sql = "SELECT * from t_order WHERE order_id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, orderId);
		
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			//orderStatus(주문 상태) : 발송대기, 배송중, 배송완료, 주문취소
			if(orderStatus.equals("배송중")) {
				sql = "UPDATE t_order set order_status = ? where order_id = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, orderStatus);
				pstmt.setInt(2, orderId);
				pstmt.executeUpdate();
				} 
			else if(orderStatus.equals("배송완료")) { 
				sql = "UPDATE t_order SET order_status = ?, order_delivered_at = sysdate WHERE order_id = ?";
				
				pstmt.setString(1, orderStatus);
				pstmt.setInt(2, orderId);
				pstmt.executeUpdate();
			}
			else if(orderStatus.equals("주문취소")) {
				sql = "UPDATE t_order SET order_status = ?, order_delivered_at = '' WHERE order_id = ?";
				
				pstmt.setString(1, orderStatus);
				pstmt.setInt(2, orderId);
				pstmt.executeUpdate();
			}
		}
				
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		close();
	}
  } // switchOrderStatus() end

}
