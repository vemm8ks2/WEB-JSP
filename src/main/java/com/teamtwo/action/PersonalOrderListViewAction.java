package com.teamtwo.action;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.teamtwo.model.CustomerDTO;
import com.teamtwo.model.OrderDAO;
import com.teamtwo.model.OrderDTO;

public class PersonalOrderListViewAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    
    HttpSession session = request.getSession();
    CustomerDTO customer = (CustomerDTO) session.getAttribute("customer"); // 세션에서 값 받아옴

    OrderDAO dao = OrderDAO.getInstance();

    List<OrderDTO> orderList = dao.getOrderListByCustomerId(customer.getCustomerId());

    request.setAttribute("orderList", orderList);
    request.setAttribute("url", "personalOrderList.jsp");
    request.setAttribute("stylesheet", "");
    
    ActionForward forward = new ActionForward();
    
    forward.setRedirect(false);
    forward.setPath("view/layout.jsp");
    
    return forward;
  }

}
