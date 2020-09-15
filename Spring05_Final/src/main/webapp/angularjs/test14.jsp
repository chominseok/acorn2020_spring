<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/angularjs/test14.html</title>
<script src="../resources/js/angular.min.js"></script>
<script>
	var myApp=angular.module("myApp", []);
	// _starbucks 라는 이름의 서비스 만들고 등록하기
	myApp.service("_starbucks", function(){
		this.getCoffee=function(){
			return "아메리카노";
		};
		this.getBread=function(){
			return "샌드위치";
		};
	});
	
	// one 이라는 이름의 컨트롤러
	myApp.controller("one", function($scope, _starbucks){
		$scope.onClicked=function(){
			$scope.result=_starbucks.getCoffee();
		};
	});
	// two 라는 이름의 컨트롤러
	myApp.controller("two", function($scope, _starbucks){
		$scope.onClicked=function(){
			$scope.result=_starbucks.getBread();
		};
	});
</script>
</head>
<body ng-app="myApp">
	<div ng-controller="one">
		<button ng-click="onClicked()">커피 먹고 싶다</button>
		<p>{{result}}</p>
	</div>
	<div ng-controller="two">
		<button ng-click="onClicked()">샌드위치 먹고 싶다</button>
		<p>{{result}}</p>
	</div>
</body>
</html>