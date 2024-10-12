package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.ShippingAddressDAO;

/**
 * 배송지를 삭제하는 액션입니다.
 * 
 * @author hsheeh
 */
public class DeleteShippingAddressAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    int shippingAddressId = Integer.parseInt(request.getParameter("shippingAddressId").trim());
    
    /**
     * TODO(24.10.12): 로그인 되어있는 고객과 해당 배송지 데이터의 고객 외래키가 같은지 검증해야합니다.
     */

    ShippingAddressDAO dao = ShippingAddressDAO.getInstance();
    dao.delete(shippingAddressId);

    ActionForward forward = new ActionForward();

    forward.setRedirect(true);
    forward.setPath("personalAddressListView.do");

    return forward;
  }

}
