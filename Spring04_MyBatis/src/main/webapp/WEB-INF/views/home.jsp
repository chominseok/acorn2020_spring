<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>인덱스 페이지 입니다.</h1>
		
		<ul>
			<li><a href="member/list.do">회원 목록 보기</a></li>
			<li><a href="todo/list.do">할 일 목록 보기</a></li>
			<li><a href="json01.do">json 응답01</a></li>
			<li><a href="json02.do">json 응답02</a></li>
			<li><a href="json03.do">json 응답03</a></li>
			<li><a href="json04.do">json 응답04</a></li>
			<li><a href="json05.do">json 응답05</a></li>
			<li><a href="json06.do">json 응답06</a></li>
			<li><a href="json07.do">json 응답07</a></li>
			<li><a href="json08.do">json 응답08</a></li>
			<li><a href="xml01.do">xml 응답 01</a></li>
			<li><a href="xml02.do">xml 응답 02</a></li>
			<li><a href="xml03.do">xml 응답 03</a></li>
		</ul>
		<button class="btn btn-outline-info" id="testBtn">ajax 테스트</button>
		<hr>
		<h2>file upload test</h2>
		<form action="upload.do" method="post" enctype="multipart/form-data">
			<input type="file" name="myFile"/>
			<button type="submit">업로드</button>
		</form>
	</div>
</body>
<script>
	$('#testBtn').on('click',function(){
		$.ajax({
			url : "json06.do",
			method : "get",
			success : function(data){
				//data는 plain object or array 이다.
				console.log(data);
				
				for(var i = 0; i < data.length; i++){
					console.log(data[i]);
				}
			}
		});
	});
</script>
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