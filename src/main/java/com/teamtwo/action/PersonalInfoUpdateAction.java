package com.teamtwo.action;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.teamtwo.model.CustomerDAO;
import com.teamtwo.model.CustomerDTO;

public class PersonalInfoUpdateAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    HttpSession session = request.getSession();
    CustomerDTO customer = (CustomerDTO) session.getAttribute("customer"); // 세션에서 값 받아옴
    
    String name = request.getParameter("customer_name");
    String email = request.getParameter("customer_email");
    String phoneNumber = request.getParameter("customer_phone_number");
    String gender = request.getParameter("customer_gender");
    String birth = request.getParameter("customer_birth");

    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String now = currentDateTime.format(formatter);
    
    CustomerDTO dto = new CustomerDTO();
    
    dto.setCustomerId(customer.getCustomerId());
    dto.setCustomerName(name);
    dto.setCustomerEmail(email);
    dto.setCustomerPhoneNumber(phoneNumber);
    dto.setCustomerGender(gender);
    dto.setCustomerBirth(birth);
    dto.setCustomerUpdatedAt(now);
    
    CustomerDAO dao = CustomerDAO.getInstance();
    dao.update(dto);
    
    customer.setCustomerName(name);
    customer.setCustomerEmail(email);
    customer.setCustomerPhoneNumber(phoneNumber);
    customer.setCustomerGender(gender);
    customer.setCustomerBirth(birth);
    customer.setCustomerUpdatedAt(now);

    ActionForward forward = new ActionForward();
    
    forward.setRedirect(true);
    forward.setPath("personalInfoView.do");
    
    return forward;
  }

}
