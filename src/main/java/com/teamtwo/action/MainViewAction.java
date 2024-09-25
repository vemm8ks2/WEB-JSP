package com.teamtwo.action;

import java.io.IOException;
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
		
		request.setAttribute("url", "main.jsp");
		request.setAttribute("stylesheet", "main.css");
		request.setAttribute("javascript", "main.js");
		request.setAttribute("productList", list);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		
		forward.setPath("view/layout.jsp");

		
		return forward;
	}

}
