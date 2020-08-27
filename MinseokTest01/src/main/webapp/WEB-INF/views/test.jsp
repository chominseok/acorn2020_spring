<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>project db연동 테스트 입니다.</h1>
	
	<table border="1">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>사는곳</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="tmp" items="${list }">
				<tr>
					<td>${tmp.num }</td>
					<td>${tmp.name }</td>
					<td>${tmp.addr }</td>				
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>