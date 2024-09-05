package com.teamtwo.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminController extends HttpServlet {

  private static final long serialVersionUID = 1L;
  
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    // 한글 처리 작업 진행
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");

    /**
     * TODO(24.09.05): 현재는 바로 admin 페이지로 전환을 하지만 추후 어드민 계정으로 로그인을 한 후 admin 페이지로 전환되게
     * 로직을 만들어야 한다.
     */
    request
      .getRequestDispatcher("view/admin.jsp")
      .forward(request, response);
  }
}
