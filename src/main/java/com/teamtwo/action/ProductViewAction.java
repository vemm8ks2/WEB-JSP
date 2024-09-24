package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.ProductDAO;
import com.teamtwo.model.ProductDTO;

public class ProductViewAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    int productId = Integer.parseInt(request.getParameter("id").trim());

    ProductDAO dao = ProductDAO.getInstance();

    ProductDTO product = dao.get(productId);

    request.setAttribute("product", product);
    request.setAttribute("url", "product.jsp");
    request.setAttribute("stylesheet", "product.css");

    ActionForward forward = new ActionForward();

    forward.setRedirect(false);
    forward.setPath("view/layout.jsp");

    return forward;
  }

}
