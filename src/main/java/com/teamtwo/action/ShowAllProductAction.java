package com.teamtwo.action;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.ProductDAO;
import com.teamtwo.model.ProductDTO;

public class ShowAllProductAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    
    ProductDAO dao = ProductDAO.getInstance();
    
    List<ProductDTO> list = dao.getAll();
    
    request.setAttribute("productList", list);
    
    ActionForward forward = new ActionForward();
    
    forward.setRedirect(false);
    
    forward.setPath("view/product_list.jsp");
    
    return forward;
  }

}
