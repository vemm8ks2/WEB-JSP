package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.ShippingAddressDAO;
import com.teamtwo.model.ShippingAddressDTO;

public class ModifyAddressAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

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
