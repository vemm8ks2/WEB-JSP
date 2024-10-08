package com.teamtwo.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teamtwo.model.CustomerDAO;
import com.teamtwo.model.CustomerDTO;
import com.teamtwo.model.ShippingAddressDAO;
import com.teamtwo.model.ShippingAddressDTO;

public class PersonalInfoViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession session = request.getSession();
		CustomerDTO customer = (CustomerDTO) session.getAttribute("customer"); // 세션에서 값 받아옴

		ShippingAddressDAO dao = ShippingAddressDAO.getInstance();
		List<ShippingAddressDTO> shippingAddressList = dao.getShippingAddressByCustomer(customer.getCustomerId());

		request.setAttribute("customer", customer);
		request.setAttribute("shippingAddressList", shippingAddressList);
		request.setAttribute("url", "personalInfo.jsp");
		request.setAttribute("stylesheet", "");

		ActionForward forward = new ActionForward();

		forward.setRedirect(false);
		forward.setPath("view/layout.jsp");

		return forward;
	}

}
