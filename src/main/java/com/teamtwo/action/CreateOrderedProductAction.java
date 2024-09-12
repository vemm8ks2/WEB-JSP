package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.teamtwo.model.OrderedProductDAO;
import com.teamtwo.model.OrderedProductDTO;

/**
 * ERD 설계에 의해 생성된 OrderedProduct 테이블 생성 Action 입니다.
 * 
 * @author hsheeh
 */
public class CreateOrderedProductAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    
    /**
     * TODO(24.09.03): orderedProductId 는 파라미터로 받는 게 아니고 dao 메소드를 호출하여 생성한다.
     */
    OrderedProductDAO dao = OrderedProductDAO.getInstance();
    
    int orderedProductId = dao.getOrderedProductId();
    int orderedProductQuantity = Integer.parseInt(request.getParameter("orderedProductQunatity").trim());
    int orderedProductOrderFk = Integer.parseInt(request.getParameter("orderedProductOrderFk").trim());
    int orderedProductProductFk = Integer.parseInt(request.getParameter("orderedProductProductFk").trim());

    OrderedProductDTO dto = new OrderedProductDTO();
    
    dto.setOrderedProductId(orderedProductId);
    dto.setOrderedProductQunatity(orderedProductQuantity);
    dto.setOrderedProductOrderFk(orderedProductOrderFk);
    dto.setOrderedProductProductFk(orderedProductProductFk);
    
   
    
    dao.save(dto);
    
    return null;
  }

}
