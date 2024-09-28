<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<h3 class="head-typo">
  <c:if test="${!empty keyword}">
    <span>&apos;${keyword}&apos;</span>에 대한 검색 결과
  </c:if>
  <c:if test="${empty keyword}">
    <span>전체 상품 검색 결과</span>
  </c:if>
</h3>
<div class="display-products__container">
  <form method="GET" action="searchView.do" name="search-filter-form" class="display-products__filter">
    <input type="hidden" name="keyword" value="${keyword}">
            
    <p>필터</p>
    <hr />
    <div class="display-products__filter-sort">
      <p>정렬</p>
      <div>
        <fieldset>
          <div>
            <input
              type="radio"
              id="sort-option-radio-1"
              name="sort-filter"
              value="latest"
              onclick="handleFilter()"
              class="primary-checkmark-radio"
            />
            <label for="sort-option-radio-1">최신순</label>
          </div>
          <div>
            <input
              type="radio"
              id="sort-option-radio-2"
              name="sort-filter"
              value="earliest"
              onclick="handleFilter()"
              class="primary-checkmark-radio"
            />
            <label for="sort-option-radio-2">과거순</label>
          </div>
          <div>
            <input
              type="radio"
              id="sort-option-radio-3"
              name="sort-filter"
              value="low-to-high"
              onclick="handleFilter()"
              class="primary-checkmark-radio"
            />
            <label for="sort-option-radio-3">낮은 가격순</label>
          </div>
          <div>
            <input
              type="radio"
              id="sort-option-radio-4"
              name="sort-filter"
              value="high-to-low"
              onclick="handleFilter()"
              class="primary-checkmark-radio"
            />
            <label for="sort-option-radio-4">높은 가격순</label>
          </div>
        </fieldset>
      </div>
    </div>
    <hr />
    <div class="display-products__filter-price">
      <p>가격</p>
      <fieldset>
        <div>
          <input
            type="radio"
            id="price-option-radio-1"
            name="price-filter"
            value="60000~"
            onclick="handleFilter()"
            class="primary-radio"
          />
          <label for="price-option-radio-1">60,000원 이상</label>
        </div>
        <div>
          <input
            type="radio"
            id="price-option-radio-2"
            name="price-filter"
            value="30000~60000"
            onclick="handleFilter()"
            class="primary-radio"
          />
          <label for="price-option-radio-2">30,000원 ~ 60,000원</label>
        </div>
        <div>
          <input
            type="radio"
            id="price-option-radio-3"
            name="price-filter"
            value="10000~30000"
            onclick="handleFilter()"
            class="primary-radio"
          />
          <label for="price-option-radio-3">10,000원 ~ 30,000원</label>
        </div>
        <div>
          <input
            type="radio"
            id="price-option-radio-4"
            name="price-filter"
            value="~10000"
            onclick="handleFilter()"
            class="primary-radio"
          />
          <label for="price-option-radio-4">10,000원 미만</label>
        </div>
      </fieldset>
    </div>
    <hr />
    <div>
      <p>카테고리</p>
      <ul class="display-products__filter-category">
      
        <c:forEach var="root" items="${ rootCategory }">
        <li>
          <input
            type="checkbox"
            id="filter-category__item-${ root.getCategoryName() }"
            name="category-filter"
            value="${ root.getCategoryId() }"
            data-parent-category="0"
            class="display-products__filter-category__checkbox primary-checkbox"
          />
          <label for="filter-category__item-${ root.getCategoryName() }" 
            >${ root.getCategoryName() }</label
          >
          <ul
            class="display-products__filter-category__level-2-wrapper"
          >
          
          <c:forEach var="level1" items="${ categoryList }">
            <c:if test="${ root.getCategoryId() == level1.getCategoryParentFk() }">
            <li>
              <input
                type="checkbox"
                id="filter-category__item-${ level1.getCategoryName() }"
	            name="category-filter"
	            value="${ level1.getCategoryId() }"
	            data-parent-category="${ root.getCategoryId() }"
                class="display-products__filter-category__checkbox primary-checkbox"
              />
              <label for="filter-category__item-${ level1.getCategoryName() }"
                >${ level1.getCategoryName() }</label
              >
              <ul
                class="display-products__filter-category__level-3-wrapper"
              >
              
                <c:forEach var="level2" items="${ categoryList }">
                  <c:if test="${ level1.getCategoryId() == level2.getCategoryParentFk() }">
                  <li>
                    <input
                      type="checkbox"
                      id="filter-category__item-${ level2.getCategoryName() }"
		              name="category-filter"
		              value="${ level2.getCategoryId() }"
           		      data-parent-category="${ level1.getCategoryId() }"
                      class="primary-checkbox"
                    />
                   <label for="filter-category__item-${ level2.getCategoryName() }"
                     >${ level2.getCategoryName() }</label
                    >
                  </li>
                  </c:if>
                </c:forEach>
                
              </ul>
            </li>
            </c:if>
            </c:forEach>
          
          </ul>
        </li>
        </c:forEach>
      
      </ul>
    </div>
  </form>
  <div class="display-product__container">
    <p>총 ${list.size()}건</p>
    <div class="display-products__wrapper">
      <c:forEach var="p" items="${list}">
      <div class="display-products__product">
        <a href="productView.do?id=${p.getProductId()}">
          <div class="display-products__skeleton"></div>
          <p>${p.getProductName()}</p>
          <p>
          	<fmt:formatNumber value="${p.getProductPrice()}" pattern="#,###" />원
          </p>
        </a>
      </div>
      </c:forEach>
    </div>
  </div>
</div>
<script>
  const checkboxes = document.querySelectorAll('input[type="checkbox"]');
  const opennedCategories = ${ opennedCategories };
  
  checkboxes.forEach((checkbox) => {
	  if (opennedCategories.includes(Number(checkbox.value))) {
		  checkbox.classList.add('display-products__filter-category__open')
	  }
  })
</script>