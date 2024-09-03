package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.CategoryDAO;
import com.teamtwo.model.CategoryDTO;

public class ModifyCategoryAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    String categoryName = request.getParameter("categoryName").trim();
    int categoryId = Integer.parseInt(request.getParameter("categoryId").trim());
    int categoryParentFk = Integer.parseInt(request.getParameter("categoryParentFk").trim());

    CategoryDTO dto = new CategoryDTO();

    dto.setCategoryId(categoryId);;
    dto.setCategoryName(categoryName);
    dto.setCategoryParentFk(categoryParentFk);

    CategoryDAO dao = CategoryDAO.getInstance();
    dao.update(dto);

    return null;
  }

}
