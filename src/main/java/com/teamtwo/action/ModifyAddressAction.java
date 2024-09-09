package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.CustomerDAO;
import com.teamtwo.model.CustomerDTO;

/**
 * 유저의 주소를 업데이트해주는 Action
 * @author hsheeh
 */
public class ModifyAddressAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    /**
     * TODO(24.09.03): 유저의 주소만 수정하는 액션이기 때문에 받을 파라미터를 간소화해주어야 한다. 
     */
    String customerPassword = request.getParameter("customerPassword").trim();
    String customerName = request.getParameter("customerName").trim();
    String customerEmail = request.getParameter("customerEmail").trim();
    String customerPhoneNumber = request.getParameter("customerPhoneNumber").trim();
    String customerBirth = request.getParameter("customerBirth").trim();

    CustomerDTO dto = new CustomerDTO();

    dto.setCustomerPassword(customerPassword);
    dto.setCustomerName(customerName);
    dto.setCustomerEmail(customerEmail);
    dto.setCustomerPhoneNumber(customerPhoneNumber);
    dto.setCustomerBirth(customerBirth);

    /**
     * TODO(24.09.03): session 객체의 유저 정보를 가져와서 dto에 전부 담아서 기존의 update 메소드를 사용할지
     * 아니면 유저의 주소만 업데이트하는 새로운 메소드를 만들지 결정해야한다.
     */
    CustomerDAO dao = CustomerDAO.getInstance();
    dao.update(dto);

    return null;
  }

}
