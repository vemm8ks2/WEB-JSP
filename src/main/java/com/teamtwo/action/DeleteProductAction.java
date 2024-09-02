package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.ProductDAO;

public class DeleteProductAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    int product_id = Integer.parseInt(request.getParameter("product_id").trim());
    
    ProductDAO dao = ProductDAO.getInstance();
    
    dao.delete(product_id);
    
    ActionForward forward = new ActionForward();
    
    forward.setRedirect(false);
    
    forward.setPath("");
    
    return forward;
  }

}