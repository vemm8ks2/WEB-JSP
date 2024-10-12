package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.teamtwo.model.CustomerDTO;
import com.teamtwo.model.ShippingAddressDAO;
import com.teamtwo.model.ShippingAddressDTO;

/**
 * 유저의 배송지를 생성하는 Action 입니다.
 * 
 * @author hsheeh
 */
public class CreateShippingAddressAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    HttpSession session = request.getSession();
    CustomerDTO customer = (CustomerDTO) session.getAttribute("customer"); // 세션에서 값 받아옴
    
    String shippingAddressAddress = request.getParameter("shippingAddressAddress").trim();
    String shippingAddressIsDefault = request.getParameter("shippingAddressIsDefault").trim();

    ShippingAddressDAO dao = ShippingAddressDAO.getInstance();
    Integer shippingAddressId = dao.getNewId();
    
    ShippingAddressDTO dto = new ShippingAddressDTO();
    
    dto.setShippingAddressId(shippingAddressId);
    dto.setShippingAddressDestination(shippingAddressAddress);
    dto.setShippingAddressCustomerFk(customer.getCustomerId());

    dao.save(dto);
    
    if (shippingAddressIsDefault.equals("Y")) { // 만약 고객이 새로 생성하는 배송지를 기본 배송지로 설정한다면
      dao.unsetDefault(customer.getCustomerId());
      dao.setDefault(shippingAddressId);
    }
    
    ActionForward forward = new ActionForward();
    
    forward.setRedirect(true);
    forward.setPath("personalAddressListView.do");
    
    return forward;
  }

}
