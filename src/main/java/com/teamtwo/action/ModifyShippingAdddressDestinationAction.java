package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.ShippingAddressDAO;
import com.teamtwo.model.ShippingAddressDTO;

public class ModifyShippingAdddressDestinationAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    int shippingAddressId = Integer.parseInt(request.getParameter("shipping-address-id").trim());
    String modifiedShippingAddressDestination =
        request.getParameter("modified-shipping-address-destination").trim();

    ShippingAddressDTO dto = new ShippingAddressDTO();

    dto.setShippingAddressId(shippingAddressId);
    dto.setShippingAddressDestination(modifiedShippingAddressDestination);

    ShippingAddressDAO dao = ShippingAddressDAO.getInstance();
    dao.modifyShippingAddressDestination(dto);

    ActionForward forward = new ActionForward();

    forward.setRedirect(true);
    forward.setPath("personalAddressListView.do");

    return forward;
  }

}
