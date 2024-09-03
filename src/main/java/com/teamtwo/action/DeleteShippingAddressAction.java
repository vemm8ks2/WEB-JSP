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

    ShippingAddressDAO dao = ShippingAddressDAO.getInstance();

    /**
     * TODO(24.09.03): 에러 핸들링
     */
    dao.delete(shippingAddressId);

    ActionForward forward = new ActionForward();

    forward.setRedirect(false);
    forward.setPath("");

    return forward;
  }

}
