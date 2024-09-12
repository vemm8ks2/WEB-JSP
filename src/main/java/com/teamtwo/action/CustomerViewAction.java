package com.teamtwo.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.teamtwo.model.CustomerDTO;
import com.teamtwo.model.ShippingAddressDAO;
import com.teamtwo.model.ShippingAddressDTO;

/**
 * 유저의 개인 페이지를 보여주는 액션입니다.
 * 
 * @author skwns0472
 */
public class CustomerViewAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    HttpSession session = request.getSession();
    CustomerDTO customer = (CustomerDTO) session.getAttribute("customer"); // 세션에서 값 받아옴

    ShippingAddressDAO shippingAddressDao = ShippingAddressDAO.getInstance();

    List<ShippingAddressDTO> shippingAddressList =
        shippingAddressDao.getShippingAddressByCustomer(customer.getCustomerId());

    ShippingAddressDTO defaultAddress = null;

    for (ShippingAddressDTO shippingAddress : shippingAddressList) {
      boolean isDefaultAddress = shippingAddress.getShippingAddressIsDefault().equals("Y");

      if (isDefaultAddress) {
        defaultAddress = shippingAddress;
        break;
      }
    }

    request.setAttribute("customer", customer);
    request.setAttribute("defaultAddress", defaultAddress);
    request.setAttribute("url", "customer.jsp");
    request.setAttribute("stylesheet", "customer.css");

    ActionForward forward = new ActionForward();

    forward.setRedirect(false);
    forward.setPath("view/layout.jsp");

    return forward;
  }

}
