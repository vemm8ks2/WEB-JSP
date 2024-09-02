<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="com.teamtwo.model.CategoryDTO"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	List<CategoryDTO> categoryList = (List<CategoryDTO>) request.getServletContext().getAttribute("categoryList");
	List<CategoryDTO> rootCategory = categoryList.stream()
	    	.filter(category -> category.getCategoryParentFk() == 0)
	    	.toList();
	
	request.setAttribute("rootCategory", rootCategory);
%>

<header class="p-4 border-b"> <!-- header -->
  <div class="flex justify-between items-center px-2"> <!-- .header-top-wrapper -->
    <h1 class="font-bold text-xl"> <!-- .header-top__logo -->
      <a href="mainView.do" class="text-slate-700">
        TEAM.<span class="text-slate-400">T</span>
      </a>
    </h1>
    <form class="relative bg-gray-100 flex-grow-[0.3] pl-10 pr-1 py-1 rounded-md"> <!-- .header-top__search -->
      <input id="header-search" class="bg-inherit w-full py-1 pl-1" placeholder="Search">
      <button class="absolute left-1 p-1.5 bg-inherit">
        <svg class="w-5 fill-gray-500" xmlns="http://www.w3.org/2000/svg" x="0px" y="0px" viewBox="0 0 30 30">
          <path d="M 13 3 C 7.4889971 3 3 7.4889971 3 13 C 3 18.511003 7.4889971 23 13 23 C 15.396508 23 17.597385 22.148986 19.322266 20.736328 L 25.292969 26.707031 A 1.0001 1.0001 0 1 0 26.707031 25.292969 L 20.736328 19.322266 C 22.148986 17.597385 23 15.396508 23 13 C 23 7.4889971 18.511003 3 13 3 z M 13 5 C 17.430123 5 21 8.5698774 21 13 C 21 17.430123 17.430123 21 13 21 C 8.5698774 21 5 17.430123 5 13 C 5 8.5698774 8.5698774 5 13 5 z"></path>
        </svg>
      </button>
    </form>
    <!-- .header-top__logged-in -->
    <!-- 로그인 상태 UI
    <div class="flex gap-4">
      <a href="#">
        <div class="relative">
          <svg class="w-8 fill-gray-500" version="1.1" id="Capa_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" viewBox="0 0 483.1 483.1" xml:space="preserve">
            <g>
              <path d="M434.55,418.7l-27.8-313.3c-0.5-6.2-5.7-10.9-12-10.9h-58.6c-0.1-52.1-42.5-94.5-94.6-94.5s-94.5,42.4-94.6,94.5h-58.6 c-6.2,0-11.4,4.7-12,10.9l-27.8,313.3c0,0.4,0,0.7,0,1.1c0,34.9,32.1,63.3,71.5,63.3h243c39.4,0,71.5-28.4,71.5-63.3
                C434.55,419.4,434.55,419.1,434.55,418.7z M241.55,24c38.9,0,70.5,31.6,70.6,70.5h-141.2C171.05,55.6,202.65,24,241.55,24z M363.05,459h-243c-26,0-47.2-17.3-47.5-38.8l26.8-301.7h47.6v42.1c0,6.6,5.4,12,12,12s12-5.4,12-12v-42.1h141.2v42.1
                c0,6.6,5.4,12,12,12s12-5.4,12-12v-42.1h47.6l26.8,301.8C410.25,441.7,389.05,459,363.05,459z"/>
            </g>
          </svg>
          <div class="absolute flex justify-center items-center w-6 h-6 right-[-5px] bottom-[-5px] border-2 border-gray-500 rounded-full bg-white">
            <span class="text-sm font-bold text-gray-500">0</span>
          </div>
        </div>
      </a>
      <a href="userView.do">
        <div class="border-2 border-gray-400 w-9 h-9 rounded-full flex justify-center overflow-hidden">
          <svg class="w-8 fill-gray-400 translate-y-1" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 32 32" style="enable-background:new 0 0 32 32" xml:space="preserve"><path d="M16 14c-3.86 0-7-3.14-7-7s3.14-7 7-7 7 3.14 7 7-3.14 7-7 7zm0-12c-2.757 0-5 2.243-5 5s2.243 5 5 5 5-2.243 5-5-2.243-5-5-5zM27 32a1 1 0 0 1-1-1v-6.115a6.95 6.95 0 0 0-6.942-6.943h-6.116A6.95 6.95 0 0 0 6 24.885V31a1 1 0 1 1-2 0v-6.115c0-4.93 4.012-8.943 8.942-8.943h6.116c4.93 0 8.942 4.012 8.942 8.943V31a1 1 0 0 1-1 1z"/></svg>
        </div>
      </a>
    </div>
    -->
    <!-- .header-top__logged-out -->
    <div class="flex gap-2">
      <a href="loginView.do">
        <button class="px-6 py-2 rounded-md bg-black text-white">
          로그인
        </button>
      </a>
      <a href="registerView.do">
        <button class="px-6 py-2 rounded-md bg-white text-black">
          회원가입
        </button>
      </a>
    </div>
  </div>
  <nav class="mt-4 text-slate-500 [&_*]:z-10"> <!-- .header-bottom__nav -->
    <ul class="flex [&>li]:mr-4 [&>li]:font-medium [&>li:hover>span]:text-slate-900"> <!-- .header-bottom__wrapper -->
	  <c:forEach var="root" items="${ rootCategory }">
	  <li class="relative [&>ul]:hidden [&:hover>ul]:block">
        <span class="inline-block p-2">${ root.getCategoryName() }</span>
	    <ul class="absolute min-w-max bg-white border py-2 rounded-md  [&>div>li]:hidden [&>div:hover>li]:block [&>hr:last-child]:hidden">
	    <%-- 
	    	TODO: ul 태그의 클래스를 보면 'absolute min-w-max ...' 나열되어 있는데 해당 태그는 하위 태그가 있을 때 적용되어야 하는데 처음에 이를
	    	고려하지 못하고 작성하여 스타일링이 불완전하다. 구체적으로는 하위 태그가 아예 없음에도 박스가 생겨난다. HTML 구조와 CSS 수정이 필요하다.
	     --%>
        
      	<c:forEach var="level1" items="${ categoryList }">
      	  <c:if test="${ root.getCategoryId() == level1.getCategoryParentFk() }">
            <div class="relative py-2 px-4 hover:bg-slate-100 [&:hover>span]:text-slate-700">
	          <span>${ level1.getCategoryName() }</span>
	      	  <li class="absolute top-0 right-0 flex">
	            <div class="relative py-2">
	              <ul class="absolute left-[-5px] py-2 border rounded-md min-w-36 bg-white [&>li>a]:inline-block [&>li>a]:min-w-max [&>hr:last-child]:hidden">
	                
			      <c:forEach var="level2" items="${ categoryList }">
			        <c:if test="${ level1.getCategoryId() == level2.getCategoryParentFk() }">
		              <li class="hover:bg-slate-100 [&:hover>a]:text-slate-700">
		                <a href="#" class="w-full px-4 py-2">${ level2.getCategoryName() }</a>
		              </li>
		              <hr class="m-2">
			        </c:if>
			      </c:forEach>
			        
	              </ul>
	            </div>
	          </li>
	        </div>
	        <hr class="m-2">
      	  </c:if>
      	</c:forEach>
      	
        </ul>
      </li>
      </c:forEach>
    </ul>
  </nav>
</header>