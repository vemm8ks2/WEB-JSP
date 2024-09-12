package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.ShippingAddressDAO;
import com.teamtwo.model.ShippingAddressDTO;

/**
 * 유저의 주소를 업데이트해주는 Action
 * @author hsheeh
 */
public class ModifyAddressAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    String shippingaddressIsdefault = request.getParameter("shippingaddressIsdefault").trim();
    int shippingaddressid = Integer.parseInt("shippingaddressid".trim());
    
    ShippingAddressDTO dto = new ShippingAddressDTO();
    
    dto.setShippingAddressIsDefault(shippingaddressIsdefault);
    dto.setShippingAddressId(shippingaddressid);

    ShippingAddressDAO dao = ShippingAddressDAO.getInstance();
    
    dao.update(dto);

    return null;
  }

}
