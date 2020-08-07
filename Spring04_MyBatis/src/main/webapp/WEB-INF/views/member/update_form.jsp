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
		<h1>회원 수정 폼 입니다.</h1>
		<form action="update.do" method="post">
			<div class="form-group">
				<input type="hidden" name="num" value="${dto.num }" id="num"/>
				<label for="num">번호</label>
				<input class="form-control" type="text" id="num" value="${dto.num }" disabled/>
			</div>
			<div class="form-group">
				<label for=name>이름</label>
				<input class="form-control" type="text" id="name" name="name" value="${dto.name }"/>
			</div>
			
			<div class="form-group">
				<label for="addr">주소</label>
				<input class="form-control" type="text" id="addr" name="addr" value="${dto.addr }"/>
			</div>
			<button type="submit" class="btn btn-outline-primary">수정하기</button>
			<button type="reset" class="btn btn-outline-danger">취소하기</button>
		</form>
	</div>
</body>
</html>