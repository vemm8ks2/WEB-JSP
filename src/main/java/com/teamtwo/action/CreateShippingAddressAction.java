package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.ShippingAddressDAO;
import com.teamtwo.model.ShippingAddressDTO;

public class CreateShippingAddressAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    
    String shippingAddressAddress = request.getParameter("shippingAddressAddress").trim();
    String shippingAddressIsDefault = request.getParameter("shippingAddressIsDefault").trim();
    int getShippingAddressUserIdFk = Integer.parseInt(request.getParameter("getShippingAddressUserIdFk").trim());

    ShippingAddressDAO dao = ShippingAddressDAO.getInstance();
    ShippingAddressDTO dto = new ShippingAddressDTO();
    
    dto.setShippingAddressAddress(shippingAddressAddress);
    dto.setShippingAddressIsDefault(shippingAddressIsDefault);
    dto.setShippingAddressUserIdFk(getShippingAddressUserIdFk);
    
    dao.save(dto);
    
    return null;
  }

}
