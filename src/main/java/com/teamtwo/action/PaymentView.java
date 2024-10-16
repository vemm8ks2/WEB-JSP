package com.teamtwo.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.teamtwo.model.CustomerDTO;
import com.teamtwo.model.ProductDAO;
import com.teamtwo.model.ProductDTO;
import com.teamtwo.model.PurchaseDTO;
import com.teamtwo.model.ShippingAddressDAO;
import com.teamtwo.model.ShippingAddressDTO;

public class PaymentView implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    HttpSession session = request.getSession();
    CustomerDTO customer = (CustomerDTO) session.getAttribute("customer"); // 세션에서 값 받아옴

    ActionForward forward = new ActionForward();

    forward.setRedirect(false);
    forward.setPath("view/layout.jsp");

    /**
     * TODO(24.09.24): 로그인 되어있지 않은 유저 핸들링
     */
    if (customer == null) {
      request.setAttribute("url", "login.jsp");
      request.setAttribute("stylesheet", "login.css");
      return forward;
    }

    /**
     * TODO(24.09.26): JSON 데이터로 받기 (보류)
     */
    String[] productIds = request.getParameterValues("id");
    String[] productsQty = request.getParameterValues("qty");

    List<PurchaseDTO> purchaseList = new ArrayList<>();

    /**
     * TODO(24.09.25): 에러 핸들링
     */
    if (productIds.length != productsQty.length)
      return null;

    for (int i = 0; i < productIds.length; i++) {
      PurchaseDTO dto = new PurchaseDTO();

      dto.setProductId(Integer.parseInt(productIds[i]));
      dto.setProductQty(Integer.parseInt(productsQty[i]));

      purchaseList.add(dto);
    }

    ProductDAO dao = ProductDAO.getInstance();
    List<ProductDTO> productList = dao.getProductsByIds(productIds);

    if (productList.size() == 0)
      return null;

    int paymentAmount = 0;

    for (PurchaseDTO p : purchaseList) {
      int qty = p.getProductQty();
      int unitPrice = productList.stream().filter(dto -> dto.getProductId() == p.getProductId())
          .findFirst().get().getProductPrice();

      paymentAmount += unitPrice * qty;
    }

    /**
     * TODO(24.09.24): 지금은 DB에서 유저의 배송지를 가져오지만 결제 페이지에서 지정된 주소를 받게 변경해야 합니다.
     */
    ShippingAddressDAO addressDao = ShippingAddressDAO.getInstance();
    ShippingAddressDTO shippingAddress =
        addressDao.getShippingAddressByCustomer(customer.getCustomerId()).get(0);

    List<String> externalJavascriptList = new ArrayList<>();
    externalJavascriptList.add("https://cdn.iamport.kr/v1/iamport.js");

    String paymentName = productList.get(0).getProductName();

    if (productList.size() > 1) {
      paymentName += " 외 " + (productList.size() - 1) + "종";
    }

    request.setAttribute("paymentName", paymentName);
    request.setAttribute("paymentAmount", paymentAmount);
    request.setAttribute("cutsomer", customer);
    request.setAttribute("shippingAddress", shippingAddress.getShippingAddressDestination());
    request.setAttribute("productList", productList);
    request.setAttribute("purchaseList", purchaseList);
    
    request.setAttribute("url", "payment.jsp");
    request.setAttribute("externalJavascriptList", externalJavascriptList);
    request.setAttribute("javascript", "payment.js");

    return forward;
  }

}
