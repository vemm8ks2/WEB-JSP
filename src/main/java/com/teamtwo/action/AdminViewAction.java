package com.teamtwo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("view/admin.jsp");
		
		return forward;
	}

}
