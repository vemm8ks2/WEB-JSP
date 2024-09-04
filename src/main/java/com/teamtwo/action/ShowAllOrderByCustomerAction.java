package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.OrderDAO;
import com.teamtwo.model.OrderDTO;

public class ShowAllOrderByCustomerAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    int order_customer_fk = Integer.parseInt(request.getParameter("order_customer_fk").trim());
    
    OrderDAO dao = OrderDAO.getInstance();
    
    OrderDTO order_customer = dao.get(order_customer_fk);
    
    request.setAttribute("orderCustomer", order_customer);
    
    ActionForward forward = new ActionForward();
    
    forward.setRedirect(false);
    
    forward.setPath("view/order_customer.jsp");
    
    return forward;
  }

}
