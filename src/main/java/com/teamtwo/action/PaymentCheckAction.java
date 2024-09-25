package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import com.teamtwo.model.OrderDAO;
import com.teamtwo.model.OrderDTO;
import com.teamtwo.model.PaymentResponseDTO;

public class PaymentCheckAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    String orderId = request.getParameter("merchant_uid");
    PaymentResponseDTO payment = (PaymentResponseDTO) request.getAttribute("payment");
    
    OrderDAO dao = OrderDAO.getInstance();
    OrderDTO dto = dao.get(Integer.parseInt(orderId));
    
    JSONObject responseJson = new JSONObject();
    
    /* TODO(24.09.25): 추후 주문 테이블에 총 결제 금액 칼럼이 추가될 것 같음.
     * if (dto.getAmount() == payment.getAmount()) { responseJson.put("complete", true); } else {
     * responseJson.put("complete", false); }
     */
    
    responseJson.put("complete", true);

    response.setContentType("application/json; charset=utf-8");
    response.getWriter().print(responseJson);
    
    return null;
  }

}
