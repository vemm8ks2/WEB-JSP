<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<div class="banner-01"></div>
<div class="display-products__first-wrapper">
  <p class="display-products__header">지금 가장 많이 담는 특가</p>
  <div class="display-products__carousel-container">
    <div class="display-products_carousel-product-wrapper">
      <div class="display-products__carousel carousel-no-1" style="transform: translateX(0%);">
        <c:forEach items="${mostAddedToCart}" var="p">
        <div class="display-products__product">
          <a href="productView.do?id=${p.getProductId()}">
            <img src="https://placehold.co/600x400" class="display-products__skeleton" />
            <p>${p.getProductName()}</p>
            <p>
              <fmt:formatNumber value="${p.getProductPrice()}" pattern="#,###" />원
            </p>
          </a>
        </div>
        </c:forEach>
      </div>
    </div>
    <div class="carousel-btn-container carousel-prev-container">
      <button class="carousel-prev-btn">
        <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 330 330" xml:space="preserve">
          <path d="M250.606,154.389l-150-149.996c-5.857-5.858-15.355-5.858-21.213,0.001 c-5.857,5.858-5.857,15.355,0.001,21.213l139.393,139.39L79.393,304.394c-5.857,5.858-5.857,15.355,0.001,21.213 C82.322,328.536,86.161,330,90,330s7.678-1.464,10.607-4.394l149.999-150.004c2.814-2.813,4.394-6.628,4.394-10.606 C255,161.018,253.42,157.202,250.606,154.389z"/>
        </svg>
      </button>
    </div>
    <div class="carousel-btn-container carousel-next-container">
      <button class="carousel-next-btn">
        <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 330 330" xml:space="preserve">
          <path d="M250.606,154.389l-150-149.996c-5.857-5.858-15.355-5.858-21.213,0.001 c-5.857,5.858-5.857,15.355,0.001,21.213l139.393,139.39L79.393,304.394c-5.857,5.858-5.857,15.355,0.001,21.213 C82.322,328.536,86.161,330,90,330s7.678-1.464,10.607-4.394l149.999-150.004c2.814-2.813,4.394-6.628,4.394-10.606 C255,161.018,253.42,157.202,250.606,154.389z"/>
        </svg>
      </button>
    </div>
  </div>
</div>
<div class="banner-02"></div>
<div class="display-products">
  <p class="display-products__header">실시간 인기 랭킹</p>
  <div class="display-products__carousel-container">
    <div class="display-products_carousel-product-wrapper">
      <div class="display-products__carousel carousel-no-2" style="transform: translateX(0%);">
        <c:forEach items="${realTimePopularity}" var="p">
        <div class="display-products__product">
          <a href="productView.do?id=${p.getProductId()}">
            <img src="https://placehold.co/600x400" class="display-products__skeleton" />
            <p>${p.getProductName()}</p>
            <p>
              <fmt:formatNumber value="${p.getProductPrice()}" pattern="#,###" />원
            </p>
          </a>
        </div>
        </c:forEach>
      </div>
    </div>
    <div class="carousel-btn-container carousel-prev-container">
      <button class="carousel-prev-btn">
        <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 330 330" xml:space="preserve">
          <path d="M250.606,154.389l-150-149.996c-5.857-5.858-15.355-5.858-21.213,0.001 c-5.857,5.858-5.857,15.355,0.001,21.213l139.393,139.39L79.393,304.394c-5.857,5.858-5.857,15.355,0.001,21.213 C82.322,328.536,86.161,330,90,330s7.678-1.464,10.607-4.394l149.999-150.004c2.814-2.813,4.394-6.628,4.394-10.606 C255,161.018,253.42,157.202,250.606,154.389z"/>
        </svg>
      </button>
    </div>
    <div class="carousel-btn-container carousel-next-container">
      <button class="carousel-next-btn">
        <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 330 330" xml:space="preserve">
          <path d="M250.606,154.389l-150-149.996c-5.857-5.858-15.355-5.858-21.213,0.001 c-5.857,5.858-5.857,15.355,0.001,21.213l139.393,139.39L79.393,304.394c-5.857,5.858-5.857,15.355,0.001,21.213 C82.322,328.536,86.161,330,90,330s7.678-1.464,10.607-4.394l149.999-150.004c2.814-2.813,4.394-6.628,4.394-10.606 C255,161.018,253.42,157.202,250.606,154.389z"/>
        </svg>
      </button>
    </div>
  </div>
</div>
<div class="display-products mt-16">
  <p class="display-products__header">베스트 셀러 랭킹</p>
  <div class="display-products__carousel-container">
    <div class="display-products_carousel-product-wrapper">
      <div class="display-products__carousel carousel-no-3" style="transform: translateX(0%);">
        <c:forEach items="${bestSeller}" var="p">
        <div class="display-products__product">
          <a href="productView.do?id=${p.getProductId()}">
            <img src="https://placehold.co/600x400" class="display-products__skeleton" />
            <p>${p.getProductName()}</p>
            <p>
              <fmt:formatNumber value="${p.getProductPrice()}" pattern="#,###" />원
            </p>
          </a>
        </div>
        </c:forEach>
      </div>
    </div>
    <div class="carousel-btn-container carousel-prev-container">
      <button class="carousel-prev-btn">
        <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 330 330" xml:space="preserve">
          <path d="M250.606,154.389l-150-149.996c-5.857-5.858-15.355-5.858-21.213,0.001 c-5.857,5.858-5.857,15.355,0.001,21.213l139.393,139.39L79.393,304.394c-5.857,5.858-5.857,15.355,0.001,21.213 C82.322,328.536,86.161,330,90,330s7.678-1.464,10.607-4.394l149.999-150.004c2.814-2.813,4.394-6.628,4.394-10.606 C255,161.018,253.42,157.202,250.606,154.389z"/>
        </svg>
      </button>
    </div>
    <div class="carousel-btn-container carousel-next-container">
      <button class="carousel-next-btn">
        <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 330 330" xml:space="preserve">
          <path d="M250.606,154.389l-150-149.996c-5.857-5.858-15.355-5.858-21.213,0.001 c-5.857,5.858-5.857,15.355,0.001,21.213l139.393,139.39L79.393,304.394c-5.857,5.858-5.857,15.355,0.001,21.213 C82.322,328.536,86.161,330,90,330s7.678-1.464,10.607-4.394l149.999-150.004c2.814-2.813,4.394-6.628,4.394-10.606 C255,161.018,253.42,157.202,250.606,154.389z"/>
        </svg>
      </button>
    </div>
  </div>
</div>
<div class="display-products mt-16">
  <p class="display-products__header">조회수 랭킹</p>
  <div class="display-products__carousel-container">
    <div class="display-products_carousel-product-wrapper">
      <div class="display-products__carousel carousel-no-4" style="transform: translateX(0%);">
        <c:forEach items="${mostViews}" var="p">
        <div class="display-products__product">
          <a href="productView.do?id=${p.getProductId()}">
            <img src="https://placehold.co/600x400" class="display-products__skeleton" />
            <p>${p.getProductName()}</p>
            <p>
              <fmt:formatNumber value="${p.getProductPrice()}" pattern="#,###" />원
            </p>
          </a>
        </div>
        </c:forEach>
      </div>
    </div>
    <div class="carousel-btn-container carousel-prev-container">
      <button class="carousel-prev-btn">
        <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 330 330" xml:space="preserve">
          <path d="M250.606,154.389l-150-149.996c-5.857-5.858-15.355-5.858-21.213,0.001 c-5.857,5.858-5.857,15.355,0.001,21.213l139.393,139.39L79.393,304.394c-5.857,5.858-5.857,15.355,0.001,21.213 C82.322,328.536,86.161,330,90,330s7.678-1.464,10.607-4.394l149.999-150.004c2.814-2.813,4.394-6.628,4.394-10.606 C255,161.018,253.42,157.202,250.606,154.389z"/>
        </svg>
      </button>
    </div>
    <div class="carousel-btn-container carousel-next-container">
      <button class="carousel-next-btn">
        <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 330 330" xml:space="preserve">
          <path d="M250.606,154.389l-150-149.996c-5.857-5.858-15.355-5.858-21.213,0.001 c-5.857,5.858-5.857,15.355,0.001,21.213l139.393,139.39L79.393,304.394c-5.857,5.858-5.857,15.355,0.001,21.213 C82.322,328.536,86.161,330,90,330s7.678-1.464,10.607-4.394l149.999-150.004c2.814-2.813,4.394-6.628,4.394-10.606 C255,161.018,253.42,157.202,250.606,154.389z"/>
        </svg>
      </button>
    </div>
  </div>
</div>