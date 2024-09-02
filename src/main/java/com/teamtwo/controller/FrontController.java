package com.teamtwo.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamtwo.action.Action;
import com.teamtwo.action.ActionForward;
import com.teamtwo.model.CategoryDAO;

public class FrontController extends HttpServlet {

  private static final long serialVersionUID = 1L;

  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 한글 처리 작업 진행
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html; charset=UTF-8");

    /*
     * 24.09.02 TODO: 아래의 ctx를 제어하여 카테고리 데이터를 받아오고 전역적으로 관리하기.
     */
    ServletContext ctx = getServletContext();

    if (ctx.getAttribute("categoryList") == null) {
      CategoryDAO dao = CategoryDAO.getInstance();
      ctx.setAttribute("categoryList", dao.getAll());
    }

    String uri = request.getRequestURI(); // "/<프로젝트명>/<파일명(*.do)>"라는 문자열을 반환해주는 메서드이다.
    System.out.println(uri);

    String path = request.getContextPath();
    System.out.println(path);

    String command = uri.substring(path.length() + 1);
    System.out.println(command);

    Action action = null;

    ActionForward forward = null;

    Properties prop = new Properties();

    FileInputStream fis =
        new FileInputStream(this.getClass().getResource("").getPath() + "mapping.properties");

    prop.load(fis);

    String value = prop.getProperty(command);
    System.out.println(value);

    if (value.substring(0, 7).equals("execute")) {
      StringTokenizer st = new StringTokenizer(value, "|");

      st.nextToken();
      String actionPath = st.nextToken();

      try {
        Class<?> url = Class.forName(actionPath);

        // 동적으로 로딩된 클래스(객체)의 생성자(기본생성자)를 가져오는 메서드가 있다.
        Constructor<?> constructor = url.getConstructor();

        // 가져온 생성자를 이용하여 newInstance() 메서드를 호출하여 객체(인스턴스)를 생성하는 메서드
        action = (Action) constructor.newInstance();

        // 비즈니스 로직 메서드 호출한다. 즉, 생성된 객체의 execute()를 호출하여 실행하는 문장이다.
        forward = action.execute(request, response);
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      forward = new ActionForward();
      forward.setRedirect(false);
      forward.setPath(value);
    }

    if (forward != null) {
      if (forward.isRedirect()) { // forward.isRedirect() : true => *.do, false => *.jsp
        response.sendRedirect(forward.getPath());
      } else {
        RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
        rd.forward(request, response);
      }
    }
  }
}
