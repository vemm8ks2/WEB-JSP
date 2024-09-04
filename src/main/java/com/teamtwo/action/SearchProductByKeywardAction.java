package com.teamtwo.action;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.ProductDAO;
import com.teamtwo.model.ProductDTO;

/**
 * 검색어에 따른 상품을 찾는 Action 입니다.
 *  
 * @author hsheeh
 */
public class SearchProductByKeywardAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    String keyword = request.getParameter("keyword").trim();

    ProductDAO dao = ProductDAO.getInstance();
    
    List<ProductDTO> list = dao.searchByKeyword(keyword);

    request.setAttribute("searchList", list);

    ActionForward forward = new ActionForward();
    
    forward.setRedirect(false);
    /**
     * TODO(24.09.04): 검색 페이지를 만들어야 합니다.
     */
    forward.setPath("");
    
    return forward;
  }
}
