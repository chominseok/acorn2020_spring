<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body>
	<div class="container">
		<a href="#" class="btn btn-outline-info">로그인</a>
		<a href="${pageContext.request.contextPath }/users/signup_form.do" class="btn btn-outline-primary">회원가입</a>
		<h1>test 시작합니다.</h1>
		<a href="${pageContext.request.contextPath }/test.do">db 연동 테스트</a>
	</div>
	
</body>
</html>