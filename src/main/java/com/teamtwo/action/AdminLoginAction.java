package com.teamtwo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teamtwo.model.AdminDAO;
import com.teamtwo.model.AdminDTO;

public class AdminLoginAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    String loginId = request.getParameter("login_id").trim();
    String loginPwd = request.getParameter("login_pwd").trim();

    AdminDAO dao = AdminDAO.getInstance();
    AdminDTO dto = dao.getAdminByLoginId(loginId);
    
    /**
     * TODO(24.09.12): 어드민 아이디가 없을 경우 에러 핸들링
     */
   
    boolean isValid = dto != null && dto.getAdminPassword().equals(loginPwd);
    System.out.println(isValid);

    ActionForward forward = new ActionForward();
    
    /**
     * TODO(24.09.12): 아이디 혹은 비밀번호가 잘못되었다고 표시하기.
     */
    if (!isValid) {
      request.setAttribute("isValid", isValid);
      
      forward.setPath("adminLogin.do");
      forward.setRedirect(false);
      
      return forward;
    }

    HttpSession session = request.getSession();
    session.setAttribute("admin", dto);

    forward.setPath("view/admin.jsp");
    forward.setRedirect(false);

    return forward;
  }

}
