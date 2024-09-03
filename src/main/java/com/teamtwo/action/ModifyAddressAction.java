package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.ShippingAddressDAO;
import com.teamtwo.model.ShippingAddressDTO;
import com.teamtwo.model.UserDAO;
import com.teamtwo.model.UserDTO;

public class ModifyAddressAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    String userPassword = request.getParameter("userPassword").trim();
    String userName = request.getParameter("userName").trim();
    String userEmail = request.getParameter("userEmail").trim();
    String userPhoneNumber = request.getParameter("userPhoneNumber").trim();
    String userBirth = request.getParameter("userBirth").trim();

    UserDTO dto = new UserDTO();

    dto.setUserPassword(userPassword);
    dto.setUserName(userName);
    dto.setUserEmail(userEmail);
    dto.setUserPhoneNumber(userPhoneNumber);
    dto.setUserBirth(userBirth);

    UserDAO dao = UserDAO.getInstance();
    dao.update(dto);

    return null;
  }

}
