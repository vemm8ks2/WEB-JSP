package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.CartDAO;

public class DeleteProductFromCartAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    int cartId = Integer.parseInt(request.getParameter("cartId").trim());
    CartDAO dao = CartDAO.getInstance();
    dao.delete(cartId);
    
    ActionForward forward = new ActionForward();
    
    forward.setRedirect(false);
    
    forward.setPath("");
    
    return forward;
  }

}
