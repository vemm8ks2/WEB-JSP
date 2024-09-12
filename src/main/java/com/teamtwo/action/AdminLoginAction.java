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
		
		ActionForward forward = new ActionForward();
		
		String id = request.getParameter("login_id").trim();
		
		AdminDAO dao = AdminDAO.getInstance();
		
		AdminDTO admin = dao.getAdminByLoginId(id);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("admins", admin);
		
		forward.setPath("view/admin.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
