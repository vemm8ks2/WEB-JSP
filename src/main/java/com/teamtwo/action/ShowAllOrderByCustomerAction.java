package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.OrderDAO;

public class ShowAllOrderByCustomerAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    int ordercustomerFk = Integer.parseInt(request.getParameter("ordercustomerFk").trim());

    OrderDAO dao = OrderDAO.getInstance();

    dao.getOrder(ordercustomerFk);

    ActionForward forward = new ActionForward();

    forward.setRedirect(false);
    forward.setPath("");
    return forward;
  }

}
