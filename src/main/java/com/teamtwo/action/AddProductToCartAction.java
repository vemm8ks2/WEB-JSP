package com.teamtwo.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.CartDAO;
import com.teamtwo.model.CartDTO;

public class AddProductToCartAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    
    int cart_product_count = Integer.parseInt(request.getParameter("cart_product_count").trim());
    
    int cart_customer_fk = Integer.parseInt(request.getParameter("cart_customer_fk").trim());
    
    int cart_product_fk = Integer.parseInt(request.getParameter("cart_product_fk").trim());
    
    CartDTO dto = new CartDTO();

    dto.setCartProductCount(cart_product_count);
    dto.setCartCustomerFk(cart_customer_fk);
    dto.setCartProductFk(cart_product_fk);
    
    CartDAO dao = CartDAO.getInstance();
    
    dao.save(dto);
    
    PrintWriter out = response.getWriter();
    
    out.print("장바구니 상품 추가 성공");
    
    return null;
  }

}
