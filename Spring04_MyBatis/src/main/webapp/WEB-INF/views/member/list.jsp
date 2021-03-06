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
	<a class="btn btn-outline-info" href="insertform.do">회원 추가 폼</a>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>주소</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
					<c:forEach var="tmp" items="${list}">
						<tr>
							<td>${tmp.num }</td>
							<td>${tmp.name }</td>
							<td>${tmp.addr }</td>
							<td><a href="update_form.do?num=${tmp.num }">수정</a></td>
							<td><a href="delete.do?num=${tmp.num }">삭제</a></td>
						</tr>
					</c:forEach>		
			</tbody>
		</table>
	</div>
</body>
</html>