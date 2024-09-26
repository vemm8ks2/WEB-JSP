package com.teamtwo.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.ProductDAO;
import com.teamtwo.model.ProductDTO;

public class MainViewAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    ProductDAO dao = ProductDAO.getInstance();
    List<ProductDTO> list = dao.getAll();
    
    List<ProductDTO> mostAddedToCart = new ArrayList<>(list);
    List<ProductDTO> realTimePopularity = new ArrayList<>(list);
    List<ProductDTO> bestSeller = new ArrayList<>(list);
    List<ProductDTO> mostViews = new ArrayList<>(list);
    
    Collections.shuffle(mostAddedToCart);
    Collections.shuffle(realTimePopularity);
    Collections.shuffle(bestSeller);
    Collections.shuffle(mostViews);

    request.setAttribute("mostAddedToCart", mostAddedToCart.subList(0, 20));
    request.setAttribute("realTimePopularity", realTimePopularity.subList(0, 20));
    request.setAttribute("bestSeller", bestSeller.subList(0, 20));
    request.setAttribute("mostViews", mostViews.subList(0, 20));
    
    request.setAttribute("url", "main.jsp");
    request.setAttribute("stylesheet", "main.css");
    request.setAttribute("javascript", "main.js");

    ActionForward forward = new ActionForward();

    forward.setRedirect(false);
    forward.setPath("view/layout.jsp");

    return forward;
  }

}
