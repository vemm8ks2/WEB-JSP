package com.teamtwo.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.teamtwo.model.CartDAO;
import com.teamtwo.model.CartDTO;
import com.teamtwo.model.CustomerDTO;
import com.teamtwo.model.ProductDAO;
import com.teamtwo.model.ProductDTO;

public class InsertProductToCartAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		int productid = Integer.parseInt(request.getParameter("id").trim());
		int productcount = Integer.parseInt(request.getParameter("count").trim());
		
		HttpSession session = request.getSession();
	    CustomerDTO customer = (CustomerDTO) session.getAttribute("customer");
	    	    
	    ActionForward forward = new ActionForward();
	    
	    forward.setRedirect(false);
	    forward.setPath("view/layout.jsp");

	    if (customer == null) {
	      request.setAttribute("url", "login.jsp");
	      request.setAttribute("stylesheet", "login.css");
	      return forward;
	    }
	    
	    ProductDAO productdao = ProductDAO.getInstance();
	    ProductDTO productdto = productdao.get(productid);
	    
	    CartDAO cartdao = CartDAO.getInstance();
	    
	    CartDTO cartdto = new CartDTO();
	    cartdto.setCartId(cartdao.getCartId());
	    cartdto.setCartProductFk(productdto.getProductId());
	    cartdto.setCartProductCount(productcount);
	    cartdto.setCartCustomerFk(customer.getCustomerId());
	    
	    cartdao.save(cartdto);

	    request.setAttribute("url", "cart.jsp");
	    request.setAttribute("stylesheet", "");
	    
		return forward;
	}

}
