<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="ko">

<body>
  <h3 class="head-typo">
    <span>&apos;플레이스테이션&apos;</span>에 대한 검색 결과
  </h3>
  <div class="display-products__container">
    <div class="display-products__filter">
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
                class="primary-checkmark-radio"
              />
              <label for="sort-option-radio-1">최신순</label>
            </div>
            <div>
              <input
                type="radio"
                id="sort-option-radio-2"
                name="sort-filter"
                class="primary-checkmark-radio"
              />
              <label for="sort-option-radio-2">과거순</label>
            </div>
            <div>
              <input
                type="radio"
                id="sort-option-radio-3"
                name="sort-filter"
                class="primary-checkmark-radio"
              />
              <label for="sort-option-radio-3">낮은 가격순</label>
            </div>
            <div>
              <input
                type="radio"
                id="sort-option-radio-4"
                name="sort-filter"
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
              class="primary-radio"
            />
            <label for="price-option-radio-1">60,000원 이상</label>
          </div>
          <div>
            <input
              type="radio"
              id="price-option-radio-2"
              name="price-filter"
              class="primary-radio"
            />
            <label for="price-option-radio-2">30,000원 ~ 60,000원</label>
          </div>
          <div>
            <input
              type="radio"
              id="price-option-radio-3"
              name="price-filter"
              class="primary-radio"
            />
            <label for="price-option-radio-3">10,000원 ~ 30,000원</label>
          </div>
          <div>
            <input
              type="radio"
              id="price-option-radio-4"
              name="price-filter"
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
              name="computer_laptop"
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
                  name="labtop_desktop"
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
	                      class="primary-checkbox"
	                      id="filter-category__item-${ level2.getCategoryName() }"
	                      name="labtop_desktop"
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
    </div>
    <div class="display-product__container">
      <p>총 14건</p>
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
      </div>
    </div>
  </div>
</body>

</html>