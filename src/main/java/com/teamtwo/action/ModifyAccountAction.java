package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.CustomerDAO;
import com.teamtwo.model.CustomerDTO;

public class ModifyAccountAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

	int customer_id = Integer.parseInt(request.getParameter("customer_id").trim());
    String customer_password = request.getParameter("customer_password").trim();
    String customer_name = request.getParameter("customer_name").trim();
    String customer_email = request.getParameter("customer_email").trim();
    String customer_phone_number = request.getParameter("customer_phone_number").trim();
    String customer_birth = request.getParameter("customer_birth").trim();

    CustomerDTO dto = new CustomerDTO();

    dto.setCustomerId(customer_id);
    dto.setCustomerPassword(customer_password);
    dto.setCustomerName(customer_name);
    dto.setCustomerEmail(customer_email);
    dto.setCustomerPhoneNumber(customer_phone_number);
    dto.setCustomerBirth(customer_birth);

    CustomerDAO dao = CustomerDAO.getInstance();

    dao.update(dto);

    return null;
  }

}
