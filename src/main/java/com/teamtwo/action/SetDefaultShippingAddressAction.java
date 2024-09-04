package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.ShippingAddressDAO;
import com.teamtwo.model.ShippingAddressDTO;

public class SetDefaultShippingAddressAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    
    int shipping_address_id = Integer.parseInt(request.getParameter("shipping_address_id").trim());
    
    ShippingAddressDAO dao = ShippingAddressDAO.getInstance();
    
    dao.updateDefault(shipping_address_id);
    
    ActionForward forword = new ActionForward();
    
    forword.setRedirect(false);
    forword.setPath("");
    
    return forword;
  }

}
