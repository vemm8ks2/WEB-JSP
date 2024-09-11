package com.teamtwo.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamtwo.model.CustomerDAO;
import com.teamtwo.model.CustomerDTO;
import com.teamtwo.model.ShippingAddressDAO;
import com.teamtwo.model.ShippingAddressDTO;

public class CustomerViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		int customer_Id = Integer.parseInt(request.getParameter("id").trim());
		
		CustomerDAO dao = CustomerDAO.getInstance();
		
		ShippingAddressDAO shipping = ShippingAddressDAO.getInstance();

		
		CustomerDTO page = dao.get(customer_Id);
		
		List<ShippingAddressDTO> list = shipping.customerAddress(customer_Id);		
		
		ShippingAddressDTO address = null;
		
		for(ShippingAddressDTO dto : list) {
			if(dto.getShippingAddressIsDefault().equals("Y")) {
				address = dto;
			}
		}
		
		request.setAttribute("customer", page);
		request.setAttribute("address", address);
		request.setAttribute("url", "customer.jsp");
        request.setAttribute("stylesheet", "customer.css");
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(false);
		forward.setPath("view/layout.jsp");
		
		return forward;
	}

}
