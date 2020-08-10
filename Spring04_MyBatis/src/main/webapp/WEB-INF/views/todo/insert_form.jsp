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
		<h1>할 일 추가하기</h1>
		<form action="insert.do" method="post">
			<div class="form-group">
				<label for="work">할 일</label>
				<input type="text" id="work" name="work"/>
			</div>
			<button type="submit">추가</button>
		</form>
	</div>
</body>
</html>