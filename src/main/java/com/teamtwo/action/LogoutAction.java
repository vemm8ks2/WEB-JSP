package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 로그아웃 Action 입니다.
 * 
 * @author skwns0472
 */
public class LogoutAction implements Action {
  /**
   * Q(24.09.03): 유저와 어드민 로그아웃을 같은 액션으로 혼용해도 되는가? 고민해보기.
   */

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    HttpSession session = request.getSession();
    
    session.invalidate();
    
    ActionForward forward = new ActionForward();
    
    forward.setRedirect(false);
    forward.setPath("mainView.do");
    
    return forward;
  }

}
