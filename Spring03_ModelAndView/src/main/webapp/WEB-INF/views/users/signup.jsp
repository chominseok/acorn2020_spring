<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p><strong>${param.id }</strong>님 회원가입이 완료되었습니다.</p>
	<p>비밀번호는 ${param.pwd } ㅎㅎㅎㅎㅎㅎㅎㅎ</p>
	<a href="${pageContext.request.contextPath }/home.do">인덱스</a>
</body>
</html>