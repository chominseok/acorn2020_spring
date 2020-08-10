<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />
</head>
<body>
	<div class="container">
		<a class="btn btn-outline-primary"href="insert_form.do">할 일 추가</a>
		<h1>할 일 목록</h1>
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<th>순위</th>
					<th>할 일</th>
					<th>날 ㅉㅏ</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tmp" items="${list }">
					<tr>
						<td>${tmp.num }</td>
						<td>${tmp.work }</td>
						<td>${tmp.regdate }</td>
						<td><a href="update_form.do?num=${tmp.num }">수정</a></td>
						<td><a href="delete.do?num=${tmp.num }">삭제</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>