package com.teamtwo.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import com.teamtwo.model.CustomerDTO;
import com.teamtwo.model.OrderDAO;
import com.teamtwo.model.OrderDTO;
import com.teamtwo.model.OrderedProductDAO;
import com.teamtwo.model.OrderedProductDTO;

public class PaymentProceedAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    HttpSession session = request.getSession();
    CustomerDTO customer = (CustomerDTO) session.getAttribute("customer"); // 세션에서 값 받아옴

    String paymentName = request.getParameter("payment_name");
    int paymentAmount = Integer.parseInt(request.getParameter("payment_amount"));
    String buyerName = request.getParameter("buyer_name");
    String buyerTel = request.getParameter("buyer_tel");
    String buyerAddr = request.getParameter("buyer_addr");
    String[] productIds = request.getParameterValues("product_ids");
    String[] productsQty = request.getParameterValues("products_qty");

    OrderDAO orderDao = OrderDAO.getInstance();
    OrderDTO orderDto = new OrderDTO();

    int orderId = orderDao.getOrderId();

    orderDto.setOrderId(orderId);
    orderDto.setOrderReceiverName(buyerName);
    orderDto.setOrderReceiverPhone(buyerTel);
    orderDto.setOrderReceiverAddr(buyerAddr);
    orderDto.setOrderCustomerFk(customer.getCustomerId());

    OrderedProductDAO orderedProductDao = OrderedProductDAO.getInstance();

    orderDao.save(orderDto);

    for (int i = 0; i < productIds.length; i++) {
      OrderedProductDTO dto = new OrderedProductDTO();

      dto.setOrderedProductId(orderedProductDao.getOrderedProductId());
      dto.setOrderedProductQunatity(Integer.parseInt(productsQty[i]));
      dto.setOrderedProductProductFk(Integer.parseInt(productIds[i]));
      dto.setOrderedProductOrderFk(orderId);

      orderedProductDao.save(dto);
    }

    JSONObject json = new JSONObject();

    json.put("orderId", orderId);
    json.put("paymentName", paymentName);
    json.put("paymentAmount", paymentAmount);
    json.put("buyerName", buyerName);
    json.put("buyerTel", buyerTel);
    json.put("buyerAddr", buyerAddr);

    response.setContentType("application/json; charset=utf-8");
    response.getWriter().print(json);

    return null;
  }

}
