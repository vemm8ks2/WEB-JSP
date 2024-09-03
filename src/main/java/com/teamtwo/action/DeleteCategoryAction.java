package com.teamtwo.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.CategoryDAO;

/**
 * 카테고리를 삭제하는 Action. 일반적으로는 어드민이 수행할 액션입니다. 
 * @author joohp
 */
public class DeleteCategoryAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    
    int categoryId = Integer.parseInt(request.getParameter("category_id").trim());
    
    CategoryDAO dao = CategoryDAO.getInstance();
    
    /**
     * TODO(24.09.03): 메서드 실행 중 발생하는 에러 핸들링
     */
    dao.delete(categoryId);
    
    PrintWriter out = response.getWriter();
    
    out.println("삭제가 성공하였습니다.");
  
    return null;
  }

}
