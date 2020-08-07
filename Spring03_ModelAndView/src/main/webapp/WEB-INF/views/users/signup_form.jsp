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
		<h1>회원 가입 폼 입니다.</h1>
		
		<form action="signup.do" method="post">
			<input type="text" name="id" placeholder="아이디를 입력하세요"/>
			<input type="text" name="pwd" placeholder="비밀번호를 입력하세요"/>
			<button type="submit">가입</button>
		</form>
		<hr>
		<h1>회원 가입 폼 입니다.</h1>
		<form action="signup2.do" method="post">
			<input type="text" name="id" placeholder="아이디를 입력하세요"/>
			<input type="text" name="pwd" placeholder="비밀번호를 입력하세요"/>
			<button type="submit">가입</button>
		</form>
		<hr>
		<h1>회원 가입 폼 입니다.</h1>
		<form action="signup3.do" method="post">
			<input type="text" name="id" placeholder="아이디를 입력하세요"/>
			<input type="text" name="pwd" placeholder="비밀번호를 입력하세요"/>
			<button type="submit">가입</button>
		</form>
	</div>
</body>
</html>