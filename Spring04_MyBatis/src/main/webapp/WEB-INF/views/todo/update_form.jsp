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
		<h1>회원 정보 수정</h1>
		<form action="update.do" method="post">
			<div class="form-group">
				<input type="hidden" id="num" name="num" value="${dto.num }"/>
				<label for="num">순위</label>
				<input type="text" id="num" value="${dto.num }" disabled/>
			</div>
			<div class="form-group">
				<label for="work">할 일</label>
				<input type="text" id="work" name="work" value="${dto.work }"/>
			</div>
			<button class="submit">수정</button>
		</form>
	</div>
</body>
</html>