<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
					<td><input type="button" value="수정" onclick=""></td>
				</tr>
			</c:forEach>
		</c:if>

		<c:if test="${empty list}">
			<tr>
				<th colspan="3">등록된 주소지가 없습니다.</th>
			</tr>
		</c:if>		
	</table><br>
	<input type="button" value="저장" onclick="">
	<input type="button" value="등록" onclick="">
	<input type="button" value="삭제" onclick="">
</div>
</body>
</html>