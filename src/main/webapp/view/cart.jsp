<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<div>
  <p>장바구니 페이지</p>
  <c:forEach items="${cartResult}" var="dto">
    <c:set value="${dto.getCartDTO()}" var="cartDto" />
    <c:set value="${dto.getProductDTO()}" var="productDto" />
    
    <p>상품 이름 : ${productDto.getProductName()}</p>
    <p>상품 개당 가격 : ${productDto.getProductPrice()}</p>
    <p>개수 : ${cartDto.getCartProductCount()}</p>
    <p>상품별 총 가격 : ${productDto.getProductPrice() * cartDto.getCartProductCount()}</p>
    <br />
  </c:forEach>
</div>
