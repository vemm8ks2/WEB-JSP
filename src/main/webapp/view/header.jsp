<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="com.teamtwo.model.CategoryDTO"%>

<%
	List<CategoryDTO> categoryList = (List<CategoryDTO>) request.getServletContext().getAttribute("categoryList");
	List<CategoryDTO> rootCategory = categoryList.stream()
	    	.filter(category -> category.getCategoryParentFk() == 0)
	    	.toList();
	
	request.setAttribute("rootCategory", rootCategory);
%>

<header>
  <div class="header-top-wrapper">
    <!-- TEAM.T 로고 부분 -->
    <h1 class="header-top__logo">
      <a href="mainView.do"> TEAM.<span>T</span> </a>
    </h1>

    <!-- 검색창 -->
    <form class="header-top__search">
      <input id="header-search" placeholder="Search" />
      <button>
        <svg
          xmlns="http://www.w3.org/2000/svg"
          x="0px"
          y="0px"
          viewBox="0 0 30 30"
        >
          <path
            d="M 13 3 C 7.4889971 3 3 7.4889971 3 13 C 3 18.511003 7.4889971 23 13 23 C 15.396508 23 17.597385 22.148986 19.322266 20.736328 L 25.292969 26.707031 A 1.0001 1.0001 0 1 0 26.707031 25.292969 L 20.736328 19.322266 C 22.148986 17.597385 23 15.396508 23 13 C 23 7.4889971 18.511003 3 13 3 z M 13 5 C 17.430123 5 21 8.5698774 21 13 C 21 17.430123 17.430123 21 13 21 C 8.5698774 21 5 17.430123 5 13 C 5 8.5698774 8.5698774 5 13 5 z"
          ></path>
        </svg>
      </button>
    </form>
    
    <c:set var="dto" value="${customer}"/>
    <!-- 로그인 UI -->
    <c:if test="${ !empty customer }">
    <div class="header-top__logged-in">
      <a href="#">
        <svg
          version="1.1"
          xmlns="http://www.w3.org/2000/svg"
          viewBox="0 0 512 512"
          xmlns:xlink="http://www.w3.org/1999/xlink"
          enable-background="new 0 0 512 512"
        >
          <g>
            <g>
              <path
                d="m464.5,301.1l36.5-178h-359.7l-12.5-59.2-108.4-52.9-9.4,18.7 99,47.8 50,238.8h289c0,0 28.5,17.9 17.5,40.5-4.9,7-12.5,15.6-26.1,15.6h-287.6v20.6h287.7c19.8,0 36.5-10.4 45.9-27 18.4-34.4-21.9-64.9-21.9-64.9zm-286.7-5.7l-32.3-151.6h330.5l-31.3,151.6h-266.9z"
              />
              <path
                d="m212.2,422.1c-21.9,0-39.6,17.6-39.6,39.4s17.7,39.4 39.6,39.4 39.6-17.6 39.6-39.4-17.7-39.4-39.6-39.4zm0,58.1c-10.4,0-18.8-8.3-18.8-18.7s8.3-18.7 18.8-18.7 18.8,8.3 18.8,18.7-8.4,18.7-18.8,18.7z"
              />
              <path
                d="m424.9,422.1c-21.9,0-39.6,17.6-39.6,39.4s17.7,39.5 39.6,39.5 40.7-17.6 39.6-39.4c0-21.8-17.7-39.5-39.6-39.5zm18.8,39.5c0,10.4-8.3,18.7-18.8,18.7s-18.8-8.3-18.8-18.7 8.3-18.7 18.8-18.7 19.8,8.3 18.8,18.7z"
              />
            </g>
          </g>
        </svg>
      </a>
      <a href="customerView.do?id=${dto.getCustomerId()}">
        <svg viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
          <circle cx="12" cy="9" r="3" />
          <circle cx="12" cy="12" r="10" />
          <path
            d="M17.9691 20C17.81 17.1085 16.9247 15 11.9999 15C7.07521 15 6.18991 17.1085 6.03076 20"
          />
        </svg>
      </a>
    </div>
	</c:if>
	
    <!-- 비로그인 UI -->
    <c:if test="${ empty customer }">
    <div class="header-top__logged-out">
      <a href="loginView.do">
        <button class="primary-btn default-btn-color">로그인</button>
      </a>
      <a href="registerView.do">
        <button class="primary-btn reverse-btn-color">회원가입</button>
      </a>
    </div>
    </c:if>
  </div>

  <!-- 카테고리 바 -->
  <nav class="header-bottom__nav">
    <ul class="header-bottom__wrapper">
	  <c:forEach var="root" items="${ rootCategory }">
	  <li class="header-bottom__category-level-1">
	    <a href="#">
          <span>${ root.getCategoryName() }</span>
        </a>
	    <ul class="header-bottom__category-level-2__wrapper">
	    <%-- 
	    	TODO: ul 태그의 클래스를 보면 'absolute min-w-max ...' 나열되어 있는데 해당 태그는 하위 태그가 있을 때 적용되어야 하는데 처음에 이를
	    	고려하지 못하고 작성하여 스타일링이 불완전하다. 구체적으로는 하위 태그가 아예 없음에도 박스가 생겨난다. HTML 구조와 CSS 수정이 필요하다.
	     --%>
        
      	<c:forEach var="level1" items="${ categoryList }">
      	  <c:if test="${ root.getCategoryId() == level1.getCategoryParentFk() }">
            <div>
	          <a href="#">
	            <span>${ level1.getCategoryName() }</span>
	          </a>
	      	  <li class="header-bottom__category-level-2">
	            <div>
	              <ul class="header-bottom__category-level-3__wrapper">
	                
			      <c:forEach var="level2" items="${ categoryList }">
			        <c:if test="${ level1.getCategoryId() == level2.getCategoryParentFk() }">
		              <li class="header-bottom__category-level-3">
		                <a href="#">${ level2.getCategoryName() }</a>
		              </li>
		              <hr />
			        </c:if>
			      </c:forEach>
			        
	              </ul>
	            </div>
	          </li>
	        </div>
	        <hr />
      	  </c:if>
      	</c:forEach>
      	
        </ul>
      </li>
      </c:forEach>
    </ul>
  </nav>
</header>