package com.teamtwo.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.CustomerDAO;
import com.teamtwo.model.CustomerDTO;
import com.teamtwo.model.ShippingAddressDAO;
import com.teamtwo.model.ShippingAddressDTO;

public class RegisterAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    String customer_loginid = request.getParameter("register_id");
    String customer_pwd = request.getParameter("register_pwd");
    String customer_name = request.getParameter("register_name");
    String customer_phone = request.getParameter("register_phone");
    String customer_addr = request.getParameter("register_addr");


    CustomerDAO dao = CustomerDAO.getInstance();
    CustomerDTO dto = new CustomerDTO();

    Integer customerId = dao.getCustomerId();

    dto.setCustomerId(customerId);
    dto.setCustomerLoginId(customer_loginid);
    dto.setCustomerPassword(customer_pwd);
    dto.setCustomerName(customer_name);
    dto.setCustomerPhoneNumber(customer_phone);

    dao.save(dto);

    ShippingAddressDAO dao2 = ShippingAddressDAO.getInstance();
    ShippingAddressDTO dto2 = new ShippingAddressDTO();

    dto2.setShippingAddressAddress(customer_addr);
    dto2.setShippingAddressIsDefault("Y");
    dto2.setShippingAddressCustomerIdFk(customerId);

    dao2.save(dto2);
    
    ActionForward forward = new ActionForward();

    forward.setPath("mainView.do");
    forward.setRedirect(false);
    
    return forward;
  }

}
