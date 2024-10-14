<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
	24.09.24
	유저의 배송지 목록은 페이지로 나눌지 말지 결정해야 합니다.
	즉, 배송지의 Create, Read, Update, Delete가 어디서 수행되어야 적절할지 유저의 입장에서 고려해보아야 합니다.  
--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
	<c:set var="list" value="${addressList}"/>
	<table border="">
		<tr>
			<th>기본 배송지</th>
			<th colspan="2">주소지</th>
		</tr>
		<c:if test="${!empty list}">
			<c:forEach items="${list}" var="dto">
				<tr align="center">
					<td> <input name="default" type="radio" value="${dto.getShippingAddressId()}"
					<c:if test="${dto.getShippingAddressIsDefault() eq 'Y'}">checked</c:if> ></td>
					
					<td>${dto.getShippingAddressDestination()}</td>
					<td>
						<button onclick="" class="primary-btn reverse-btn-color">수정</button>
					</td>
				</tr>
			</c:forEach>
		</c:if>

		<c:if test="${empty list}">
			<tr>
				<th colspan="3">등록된 주소지가 없습니다.</th>
			</tr>
		</c:if>		
	</table>
	<br>
	<button onclick="" class="primary-btn reverse-btn-color">저장</button>
	<button onclick="" class="primary-btn reverse-btn-color">등록</button>
	<button onclick="" class="primary-btn reverse-btn-color">삭제</button>
</div>
</body>
</html>