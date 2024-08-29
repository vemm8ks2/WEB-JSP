package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.UserDAO;
import com.teamtwo.model.UserDTO;

public class ModifyAccountAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    String customer_password = request.getParameter("customer_password").trim();
    String customer_name = request.getParameter("customer_name").trim();
    String customer_email = request.getParameter("customer_email").trim();
    String customer_phone_number = request.getParameter("customer_phone_number").trim();
    String customer_birth = request.getParameter("customer_birth").trim();

    UserDTO dto = new UserDTO();

    dto.setUserPassword(customer_password);
    dto.setUserName(customer_name);
    dto.setUserEmail(customer_email);
    dto.setUserPhoneNumber(customer_phone_number);
    dto.setUserBirth(customer_birth);

    UserDAO dao = UserDAO.getInstance();

    dao.update(dto);

    return null;
  }

}
