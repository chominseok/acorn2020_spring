<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>인덱스 페이지 입니다.</h1>
	<p>Spring Framework 동작중....</p>
	
	<li><a href="${pageContext.request.contextPath }/fortune.nhn">오늘의 운세보기</a></li>
	<li><a href="${pageContext.request.contextPath }/friend.nhn">친구 목록 보기</a></li>
</body>
</html>