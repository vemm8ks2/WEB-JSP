package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.UserDAO;

public class WithdrawAccountAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    int userId = Integer.parseInt(request.getParameter("userId").trim());
    UserDAO dao = UserDAO.getInstance();
    dao.delete(userId);
    
    return null;
  }

}
