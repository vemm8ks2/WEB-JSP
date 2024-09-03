package com.teamtwo.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.CategoryDAO;

public class DeleteCategoryAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    
    int category_id = Integer.parseInt(request.getParameter("categoryid").trim());
    
    CategoryDAO dao = CategoryDAO.getInstance();
    
    dao.delete(category_id);
    
    PrintWriter out = response.getWriter();
    
    out.println("삭제가 성공하였습니다.");
  
    return null;
  }

}
