<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="customer-wrapper">
  <div class="customer-wrapper__image">
    <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
      <circle cx="12" cy="9" r="3" />
      <circle cx="12" cy="12" r="10" />
      <path d="M17.9691 20C17.81 17.1085 16.9247 15 11.9999 15C7.07521 15 6.18991 17.1085 6.03076 20" />
    </svg>
  </div>
  <div>
    <p class="customer-wrapper__name">${customer.getCustomerName() }</p>
    <p>${customer.getCustomerPhoneNumber() }</p>
  </div>
  <hr />
  <div>
    <p>기본 배송지</p>
    <p class="customer-wrapper__address">
      ${defaultAddress.getShippingAddressDestination()}
    </p>
  </div>
  <hr />
  <div>
    <a href="personalOrderListView.do" class="customer-wrapper__link">
      <button>주문목록</button>
    </a>
  </div>
  <hr />
  <div>
    <a href="personalInfoView.do" class="customer-wrapper__link">
      <button>개인정보</button>
    </a>
  </div>
  <hr />
  <div>
    <a href="personalAddressListView.do" class="customer-wrapper__link">
      <button>배송지목록</button>
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