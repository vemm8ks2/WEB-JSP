<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<form method="POST" action="paymentView.do">
  <p>장바구니 페이지</p>
  <br />
  <c:forEach items="${cartResult}" var="dto">
    <c:set value="${dto.getCartDTO()}" var="cartDto" />
    <c:set value="${dto.getProductDTO()}" var="productDto" />
    
	<input type="checkbox" checked name="${productDto.getProductId()}" />    
    <p>상품 이름 : ${productDto.getProductName()}</p>
    <p>상품 개당 가격 : 
      <span data-product-unit-price="${productDto.getProductId()}">
        ${productDto.getProductPrice()}
      </span>
    </p>
    <p>
	  개수 : 
	  <input 
	    type="number" 
	    value="${cartDto.getCartProductCount()}" 
	    min="1"
	    data-product-id="${productDto.getProductId()}" 
	  />
    </p>
    <p>상품별 총 가격 : 
      <span data-product-total-price="${productDto.getProductId()}">
        ${productDto.getProductPrice() * cartDto.getCartProductCount()}
      </span>
    </p>
    <br />
    <br />
  </c:forEach>
  <button class="primary-btn default-btn-color">주문하기</button>
</form>
