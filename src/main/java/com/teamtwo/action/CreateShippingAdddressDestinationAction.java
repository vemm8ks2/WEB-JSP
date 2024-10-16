package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.teamtwo.model.CustomerDTO;
import com.teamtwo.model.ShippingAddressDAO;
import com.teamtwo.model.ShippingAddressDTO;

public class CreateShippingAdddressDestinationAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    HttpSession session = request.getSession();
    CustomerDTO customer = (CustomerDTO) session.getAttribute("customer"); // 세션에서 값 받아옴

    String newShippingAddressDestination = request.getParameter("new-shipping-address-destination");

    ShippingAddressDAO dao = ShippingAddressDAO.getInstance();

    Integer newId = dao.getNewId();

    ShippingAddressDTO dto = new ShippingAddressDTO();

    dto.setShippingAddressId(newId);
    dto.setShippingAddressDestination(newShippingAddressDestination);
    dto.setShippingAddressCustomerFk(customer.getCustomerId());

    dao.save(dto);

    ActionForward forward = new ActionForward();

    forward.setRedirect(true);
    forward.setPath("personalAddressListView.do");

    return forward;
  }

}
