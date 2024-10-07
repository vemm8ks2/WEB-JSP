<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<div>
  <input type="hidden" name="payment-name" value="${paymentName}" />
  <input type="hidden" name="payment-amount" value="${paymentAmount}" />
  <input type="hidden" name="payment-buyer-name" value="${customer.getCustomerName()}" />
  <input type="hidden" name="payment-buyer-tel" value="${customer.getCustomerPhoneNumber()}" />
  <input type="hidden" name="payment-buyer-addr" value="${shippingAddress}" />
  <c:forEach items="${purchaseList}" var="p">
  <input type="hidden" name="purchase-product-id" value="${p.getProductId()}" />
  <input type="hidden" name="purchase-product-qty" value="${p.getProductQty()}" />
  </c:forEach>
  
  <c:forEach items="${productList}" var="p" varStatus="status" >
  <div style="display:flex; gap:10px">
	<c:forEach items="${purchaseList}" var="purchaseProduct">
	  <c:if test="${purchaseProduct.getProductId() == p.getProductId()}">
      <input type="hidden" name="product-id" value="${p.getProductId()}" />
      <p>${p.getProductName()}</p>
	  <p>${purchaseProduct.getProductQty()}개</p>
      <p>${p.getProductPrice() * purchaseProduct.getProductQty()}원</p>
	  </c:if>
	</c:forEach>
  </div>
  </c:forEach>
  
  <br/>
  <p>금액 합계 : ${paymentAmount}원</p>
  <div>
    <button onclick="proceedPay()" class="primary-btn default-btn-color">결제하기</button>
  </div>
</div>
