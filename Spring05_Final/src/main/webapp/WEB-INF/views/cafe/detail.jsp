<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/cafe/detail.jsp</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css" />

<style>
	/* 글 내용을 출력할 div 에 적용할 css */
	.contents{
		width: 100%;
		border: 1px dotted #cecece;
	}
	/* 댓글 프로필 이미지를 작은 원형으로 만든다. */
	#profileImage{
		width: 50px;
		height: 50px;
		border: 1px solid #cecece;
		border-radius: 50%;
	}
	/* ul 요소의 기본 스타일 제거 */
	.comments ul{
		padding: 0;
		margin: 0;
		list-style-type: none;
	}
	.comments dt{
		margin-top: 5px;
	}
	.comments dd{
		margin-left: 50px;
	}
	.comment_form textarea, .comment_form button, 
		.comment-insert-form textarea, .comment-insert-form button, .comment-update-form textarea{
		float: left;
	}
	.comments li{
		clear: left;
	}
	.comments ul li{
		border-top: 1px solid #888;
	}
	.comment_form textarea, .comment-insert-form textarea, .comment-update-form textarea{
		width: 85%;
		height: 100px;
	}
	.comment_form button, .comment-insert-form button, .comment-update-form button{
		width: 15%;
		height: 100px;
	}
	.comments form{
		display : none;
	}
	.comments li{
		position : relative;
	}
	
	.comments .reply_icon{
		position : absolute;
		top : 30px;
		left : 20px;
	}
	pre {
	  display: block;
	  padding: 9.5px;
	  margin: 0 0 10px;
	  font-size: 13px;
	  line-height: 1.42857143;
	  color: #333333;
	  word-break: break-all;
	  word-wrap: break-word;
	  background-color: #f5f5f5;
	  border: 1px solid #ccc;
	  border-radius: 4px;
	}
	
	.contents img{
		max-width : 100%;
	}
</style>
</head>
<body>
<div class="container">
	<c:if test="${not empty keyword }">
		<p class="alert alert-info">
			<strong>${keyword }</strong> 라는 키워드로 검색한 결과에 대한 
			자세히 보기 입니다.
		</p>
	</c:if>

	<c:if test="${dto.prevNum ne 0 }">
		<a class="btn btn-outline-info btn-sm" href="detail.do?num=${dto.prevNum }&condition=${condition}&keyword=${encodedK}">
			<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-chevron-up" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  					<path fill-rule="evenodd" d="M7.646 4.646a.5.5 0 0 1 .708 0l6 6a.5.5 0 0 1-.708.708L8 5.707l-5.646 5.647a.5.5 0 0 1-.708-.708l6-6z"/>
			</svg>
			이전글
		</a>	
	</c:if>
	<c:if test="${dto.nextNum ne 0 }">
		<a class="btn btn-outline-info btn-sm" href="detail.do?num=${dto.nextNum }&condition=${condition}&keyword=${encodedK}">
			<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-chevron-down" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  				<path fill-rule="evenodd" d="M1.646 4.646a.5.5 0 0 1 .708 0L8 10.293l5.646-5.647a.5.5 0 0 1 .708.708l-6 6a.5.5 0 0 1-.708 0l-6-6a.5.5 0 0 1 0-.708z"/>
			</svg>
			다음글
		</a>	
	</c:if>
	<h1>글 상세 페이지</h1>
	<table>
		<tr>
			<th>글번호</th>
			<td>${dto.num }</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${dto.writer }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${dto.title }</td>
		</tr>
		<tr>
			<th>등록일</th>
			<td>${dto.regdate }</td>
		</tr>
	</table>
	<div class="contents">${dto.content }</div>
	<a class="btn btn-outline-primary" href="list.do">목록 보기</a>
	
	<c:if test="${dto.writer eq id }">
		<a class="btn btn-outline-warning btn-sm" href="private/updateform.do?num=${dto.num }">
			<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-pencil-square" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  				<path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456l-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
  				<path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
			</svg>
			수정
		</a>
		<a class="btn btn-outline-danger btn-sm" href="javascript:deleteConfirm();">
			<svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-trash-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  				<path fill-rule="evenodd" d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5a.5.5 0 0 0-1 0v7a.5.5 0 0 0 1 0v-7z"/>
			</svg>
			삭제
		</a>			
	</c:if>
	
	<!-- 댓글 목록 -->
	<div class="comments">
		<ul>
			<c:forEach var="tmp" items="${commentList }">
				<c:choose>
					<c:when test="${tmp.deleted eq 'yes' }">
						<c:if test="${tmp.num ne tmp.comment_group }">
							<li style="padding-left:100px; padding-top : 10px;">
								<pre style="color:red;">삭제된 댓글입니다.</pre>
							</li>
						</c:if>
						<c:if test="${tmp.num eq tmp.comment_group }">
							<li style="padding-left:50px; padding-top : 10px;">
								<pre style="color:red;">삭제된 댓글입니다.</pre>
							</li>
						</c:if>
					</c:when>
					<c:otherwise>
						<li id="comment${tmp.num }" <c:if test="${tmp.num ne tmp.comment_group }">style="padding-left:50px"</c:if> >
							<c:if test="${tmp.num ne tmp.comment_group }">
								<svg class="reply_icon" width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-arrow-return-right" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
			  						<path fill-rule="evenodd" d="M10.146 5.646a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-3 3a.5.5 0 0 1-.708-.708L12.793 9l-2.647-2.646a.5.5 0 0 1 0-.708z"/>
			  						<path fill-rule="evenodd" d="M3 2.5a.5.5 0 0 0-.5.5v4A2.5 2.5 0 0 0 5 9.5h8.5a.5.5 0 0 0 0-1H5A1.5 1.5 0 0 1 3.5 7V3a.5.5 0 0 0-.5-.5z"/>
								</svg>
							</c:if>
							<dl>
								<dt>
									<c:choose>
										<c:when test="${empty tmp.profile }">
											<svg id="profileImage"  width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-person-fill" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
					  							<path fill-rule="evenodd" d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z"/>
											</svg>
										</c:when>
										<c:otherwise>
											<img id="profileImage" 
												src="${pageContext.request.contextPath }${tmp.profile }"/>
										</c:otherwise>
									</c:choose>
									<span>${tmp.writer }</span>
									<c:if test="${tmp.num ne tmp.comment_group }">
										@<strong>${tmp.target_id }</strong>
									</c:if>
									<span>${tmp.regdate }</span>
									<a href="javascript:" class="reply_link btn btn-outline-primary">답글</a>
									<c:if test="${id eq tmp.writer}">
<%-- 									updateComment(${tmp.num }); --%>
										<a href="javascript:" class="update_comment btn btn-outline-info">수정</a>
										<a class="btn btn-outline-danger" href="javascript:deleteComment(${tmp.num });">삭제</a>
									</c:if>
								</dt>
								<dd>
									<pre>${tmp.content }</pre>
								</dd>
							</dl>
							
							<!-- 리플달기 폼 -->
							<form class="comment-insert-form" 
								action="private/comment_insert.do" method="post">
								<input type="hidden" name="ref_group"
									value="${dto.num }"/>
								<input type="hidden" name="target_id"
									value="${tmp.writer }"/>
								<input type="hidden" name="comment_group"
									value="${tmp.comment_group }"/>
								<textarea name="content"></textarea>
								<button type="submit">등록</button>
							</form>
							
							<!-- 댓글 수정하기 폼 -->
							<form class="comment-update-form" 
								action="private/comment_update.do" method="post">
								<input type="hidden" name="ref_group"
									value="${dto.num }"/>
								<input type="hidden" name="num"
									value="${tmp.num }"/>
								<textarea name="content">${tmp.content }</textarea>
								<button type="submit">수정</button>
							</form>
						</li>
					</c:otherwise>
				</c:choose> 
			
				
			</c:forEach>
		</ul>
	</div>
	
	<div class="comment_form">
		<!-- 원글에 댓글을 작성하는 form -->
		<form action="private/comment_insert.do" method="post">
			<!-- 원글의 글번호가 ref_group 번호가 된다. -->
			<input type="hidden" name="ref_group" value="${dto.num }"/>
			<!-- 원글의 작성자가 댓글의 수신자가 된다. -->
			<input type="hidden" name="target_id" value="${dto.writer }"/>
			<textarea name="content"><c:if test="${empty id }">로그인이 필요합니다</c:if></textarea>
			<button type="submit">등록</button>
		</form>
	</div>
	
</div>
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.5.1.js"></script>
<script src="https://cdn.jsdelivr.net/gh/jquery-form/form@4.3.0/dist/jquery.form.min.js" integrity="sha384-qlmct0AOBiA2VPZkMY3+2WqkHtIQ9lSdAsAn5RUJD/3vA5MKDgSGcdmIv4ycVxyn" crossorigin="anonymous"></script>
<!-- ajax form plugin은 jquery를 의존하고 있으므로 jqeury를 로딩 시키고 명시해줘야한다. -->
<script>
	$('.update_comment').on('click',function(){
		$(this).parent().parent().parent().find('.comment-update-form').slideToggle();
		if($(this).text() == '수정'){
			$(this).text('수정 취소');
		}else{
			$(this).text('수정');
		}
	});

	//수정하기 ajax form pulgin으로 사용하기
// 	$(".comment-update-form").ajaxForm(function(data){
// 		console.log(data);
// 		//li에 id를 부여하여 form을 닫게한다.
// 		var selector = "#comment"+data.num;  //ex)"#comment6"
// 		$(selector).find('.comment-update-form').slideUp();
	
// 		//pre 요소에 출력된 내용 수정하기
// 		$(selector).find('pre').text(data.content);
// 	});

	$(".comment-update-form").on('submit',function(){
		var isUpdate = confirm("수정하시겠습니까?");
		
		var method = $(this).attr('method');
		var action = $(this).attr('action');
		var query = $(this).serialize();
		
		if(isUpdate){
			$.ajax({
				method : method,
				url : action,
				data : query,
				success : function(data){
					//li에 id를 부여하여 form을 닫게한다.
					var selector = "#comment"+data.num;
					$(selector).find('.comment-update-form').slideUp();
					//pre 요소에 출력된 내용 수정하기
					$(selector).find('pre').text(data.content); 
				}
				
			});
		}
		return false;
	});
	
	
	//기존 수정 폼
// 	$(".comment-update-form").on("submit", function(){
// 		var isUpdate = confirm("수정하시겠습니까?");
// 		if(!isUpdate){
// 			return false;
// 		}
// 	});
	
	
	
	function deleteComment(num){
		var isDelete = confirm("삭제하시겠습니까?");
		if(isDelete){
			location.href="${pageContext.request.contextPath}/cafe/private/comment_delete.do?num="+num+"&ref_group=${dto.num}";
		}
	}

	//답글 달기 링크 클릭 시 실행할 함수 등록
	$('.reply_link').on('click',function(){
		var isLogin=${not empty id};
		if(isLogin == false){
			alert("로그인 페이지로 이동합니다.")
			location.href="${pageContext.request.contextPath }/users/loginform.do?"+
					"url=${pageContext.request.contextPath }/cafe/detail.do?num=${dto.num}";		
		}
		
		$(this).parent().parent().parent().find('.comment-insert-form').slideToggle();
		if($(this).text() == '답글'){
			$(this).text('접기');
		}else{
			$(this).text('답글');
		}
	});

	$(".comment_form form").on("submit", function(){
		//로그인 여부
		var isLogin=${not empty id};
		if(isLogin == false){
			alert("로그인 페이지로 이동합니다.")
			location.href="${pageContext.request.contextPath }/users/loginform.do?"+
					"url=${pageContext.request.contextPath }/cafe/detail.do?num=${dto.num}";
			return false; //폼 전송 막기 		
		}
	});

</script>
</body>
</html>