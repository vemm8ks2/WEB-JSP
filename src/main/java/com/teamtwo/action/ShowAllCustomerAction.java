package com.teamtwo.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.UserDAO;
import com.teamtwo.model.UserDTO;

public class ShowAllCustomerAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    
    UserDAO dao = UserDAO.getInstance();
    
    List<UserDTO> list = dao.getAll();
        
    request.setAttribute("userList", list);
    
    ActionForward forward = new ActionForward();
    
    forward.setRedirect(false);
    
    forward.setPath("view/user_list.jsp");
    
    return forward;
    
  }

}
