package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.OrderDAO;
import com.teamtwo.model.OrderDTO;

public class SwitchOrderStatusAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    
    int order_id = Integer.parseInt(request.getParameter("orderid").trim());
    String order_status = request.getParameter("orderstatus").trim();
    
    OrderDTO dto = new OrderDTO();
    
    dto.setOrderId(order_id);
    dto.setOrderStatus(order_status);
    
    OrderDAO dao = OrderDAO.getInstance();
    
    dao.update(dto);
    
    return null;
  }

}
