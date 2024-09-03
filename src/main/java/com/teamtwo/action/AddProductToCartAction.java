package com.teamtwo.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamtwo.model.CartDAO;
import com.teamtwo.model.CartDTO;

/**
 * 장바구니에 상품을 추가하는 Action 입니다.
 * 
 * @author skwns0472
 */
public class AddProductToCartAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    int cart_product_count = Integer.parseInt(request.getParameter("cart_product_count").trim());
    /**
     * Q(24.09.03): 유저 외래키는 세션에서 가져올 수 있음을 고려해보자.
     */
    int cart_customer_fk = Integer.parseInt(request.getParameter("cart_customer_fk").trim());
    int cart_product_fk = Integer.parseInt(request.getParameter("cart_product_fk").trim());

    CartDAO dao = CartDAO.getInstance();

    CartDTO dto = new CartDTO();

    dto.setCartId(dao.getCartId());
    dto.setCartProductCount(cart_product_count);
    dto.setCartCustomerFk(cart_customer_fk);
    dto.setCartProductFk(cart_product_fk);

    dao.save(dto);

    PrintWriter out = response.getWriter();
    out.print("장바구니 상품 추가 성공");

    return null;
  }

}
