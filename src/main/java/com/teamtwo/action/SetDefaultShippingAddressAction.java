package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.ShippingAddressDAO;

/**
 * 고객의 기본 배송지를 설정하는 Action 입니다.
 * 
 * @author joohp
 */
public class SetDefaultShippingAddressAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    int shippingAddressId = Integer.parseInt(request.getParameter("shipping_address_id").trim());

    ShippingAddressDAO dao = ShippingAddressDAO.getInstance();

    /**
     * TODO(24.09.05): 배송지를 새롭게 'Y'로 업데이트 해줄 뿐만 아니라 기존에 있던 기본 배송지도 'N'으로 업데이트해야 한다.
     */
    dao.updateDefault(shippingAddressId);

    ActionForward forword = new ActionForward();

    forword.setRedirect(false);
    forword.setPath("");

    return forword;
  }

}
