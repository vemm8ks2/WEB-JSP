<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="static/css/base.css">
  <link rel="stylesheet" href="static/css/${ requestScope.stylesheet }">
</head>

<body>
  <div id="container" class="max-w-5xl min-w-[64rem] m-auto flex flex-col min-h-screen">
  	<c:import url="header.jsp"></c:import>
    <main class="px-4 py-10 flex flex-col flex-1"> <!-- #wrapper -->
    <c:import url="${ requestScope.url }"></c:import>
    </main>
    <c:import url="footer.jsp"></c:import>
  </div>
</body>

</html>