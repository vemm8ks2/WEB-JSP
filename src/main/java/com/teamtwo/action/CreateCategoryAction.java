package com.teamtwo.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamtwo.model.CategoryDAO;
import com.teamtwo.model.CategoryDTO;

public class CreateCategoryAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    String categoryName = request.getParameter("category_name");
    String categoryParentFkParam = request.getParameter("category_parent_fk");
    Integer categoryParentFk = null;

    if (!(categoryParentFkParam == null)) {
      categoryParentFk = Integer.parseInt(categoryParentFkParam);
    }

    CategoryDAO dao = CategoryDAO.getInstance();

    CategoryDTO dto = new CategoryDTO();

    dto.setCategoryId(dao.getCategoryId());
    dto.setCategoryName(categoryName);
    dto.setCategoryParentFk(categoryParentFk);
    
    dao.save(dto);

    /* 
     * TODO: 카테고리 생성 시 적절한 반환 값 설정하기.
     */
    PrintWriter out = response.getWriter();
    out.println("카테고리 생성 성공"); 

    return null;
  }

}
