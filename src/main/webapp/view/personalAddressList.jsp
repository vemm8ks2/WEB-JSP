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
				<%-- <input 
					type="hidden" 
					name="addr-info"
					data-addr-id="${dto.getShippingAddressId()}" 
					data-addr-dest="${dto.getShippingAddressDestination()}" 
				/> --%>
				<tr align="center">
					<td> 
						<input 
							type="radio" 
							name="addr-info"
							value="${dto.getShippingAddressId()}"
							<c:if test="${dto.getShippingAddressIsDefault() eq 'Y'}">checked</c:if> 
						/>
					</td>
					
					<td>
						<p>${dto.getShippingAddressDestination()}</p>
					</td>
					<td>
						<button 
							name="modify-btn" 
							data-addr-id="${dto.getShippingAddressId()}" 
							class="primary-btn reverse-btn-color"
						>
							수정
						</button>
						<button 
							name="delete-btn"
							data-addr-id="${dto.getShippingAddressId()}" 
							class="primary-btn reverse-btn-color"
						>
							삭제
						</button>
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
	
	<form method="POST" action="createShippingAdddressDestination.do" style='margin-top:20px;'>
		<h3>새 배송지 추가</h3>
		<div style='display:flex;'>
			<label>새로운 배송지 주소</label>
			<input name="new-shipping-address-destination" style='border: 1px solid #ccc;' />
		</div>
		<button class="primary-btn reverse-btn-color">등록</button>
	</form>
	
	<form method="POST" action="modifyShippingAdddressDestination.do" style='margin-top:20px;'>
		<input type="hidden" name="shipping-address-id" value="" />
		
		<h3>기존 배송지 수정</h3>
		<div style='display:flex;'>
			<label>기존 배송지 주소</label>
			<input name="prev-shipping-address" style='border: 1px solid #ccc' />
		</div>
		<div style='display:flex;'>
			<label>수정 배송지 주소</label>
			<input name='modified-shipping-address-destination' style='border: 1px solid #ccc' />
		</div>
		<button class="primary-btn reverse-btn-color">수정</button>
	</form>
</div>
</body>
</html>