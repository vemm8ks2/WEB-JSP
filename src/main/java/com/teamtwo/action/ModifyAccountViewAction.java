package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyAccountViewAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    request.setAttribute("url", "modifyaccount.jsp");

    ActionForward forward = new ActionForward();

    forward.setRedirect(false);
    forward.setPath("view/layout.jsp");

    return forward;
  }
}
