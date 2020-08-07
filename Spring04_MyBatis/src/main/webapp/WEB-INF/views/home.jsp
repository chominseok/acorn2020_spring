<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resource/css/bootstrap.css" />
</head>
<body>
	<div class="container">
		<h1>인덱스 페이지 입니다.</h1>
		
		<ul>
			<li><a href="member/list.do">회원 목록 보기</a></li>
		</ul>
	</div>
</body>
</html>

<!-- 
client .do >>     tomcat webserver > [dispacher servlet]
    l   						<1 , 2 .... 순서에 상관 없이 교차해서, 여러개 사용 가능>
	l						controller1 service1 dao1
	l						
	l						controller2 service2 dao2
	l							l
	l		forward				l
	ㅡㅡㅡ<	viewpage		<ㅡㅡㅡl
			(xxx.jsp)

			or redirect
 -->