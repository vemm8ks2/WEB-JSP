package com.teamtwo.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.CartDAO;
import com.teamtwo.model.CartDTO;

public class ShowCartListAction implements Action{

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    CartDAO dao = CartDAO.getInstance();
    
    List<CartDTO> list = dao.getAll();
    
    request.setAttribute("cartList", list);
    
    PrintWriter out = response.getWriter();
    
    ActionForward forward = new ActionForward();
    
    forward.setRedirect(false);
    
    forward.setPath("view/cart_list.jsp");
    
    return forward;
    
  }

}
