<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
document.addEventListener('DOMContentLoaded', function() {
  const slider = document.querySelector('.display-products__products');
  const slideItems = slider.querySelectorAll('.display-products__product');
  const prevButton = document.querySelector('.arrow .prev');
  const nextButton = document.querySelector('.arrow .next');

  let currentIdx = 0; // Track the current slide
  const totalSlides = slideItems.length; // Total number of slides
  const slideWidth = slideItems[0].clientWidth; // Width of each slide

  nextButton.addEventListener('click', function(event) {
    event.preventDefault();
    if (currentIdx < totalSlides - 1) {
      currentIdx++;
      slider.style.transform = `translateX(-${currentIdx * slideWidth}px)`;
    }
  });

  prevButton.addEventListener('click', function(event) {
    event.preventDefault();
    if (currentIdx > 0) {
      currentIdx--;
      slider.style.transform = `translateX(-${currentIdx * slideWidth}px)`;
    }
  });
});
</script>

<c:set var="pList" value="${productList }"/>

<div class="banner-01"></div>
<div class="display-products__first-wrapper">
  <p class="display-products__header">지금 가장 많이 담는 특가</p>
  <div class="display-products__slider">
    <div class="display-products__products">
      <c:if test="${!empty pList}">
        <c:forEach items="${pList}" var="list">
          <div class="display-products__product">
            <a href="<%=request.getContextPath()%>/productView.do?num=${list.getProductId()}">
              <div class="display-products__skeleton"></div>
              <p>${list.getProductName()}</p>
              <p><fmt:formatNumber type="number" value="${list.getProductPrice()}"/>원</p>
            </a>
          </div> <!-- display-products__product -->
        </c:forEach>
      </c:if>
      <c:if test="${empty pList}">
        <h3>불러올 정보가 없습니다.</h3>
      </c:if>
    </div><!-- display-products__products -->
  </div> <!-- display-products__slider -->
  
  <div class="arrow">
    <a href="" class="prev">이전</a>
    <a href="" class="next">다음</a>
  </div>
</div>


<div class="banner-02"></div>
<div class="display-products">
  <p class="display-products__header">실시간 인기 랭킹</p>
  <div class="display-products__wrapper">
  <div class ="display-products__slider">
    <div class="display-products__product">
      <a href="productView.do">
        <div class="display-products__skeleton"></div>
        <p>[해운대암소갈비집] 한우 소불고기 전골</p>
        <p>15,900원</p>
      </a>
    </div>
    <div class="display-products__product">
      <a href="productView.do">
        <div class="display-products__skeleton"></div>
        <p>[오쏘몰] 오쏘몰 이뮨 드링크+정제 2박스 (60일분)</p>
        <p>169,000원</p>
      </a>
    </div>
    <div class="display-products__product">
      <a href="productView.do">
        <div class="display-products__skeleton"></div>
        <p>미국산 생 블루베리 2종</p>
        <p>4,990원</p>
      </a>
    </div>
    <div class="display-products__product">
      <a href="productView.do">
        <div class="display-products__skeleton"></div>
        <p>[소반옥] 인기 냉면 2종 (택1)</p>
        <p>8,900원</p>
      </a>
    </div>
  </div><!-- display-products__slider -->
  <div class = "arrow">
  <a href="" class="prev">이전</a>
  <a href="" class="next">다음</a>
  </div> <!-- arrow -->
  </div><!-- display-products__wrapper -->
</div><!-- display-products -->
<div class="display-products mt-16">
  <p class="display-products__header">베스트 셀러 랭킹</p>
  <div class="display-products__wrapper">
    <div class="display-products__product">
      <a href="productView.do">
        <div class="display-products__skeleton"></div>
        <p>[해운대암소갈비집] 한우 소불고기 전골</p>
        <p>15,900원</p>
      </a>
    </div>
    <div class="display-products__product">
      <a href="productView.do">
        <div class="display-products__skeleton"></div>
        <p>[오쏘몰] 오쏘몰 이뮨 드링크+정제 2박스 (60일분)</p>
        <p>169,000원</p>
      </a>
    </div>
    <div class="display-products__product">
      <a href="productView.do">
        <div class="display-products__skeleton"></div>
        <p>미국산 생 블루베리 2종</p>
        <p>4,990원</p>
      </a>
    </div>
    <div class="display-products__product">
      <a href="productView.do">
        <div class="display-products__skeleton"></div>
        <p>[소반옥] 인기 냉면 2종 (택1)</p>
        <p>8,900원</p>
      </a>
    </div>
  </div>
</div>
<div class="display-products mt-16">
  <p class="display-products__header">조회수 랭킹</p>
  <div class="display-products__wrapper">
    <div class="display-products__product">
      <a href="productView.do">
        <div class="display-products__skeleton"></div>
        <p>[해운대암소갈비집] 한우 소불고기 전골</p>
        <p>15,900원</p>
      </a>
    </div>
    <div class="display-products__product">
      <a href="productView.do">
        <div class="display-products__skeleton"></div>
        <p>[오쏘몰] 오쏘몰 이뮨 드링크+정제 2박스 (60일분)</p>
        <p>169,000원</p>
      </a>
    </div>
    <div class="display-products__product">
      <a href="productView.do">
        <div class="display-products__skeleton"></div>
        <p>미국산 생 블루베리 2종</p>
        <p>4,990원</p>
      </a>
    </div>
    <div class="display-products__product">
      <a href="productView.do">
        <div class="display-products__skeleton"></div>
        <p>[소반옥] 인기 냉면 2종 (택1)</p>
        <p>8,900원</p>
      </a>
    </div>
  </div>
</div>