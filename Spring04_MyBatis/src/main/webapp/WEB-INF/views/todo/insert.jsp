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
		<a href="list.do">돌아가기</a>
		<h1>할 일이 추가되었습니다</h1>
		<table>
			<thead>
				<tr>
					<th>할 일</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${dto.work }</td>
				</tr>
			</tbody>
		</table>
	</div>
</body>
</html>