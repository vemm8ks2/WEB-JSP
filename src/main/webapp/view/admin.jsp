<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html lang="ko">

<%--
	TODO: 어드민 페이지에 들어왔을 경우 어드민 계정으로 로그인을 하게끔 하고 로그인에 성공하면 어드민 페이지를 반환해준다.	
--%>
<head>
  <meta charset="UTF-8" />
  <link rel="icon" type="image/svg+xml" href="/vite.svg" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Vite + React + TS</title>
  <script type="module" crossorigin src="static/admin/admin-index.min.js"></script>
  <link rel="stylesheet" crossorigin href="static/admin/admin-index.css">
</head>

<body>
  <div id="root"></div>
  <script type="text/javascript">
  	if (!location.hash) location.href = 'admin#/WEB-JSP/admin/dashboard'; 
  	else location.href = 'admin' + location.hash;
  </script>
</body>

</html>