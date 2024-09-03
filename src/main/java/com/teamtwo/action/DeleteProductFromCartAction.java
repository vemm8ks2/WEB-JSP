package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.CartDAO;

/**
 * 유저의 장바구니에서 상품을 삭제하는 Action 입니다.
 * 
 * @author hsheeh
 */
public class DeleteProductFromCartAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    /**
     * TODO(24.09.03): 장바구니 목록의 주인과 세션의 유저가 일치하는지 검증하는 작업이 필요합니다.
     */

    int cartId = Integer.parseInt(request.getParameter("cart_id").trim());

    CartDAO dao = CartDAO.getInstance();
    /**
     * TODO(24.09.03): 에러 핸들링
     */
    dao.delete(cartId);

    ActionForward forward = new ActionForward();

    forward.setRedirect(false);
    forward.setPath("");

    return forward;
  }

}
