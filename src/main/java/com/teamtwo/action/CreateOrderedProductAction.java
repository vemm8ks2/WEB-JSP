package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.OrderedProductDAO;
import com.teamtwo.model.OrderedProductDTO;

public class CreateOrderedProductAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    
    int orderedProductId = Integer.parseInt(request.getParameter("orderedProductId").trim());
    int orderedProductQunatity = Integer.parseInt(request.getParameter("orderedProductQunatity").trim());
    int orderedProductUserIdFk = Integer.parseInt(request.getParameter("orderedProductUserIdFk").trim());
    int orderedProductProdIdFk = Integer.parseInt(request.getParameter("orderedProductProdIdFk").trim());

    OrderedProductDAO dao = OrderedProductDAO.getInstance();
    OrderedProductDTO dto = new OrderedProductDTO();
    
    dto.setOrderedProductId(orderedProductId);
    dto.setOrderedProductProdIdFk(orderedProductProdIdFk);
    dto.setOrderedProductQunatity(orderedProductQunatity);
    dto.setOrderedProductUserIdFk(orderedProductUserIdFk);
    
    dao.save(dto);
    
    
    return null;
  }

}
