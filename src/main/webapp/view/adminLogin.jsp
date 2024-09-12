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
	<div align="center">
		<form method="POST" action="adminloginOK.do">
			<table border="1">
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="login_id">
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="password" name="login_pwd">
					</td>
				</tr>
				<tr>
	            	<td colspan="2" align="center">
	               		<input type="submit" value="로그인">&nbsp;&nbsp;
	         	   		<input type="reset" value="다시작성">
	            	</td>
	         	</tr>
			</table>
		</form>	
		<c:if test="${isValid == false}">
		<p>아이디 혹은 비밀번호가 틀렸습니다.</p>
		</c:if>
	</div>
</body>
</html>