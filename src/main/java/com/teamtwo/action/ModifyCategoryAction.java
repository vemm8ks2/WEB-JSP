package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.CategoryDAO;
import com.teamtwo.model.CategoryDTO;

/**
 * 카테고리를 수정하는 Action 입니다. 어드민 기능. 실제 사용이 될 기능일지는 미지수입니다.
 * 
 * @author hsheeh
 */
public class ModifyCategoryAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    /**
     * Q(24.09.03): category_parent_fk 데이터를 받을지는 고민을 해보아야 함.
     */
    String categoryName = request.getParameter("category_name").trim();
    int categoryId = Integer.parseInt(request.getParameter("category_id").trim());
    int categoryParentFk = Integer.parseInt(request.getParameter("category_parent_fk").trim());

    CategoryDTO dto = new CategoryDTO();

    dto.setCategoryId(categoryId);;
    dto.setCategoryName(categoryName);
    dto.setCategoryParentFk(categoryParentFk);

    CategoryDAO dao = CategoryDAO.getInstance();

    /**
     * TODO(24.09.03): 에러 핸들링
     */
    dao.update(dto);

    return null;
  }

}
