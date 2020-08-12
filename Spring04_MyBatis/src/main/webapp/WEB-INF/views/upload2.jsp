<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일 업로드 결과</h1>
	<p>제목 : ${dto.title }</p>
	<p>원본 파일명 : ${dto.orgFileName }</p>
	<p>저장된 파일명 : ${dto.saveFileName }</p>
	<p>파일 크기 : ${dto.fileSize }</p>
</body>
</html>