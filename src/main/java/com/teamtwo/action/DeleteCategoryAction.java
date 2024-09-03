package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.CategoryDAO;

public class DeleteCategoryAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    
    int categoryId = Integer.parseInt(request.getParameter("categoryId").trim());
    CategoryDAO dao = CategoryDAO.getInstance();
    
    dao.delete(categoryId);
    
    ActionForward forward = new ActionForward();
    
    forward.setRedirect(false);
    forward.setPath("");
    
    return forward;
  }

}
