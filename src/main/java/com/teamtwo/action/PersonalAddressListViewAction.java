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
 * 특정 유저의 배송지 목록을 보여주는 Action 입니다.
 * 
 * @author hsheeh
 */
public class PersonalAddressListViewAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    
    HttpSession session = request.getSession();
    CustomerDTO customer = (CustomerDTO) session.getAttribute("customer"); // 세션에서 값 받아옴

    ShippingAddressDAO dao = ShippingAddressDAO.getInstance();

    List<ShippingAddressDTO> list = dao.getShippingAddressByCustomer(customer.getCustomerId());

    request.setAttribute("addressList", list);
    request.setAttribute("url", "customerAddressList.jsp");

    ActionForward forward = new ActionForward();

    forward.setRedirect(false);
    forward.setPath("view/layout.jsp");

    return forward;

  }

}
