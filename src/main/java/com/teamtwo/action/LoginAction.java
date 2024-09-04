package com.teamtwo.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teamtwo.model.UserDAO;
import com.teamtwo.model.UserDTO;

/**
 * 유저의 로그인 Action 입니다.
 * 
 * @author bborib
 */
public class LoginAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    ActionForward forward = new ActionForward();

    String customerLoginId = request.getParameter("login_id").trim();
    String customerPassword = request.getParameter("login_pwd").trim();

    UserDAO dao = UserDAO.getInstance();

    UserDTO customer = dao.getCustomerByLoginId(customerLoginId);

    if (customer == null) {
      /**
       * TODO(24.09.03): 유저 로그인 아이디가 없는 경우 에러 핸들링
       */
      return null;
    }

    if (!isCorrectPassword(customerPassword, customer.getUserPassword())) {
      /**
       * TODO(24.09.03): 로그인 유저의 패스워드가 틀린 경우
       */
      return null;
    }

    HttpSession session = request.getSession();

    session.setAttribute("customer", customer);

    forward.setPath("mainView.do");
    forward.setRedirect(false);

    return forward;
  }

  public boolean isCorrectPassword(String customerPwd, String targetPwd) {
    return customerPwd.equals(targetPwd);
  }

}
