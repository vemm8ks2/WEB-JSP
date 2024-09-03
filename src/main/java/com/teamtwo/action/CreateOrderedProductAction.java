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
    int orderedProductId = Integer.parseInt(request.getParameter("orderedProductId").trim());
    int orderedProductQunatity = Integer.parseInt(request.getParameter("orderedProductQunatity").trim());
    int orderedProductUserIdFk = Integer.parseInt(request.getParameter("orderedProductUserIdFk").trim());
    int orderedProductProdIdFk = Integer.parseInt(request.getParameter("orderedProductProdIdFk").trim());

    OrderedProductDTO dto = new OrderedProductDTO();
    
    dto.setOrderedProductId(orderedProductId);
    dto.setOrderedProductProdIdFk(orderedProductProdIdFk);
    dto.setOrderedProductQunatity(orderedProductQunatity);
    dto.setOrderedProductUserIdFk(orderedProductUserIdFk);
    
    OrderedProductDAO dao = OrderedProductDAO.getInstance();
    
    dao.save(dto);
    
    return null;
  }

}
