<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="customer-wrapper">
  <div class="customer-wrapper__image">
    <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
      <circle cx="12" cy="9" r="3" />
      <circle cx="12" cy="12" r="10" />
      <path
        d="M17.9691 20C17.81 17.1085 16.9247 15 11.9999 15C7.07521 15 6.18991 17.1085 6.03076 20"
      />
    </svg>
  </div>
  <c:set var="dto" value="${customer}"/>
  <div>
    <p class="customer-wrapper__name">${dto.getCustomerName() }</p>
    <p>${dto.getCustomerPhoneNumber() }</p>
  </div>
  <hr />
  <div>
  <c:set var="ddto" value="${address}"/>
    <p>기본 배송지</p>
    <p class="customer-wrapper__address">${ddto.getShippingAddressDestination()}</p>
  </div>
  <hr />
  <div>
    <a href="#" class="customer-wrapper__link">
      <button>주문목록</button>
    </a>
  </div>
  <hr />
  <div>
    <a href="#" class="customer-wrapper__link">
      <button>마이페이지</button>
    </a>
  </div>
  <hr />
  <div>
    <a href="#" class="customer-wrapper__link">
      <button>취소&#183;반품&#183;교환목록</button>
    </a>
  </div>
  <hr />
  <div>
    <a href="#" class="customer-wrapper__link">
      <button>리뷰목록</button>
    </a>
  </div>
  <hr />
  <div class="w-full">
    <a href="#" class="customer-wrapper__link">
      <button>고객센터</button>
    </a>
  </div>
</div>