package com.teamtwo.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamtwo.model.ShippingAddressDAO;
import com.teamtwo.model.ShippingAddressDTO;

/**
 * 특정 유저의 배송지 목록을 보여주는 Action 입니다.
 * 
 * @author hsheeh
 */
public class ShowPersonalAddressListAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    int shippingAddressCustomerFk =
        Integer.parseInt(request.getParameter("shipping_address_customer_fk").trim());

    ShippingAddressDAO dao = ShippingAddressDAO.getInstance();

    List<ShippingAddressDTO> list = dao.getShippingAddressByCustomer(shippingAddressCustomerFk);

    request.setAttribute("addressList", list);

    ActionForward forward = new ActionForward();

    forward.setRedirect(false);
    forward.setPath("view/customerAddressList.jsp");

    return forward;

  }

}
