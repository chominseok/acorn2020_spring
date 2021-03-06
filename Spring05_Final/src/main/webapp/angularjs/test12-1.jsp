<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/angularjs/test12.html</title>
<link rel="stylesheet" href="../resources/css/bootstrap.css" />
<script src="../resources/js/angular.min.js"></script>
<script>
	var cafeApp=angular.module("cafeApp", []);
	cafeApp.controller("cafeCtrl", function($scope, $http){
		//페이지 로딩되는 시점에 실행되는 영역
		$scope.pageNum=1;
		
		//ajax 로 카페 글 목록을 요청
		$http({
			url:"/spring05/cafe/ajax_list.do",
			method:"get",
			params:{pageNum:$scope.pageNum}
		}).success(function(data){
			console.log(data);
			$scope.list=data.list;
			$scope.paging = data.paging;
			
			var pageNums = [];
			
			for(var i = $scope.paging.startPageNum; i <= $scope.paging.endPageNum; i++){
				pageNums.push(i);
			}			
			$scope.pageNums = pageNums;
		});
		
		$scope.getPage= function(num){
			//인자로 전달된 페이지 번호
			$scope.pageNum=num;
			
			//ajax 로 카페 글 목록을 요청
			$http({
				url:"/spring05/cafe/ajax_list.do",
				method:"get",
				params:{pageNum:$scope.pageNum}
			}).success(function(data){
				console.log(data);
				$scope.list=data.list;
				$scope.paging = data.paging;
				
				var pageNums = [];
				
				for(var i = $scope.paging.startPageNum; i <= $scope.paging.endPageNum; i++){
					pageNums.push(i);
				}			
				$scope.pageNums = pageNums;
			});
		};
	});
</script>
</head>
<body ng-app="cafeApp">
	<div class="container" ng-controller="cafeCtrl">
		<h1>카페 글 목록 입니다.</h1>
		<table class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>조회수</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="tmp in list">
					<td>{{tmp.num}}</td>
					<td>{{tmp.writer}}</td>
					<td>{{tmp.title}}</td>
					<td ng-bind="tmp.viewCount"></td>
					<td ng-bind="tmp.regdate"></td>
				</tr>
			</tbody>
		</table>
		<div class="page-display">
			<ul class="pagination pagination-sm">
				<li data-ng-if="paging.startPageNum != 1" 
					class="page-item">
					<a data-ng-click="getPage(paging.startPageNum-1)" class="page-link" href="#/{{paging.startPageNum-1}}">Prev</a>
				</li>
				<li data-ng-repeat="tmp in pageNums" 
						class="page-item"
						data-ng-class="{active: paging.pageNum == tmp }">
					<a data-ng-click="getPage(tmp)" class="page-link" href="#/{{tmp}}">{{tmp}}</a>
				</li>
				<li data-ng-if="paging.endPageNum < paging.totalPageCount"
					class="page-item">
					<a data-ng-click="getPage(paging.endPageNum+1)" class="page-link" href="#/{{paging.endPageNum+1}}">Next</a>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>
