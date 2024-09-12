package com.teamtwo.action;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.ProductDAO;
import com.teamtwo.model.ProductDTO;
import com.teamtwo.model.SearchDTO;

public class SearchViewAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    
    /**
     * Q(24.09.12): 검색어(keyword)가 없는 경우는 어떻게 핸들링하는 게 적절할까?
     */
    
    String keyword = request.getParameter("keyword");
    String sort = request.getParameter("sort-filter");
    String price = request.getParameter("price-filter");
    String[] categories = request.getParameterValues("category-filter");
    
    SearchDTO dto = new SearchDTO();
    
    dto.setKeyword(keyword);
    dto.setSort(sort);
    dto.setPrice(price);
    dto.setCategories(categories);
    
    ProductDAO dao = ProductDAO.getInstance();
    
    List<ProductDTO> list = dao.searchByKeywordAndFilter(dto);
    
    request.setAttribute("keyword", keyword);
    request.setAttribute("list", list);

    request.setAttribute("url", "search.jsp");
    request.setAttribute("stylesheet", "search.css");
    request.setAttribute("javascript", "search.js");
    
    ActionForward forward = new ActionForward();
    
    forward.setRedirect(false);
    forward.setPath("view/layout.jsp");
    
    return forward;
  }

}
