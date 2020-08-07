<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- <link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" /> --%>
<link rel="stylesheet" href="resources/css/bootstrap.css" />
<!-- home.jsp를 index로 지정해놨기 때문에 webapp에 있는것으로 간주된다. -->
</head>
<body>
	<div class="container">
		<h1>인덱스 페이지 입니다.</h1>
		<ul>
			<!--.do를 사용하지 않는건 spring framework를 사용하지 않는것과 같다.
			   =>> WEBAPP에 넣어두면 된다. (보통 JS, CSS, IMAGE파일을 넣어둔다[resources])  -->
			<li><a href="test/play.html">spring과 컨트롤러를 거치지 않는 요청</a></li>
			<li><a href="test/game.jsp">spring과 컨트롤러를 거치지 않는 요청2</a></li>
			<li><a href="friends.do">오늘의 인물 보기</a></li>
			<li><a href="friends2.do">친구 목록 보기2</a></li>
			<li><a href="friends3.do">친구 목록 보기3</a></li>
			<!-- request에 담지 못하는데 언제 redirect 이동? -->
			<li><a href="delete.do">친구 정보 삭제 redirect 이동1</a></li>
			<li><a href="delete2.do">친구 정보 삭제 redirect 이동2</a></li>
			<li><a href="users/signup_form.do">회원 가입 폼</a></li>
			<li><a href="users/test.do">테스트 회원 가입 폼</a></li>
			
		</ul>
		
		<ul>
			<c:forEach var="tmp" items="${list }">
				<li>${tmp }</li>
			</c:forEach>
		</ul>
		
	</div>
</body>
</html>