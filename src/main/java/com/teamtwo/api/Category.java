package com.teamtwo.api;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import com.teamtwo.model.CategoryDAO;

@WebServlet("/category")
public class Category extends HttpServlet {
  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    CategoryDAO dao = CategoryDAO.getInstance();
    
    JSONObject json = new JSONObject();
    json.put("categoryList", dao.getAll());
    
    response.setContentType("application/json; charset=utf-8");
    response.getWriter().print(json);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {}

  protected void doPut(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {}

  protected void doDelete(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {}

}
