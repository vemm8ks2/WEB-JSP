package com.teamtwo.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.UserDAO;
import com.teamtwo.model.UserDTO;

public class ReigsterAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    
      String user_loginid = request.getParameter("user_loginid");
      String user_pwd = request.getParameter("user_pwd");
      String user_name = request.getParameter("user_name");
      String user_phone = request.getParameter("user_phone");
    
      UserDTO dto = new UserDTO();
      
      dto.setUserLoginId(user_loginid);
      dto.setUserPassword(user_pwd);
      dto.setUserName(user_name);
      dto.setUserPhoneNumber(user_phone);
  
      UserDAO dao = UserDAO.getInstance();
      
      dao.save(dto);
      
     ActionForward forward = new ActionForward();
     
     forward.setPath("");
      
    return forward;
  }

}
