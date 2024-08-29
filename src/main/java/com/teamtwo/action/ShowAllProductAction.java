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

    List<ProductDTO> productList = dao.getAll();

    request.setAttribute("productList", productList);

    ActionForward forward = new ActionForward();

    forward.setPath(""); // TODO: path 설정하기.
    forward.setRedirect(false);

    return forward;
  }

}
