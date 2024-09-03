package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.ShippingAddressDAO;
import com.teamtwo.model.ShippingAddressDTO;

/**
 * 유저의 배송지를 수정하는 Action 입니다. 
 * @author hsheeh
 */
public class ModifyShippingAdddress implements Action {
  /**
   * TODO(24.09.03): ModifyAddressAction과 혼동되니 보완이 필요합니다.
   */
  
  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    /**
     * Q(24.09.03): shippingAddressUserFk를 파라미터로 받을 수 있을 지 고민을 해보아야 합니다.
     * 만약 파라미터로 받지 않기로 하였다면 유저 외래키를 가져올 다른 방법을 찾아보아야 합니다.
     */
    String shippingAddressAddress = request.getParameter("shippingAddressAddress").trim();;
    String shippingAddressIsDefault = request.getParameter("shippingAddressIsDefault").trim();;
    int shippingAddressId = Integer.parseInt(request.getParameter("shippingAddressId").trim());
    int shippingAddressUserIdFk = Integer.parseInt(request.getParameter("shippingAddressUserIdFk").trim());

    ShippingAddressDTO dto = new ShippingAddressDTO();

    dto.setShippingAddressAddress(shippingAddressAddress);
    dto.setShippingAddressId(shippingAddressId);
    dto.setShippingAddressIsDefault(shippingAddressIsDefault);
    dto.setShippingAddressUserIdFk(shippingAddressUserIdFk);

    ShippingAddressDAO dao = ShippingAddressDAO.getInstance();
    dao.update(dto);

    return null;
  }

}
