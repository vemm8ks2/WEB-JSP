<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
</head>

<body>
  <!-- 히든 input 넣고 결제 시 DOM 객체로 불러오기 -->
  <input type="hidden" name="payment-name" value="${paymentName}" />
  <input type="hidden" name="payment-amount" value="${paymentAmount}" />
  <input type="hidden" name="payment-buyer-name" value="${customer.getCustomerName()}" />
  <input type="hidden" name="payment-buyer-tel" value="${customer.getCustomerPhoneNumber()}" />
  <input type="hidden" name="payment-buyer-addr" value="${shippingAddress}" />
  
  <c:forEach items="${productList}" var="p">
  <div style="display:flex; gap:10px">
    <p>${p.getProductName()}</p>
    <p>${p.getProductPrice()}원</p>
  </div>
  </c:forEach>
  <div>
    <button onclick="requestPay()" class="primary-btn default-btn-color">결제하기</button>
  </div>
</body>

</html>