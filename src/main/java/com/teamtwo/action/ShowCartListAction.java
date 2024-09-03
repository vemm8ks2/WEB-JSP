package com.teamtwo.action;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.CartDAO;
import com.teamtwo.model.CartDTO;

/**
 * 유저의 장바구니 목록을 가져오는 Action 입니다.
 * 
 * @author bborib
 */
public class ShowCartListAction implements Action{

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    CartDAO dao = CartDAO.getInstance();
    
    List<CartDTO> list = dao.getAll();
    
    request.setAttribute("cartList", list);
    
    ActionForward forward = new ActionForward();
    
    forward.setRedirect(false);
    forward.setPath("view/cart_list.jsp");
    
    return forward;
    
  }

}
