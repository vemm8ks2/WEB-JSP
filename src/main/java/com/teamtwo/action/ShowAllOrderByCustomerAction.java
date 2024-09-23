package com.teamtwo.action;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.teamtwo.model.OrderDAO;
import com.teamtwo.model.OrderDTO;

/**
 * 고객 별 모든 주문 목록을 가져오는 Action 입니다.<br>
 * 어드민의 유저 별 주문 목록 보기
 * 
 * @author skwns0472
 */
public class ShowAllOrderByCustomerAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {
    /**
     * TODO(24.09.23): 어드민에서만 사용할 액션이기 때문에 어드민 인증 과정이 필요합니다.
     */
    
    int customerId = Integer.parseInt(request.getParameter("customer_id").trim());
    
    OrderDAO dao = OrderDAO.getInstance();
    
    List<OrderDTO> orderList = dao.getOrderListByCustomerId(customerId);
    
    request.setAttribute("orderList", orderList);
    
    ActionForward forward = new ActionForward();
    
    forward.setRedirect(false);
    forward.setPath("");
    
    return forward;
  }

}
