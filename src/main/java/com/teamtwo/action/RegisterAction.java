package com.teamtwo.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.CustomerDAO;
import com.teamtwo.model.CustomerDTO;

public class RegisterAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    
      String customer_loginid = request.getParameter("customer_loginid");
      String customer_pwd = request.getParameter("customer_pwd");
      String customer_name = request.getParameter("customer_name");
      String customer_phone = request.getParameter("customer_phone");
    
      CustomerDTO dto = new CustomerDTO();
      
      dto.setCustomerLoginId(customer_loginid);
      dto.setCustomerPassword(customer_pwd);
      dto.setCustomerName(customer_name);
      dto.setCustomerPhoneNumber(customer_phone);
  
      CustomerDAO dao = CustomerDAO.getInstance();
      
      dao.save(dto);
      
     ActionForward forward = new ActionForward();
     
     forward.setPath("");
      
    return forward;
  }

}
