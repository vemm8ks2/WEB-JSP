package com.teamtwo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamtwo.model.ShippingAddressDAO;
import com.teamtwo.model.ShippingAddressDTO;

/**
 * 유저의 배송지를 수정하는 Action 입니다.
 * 
 * @author hsheeh
 */
public class ModifyShippingAdddressAction implements Action {
  
  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    String shippingAddressDestination = request.getParameter("shippingAddressDestination").trim();;
    String shippingAddressIsDefault = request.getParameter("shippingAddressIsDefault").trim();;
    int shippingAddressId = Integer.parseInt(request.getParameter("shippingAddressId").trim());

    ShippingAddressDTO dto = new ShippingAddressDTO();

    dto.setShippingAddressId(shippingAddressId);
    dto.setShippingAddressDestination(shippingAddressDestination);
    dto.setShippingAddressIsDefault(shippingAddressIsDefault);

    ShippingAddressDAO dao = ShippingAddressDAO.getInstance();
    dao.update(dto);
    
    ActionForward forward = new ActionForward();
    
    forward.setRedirect(true);
    forward.setPath("personalAddressListView.do");

    return forward;
  }

}
