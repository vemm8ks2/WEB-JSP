<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div style="display: flex; flex-direction: column; align-items: center;">
	<p>유저의 주문목록 페이지입니다.</p>
	<br>
	<p>
		[과제]<br> 로그인 된 유저의 주문목록 불러오기.<br> <br> [주문목록 페이지에
		들어오기까지 과정]<br> personalOrderListView.do 링크를 클릭 =>
		PersonalOrderListViewAction 실행 => personalOrderList.jsp 페이지로 포워딩<br>
		<br> [고민해야 할 것]<br> 유저의 주문목록 정보를 어디서, 어떻게 가져올 것인가?<br>
		<br> [절취선 아래에 유저의 주문목록 데이터를 보여주세요]<br> 예쁘게 꾸밀 필요 없이 유저의 주문목록
		데이터를 JSTL을 사용해서 보여주기만 하면 됩니다!<br> <br>
		OrderDAO에 있는 getOrderListByCustomerId()이용한 Action
		ShowAllOrderByCustomerAction 유저 페이지에서 유저 외래키를 넘겨 해당 유저의 모든 주문 목록 출력<br>
		 --- --- --- ---<br>
	</p>
	<table border="1">
		<tr>
			<th>주문 번호</th>
			<th>수취인 이름</th>
			<th>수취인 연락처</th>
			<th>수취인 주소</th>
			<th>주문 상태</th>
			<th>주문일</th>
			<th>배송완료일</th>
		</tr>

		<c:if test="${empty orderList}">
			<tr>
				<th colspan="7" align="center">주문목록이 없습니다.</th>
			</tr>
		</c:if>
		<c:forEach items="${orderList}" var="dto">
			<tr>
				<td>${dto.getOrderId()}</td>
				<td>${dto.getOrderReceiverName()}</td>
				<td>${dto.getOrderReceiverPhone()}</td>
				<td>${dto.getOrderReceiverAddr()}</td>
				<td>${dto.getOrderStatus()}</td>
				<td>${dto.getOrderCreatedAt()}</td>
				<td>${dto.getOrderDeliveredAt()}</td>
			</tr>
		</c:forEach>
	</table>

</div>