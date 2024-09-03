package com.teamtwo.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.teamtwo.model.UserDAO;
import com.teamtwo.model.UserDTO;

public class LoginAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    String customer_login_id = request.getParameter("customer_login_id").trim();

    String customer_password = request.getParameter("customer_password").trim();

    UserDAO dao = UserDAO.getInstance();

    // 회원인지 여부 확인
    int check = dao.userCheck(customer_login_id, customer_password);

    PrintWriter out = response.getWriter();

    ActionForward forward = new ActionForward();

    if (check > 0) {

      UserDTO cont = dao.getMember(customer_login_id);
      
      HttpSession session = request.getSession();

      session.setAttribute("customer_login_id", cont.getUserId());

      session.setAttribute("customer_password", cont.getUserName());

      forward.setRedirect(true);

      forward.setPath("user_main.do");

    } else if (check == -1) {

      out.println("<script>");
      out.println("alert('사용자 비밀번호가 틀립니다. 확인해 주세요.')");
      out.println("history.back()");
      out.println("</script>");
    } else {

      out.println("<script>");
      out.println("alert('회원이 아닙니다. 아이디를 확인해 주세요.')");
      out.println("history.back()");
      out.println("</script>");
    }

    return forward;
  }

}
