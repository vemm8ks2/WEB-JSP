package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.OrderDAO;
import com.teamtwo.model.OrderDTO;

/**
 * 주문 상태를 변경하는 Action 입니다. 
 * 
 * @author joohp
 */
public class SwitchOrderStatusAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    
    int orderId = Integer.parseInt(request.getParameter("order_id").trim());
    String orderStatus = request.getParameter("order_status").trim();
    
    OrderDAO dao = OrderDAO.getInstance();
    
    OrderDTO dto = dao.get(orderId);
    
    dto.setOrderStatus(orderStatus);
    
    dao.switchOrderStatus(orderId, orderStatus);
    
    return null;
  }

}
