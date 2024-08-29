package com.teamtwo.action;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.OrderDAO;
import com.teamtwo.model.OrderDTO;

public class ShowAllOrderAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

     OrderDAO dao = OrderDAO.getInstance();
     
     List<OrderDTO> list = dao.getAll();
     
     request.setAttribute("orderList", list);
     
     ActionForward forward = new ActionForward();
     
     forward.setRedirect(false);
     
     forward.setPath("view/order_list.jsp");
    
    return forward;
    
  }

}
