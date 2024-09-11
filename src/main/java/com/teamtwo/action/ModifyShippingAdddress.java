package com.teamtwo.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamtwo.model.ShippingAddressDAO;
import com.teamtwo.model.ShippingAddressDTO;

/**
 * 유저의 배송지를 수정하는 Action 입니다.
 * 
 * @author hsheeh
 */
public class ModifyShippingAdddress implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		int shippingAddressId = Integer.parseInt(request.getParameter("shippingAddressId").trim());
		ShippingAddressDTO dto = new ShippingAddressDTO();
		ShippingAddressDAO dao = ShippingAddressDAO.getInstance();
		dto = dao.get(shippingAddressId);
		
		/**
		 * 
		 */
		
	    return null;
	}

}
