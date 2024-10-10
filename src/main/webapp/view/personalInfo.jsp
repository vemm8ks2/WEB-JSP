<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form
  method="POST"
  action="personalInfoUpdate.do" 
  style="display: flex; flex-direction: column; align-items: center; gap:10px;"
>
  <p>유저의 개인정보 페이지입니다.</p>
  <br>
  <p>이름 : 
    <input name="customer_name" value="${customer.getCustomerName()}" />
  </p>
  <p>이메일 : 
    <input name="customer_email" type="email" value="${customer.getCustomerEmail()}" />
  </p>
  <p>전화번호 : 
    <input name="customer_phone_number" value="${customer.getCustomerPhoneNumber()}" />
  </p>
  <p>성별 : 
    <select name="customer_gender">
      <option value="M">남성</option>
      <option value="F">여성</option>
    </select>
  </p>
  <p>
    생년월일 : 
    <input name="customer_birth" type="date" value="${customer.getCustomerBirth().substring(0, 10)}" />
  </p>
  <p>회원가입일 : ${customer.getCustomerCreatedAt()}</p>
  <c:if test="${!empty customer.getCustomerUpdatedAt()}">
    <p>업데이트일 : ${customer.getCustomerUpdatedAt()}</p>
  </c:if>
 
  <c:forEach items="${shippingAddressList}" var="dto">
  <div style="display:flex; gap:20px">
    <p>${dto.getShippingAddressId()}</p>
	  <p>주소 : ${dto.getShippingAddressDestination()}</p>
	  <p>기본 배송지 여부 : ${dto.getShippingAddressIsDefault()}</p>
	  <p>${dto.getShippingAddressCustomerFk()}</p>
  </div>
  </c:forEach>
  
  <button class="primary-btn default-btn-color">업데이트</button>
</form>
<input name="customer_default_gender" type="hidden" value="${customer.getCustomerGender()}" />