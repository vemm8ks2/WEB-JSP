package com.teamtwo.action;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.teamtwo.model.CartDAO;
import com.teamtwo.model.CartResultDTO;
import com.teamtwo.model.CustomerDTO;

public class CartViewAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    HttpSession session = request.getSession();
    CustomerDTO customer = (CustomerDTO) session.getAttribute("customer"); // 세션에서 값 받아옴
    
    CartDAO dao = CartDAO.getInstance();
    
    List<CartResultDTO> cartResult = dao.getCartListByCustomer(customer.getCustomerId());
    
    request.setAttribute("cartResult", cartResult);

    request.setAttribute("url", "cart.jsp");
    request.setAttribute("stylesheet", "");

    ActionForward forward = new ActionForward();

    forward.setRedirect(false);
    forward.setPath("view/layout.jsp");

    return forward;
  }

}
