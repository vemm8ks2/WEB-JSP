package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.CartDAO;
import com.teamtwo.model.CartDTO;

public class UpdateCartAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    
    /**
     * TODO(24.10.03): 요청을 보내는 사람과 요청 대상의 고객 외래키와 같은지 검증.
     */
    
    String id = request.getParameter("id");
    String qty = request.getParameter("qty");
    
    CartDTO dto = new CartDTO();
    
    dto.setCartId(Integer.parseInt(id));
    dto.setCartProductCount(Integer.parseInt(qty));
    
    CartDAO dao = CartDAO.getInstance();
    
    dao.update(dto);
    
    return null;
  }

}
