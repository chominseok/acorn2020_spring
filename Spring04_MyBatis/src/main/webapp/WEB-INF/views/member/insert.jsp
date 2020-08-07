<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body>
	<div class="container">
		<h1>회원 추가가 완료되었습니다!</h1>
		<p>번호 : <strong>${dto.num }</strong></p>
		<p>이름 : <strong>${dto.name }</strong></p>
		<p>주소 : <strong>${dto.addr }</strong></p>
		
		<a href="list.do">돌아가기</a>
	</div>
</body>
</html>