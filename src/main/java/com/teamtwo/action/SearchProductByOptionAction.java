package com.teamtwo.action;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.ProductDAO;
import com.teamtwo.model.ProductDTO;


public class SearchProductByOptionAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    
    String search_field = request.getParameter("field").trim();
    String search_keyword = request.getParameter("keyword").trim();
    
    ProductDAO dao = ProductDAO.getInstance();
    
    List<ProductDTO> searchList = dao.getAll();
    
    request.setAttribute("Search", searchList);
    
    return null;
  }

}
