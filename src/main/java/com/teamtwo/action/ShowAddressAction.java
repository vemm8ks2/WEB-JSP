package com.teamtwo.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamtwo.model.ShippingAddressDAO;
import com.teamtwo.model.ShippingAddressDTO;

public class ShowAddressAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
	    
	     int shippingAddressCustomerIdFk = Integer.parseInt(request.getParameter("shippingAddressCustomerIdFk").trim());
	     ShippingAddressDAO dao = ShippingAddressDAO.getInstance();
	     List<ShippingAddressDTO> list = dao.getcustomeraddr(shippingAddressCustomerIdFk);
	     request.setAttribute("/shippingAddrList",list);
	     
	     ActionForward forward = new ActionForward();
		 forward.setRedirect(false);
	     forward.setPath("view/shippingaddr_list.jsp");
	     return forward;
		
	}

}
