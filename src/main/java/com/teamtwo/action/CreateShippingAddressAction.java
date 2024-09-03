package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    
    String shippingAddressAddress = request.getParameter("shippingAddressAddress").trim();
    String shippingAddressIsDefault = request.getParameter("shippingAddressIsDefault").trim();
    /**
     * Q(24.09.03): 배송지를 생성한다는 것은 유저가 로그인 된 상태를 전제로 한다. 그러므로 세션이 있기 때문에 세션의 유저 식별자를 사용해도 될 것 같다.
     */
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
