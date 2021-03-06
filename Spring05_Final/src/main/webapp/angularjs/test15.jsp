<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html ng-app="myApp">
<head>
<meta charset="UTF-8">
<title>/angularjs/test15.html</title>
<link rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/4.0.0/animate.min.css"/>
<style>
	/* in-animation 클래스를 가지고 있는 요소가 만들어질때 적용할 애니매이션 */
	.in-animation.ng-enter{
		animation: bounceInDown 1s ease-out;
	}
	/* out-animation 클래스를 가지고 있는 요소가 제거될때 적용할 애니메이션*/
	.out-animation.ng-leave{
		animation: bounceOutRight 1s linear;
	}
</style>    
<script src="../resources/js/angular.min.js"></script>
<script src="../resources/js/angular-animate.min.js"></script>
<script>
	var myApp=angular.module("myApp", ["ngAnimate"]);
	
	myApp.controller("one", function($scope){
		$scope.msgList=[];
		$scope.addClicked=function(){
			$scope.msgList.push({msg:$scope.inputMsg});
		};
	});
</script>
</head>
<body ng-controller="one">
	<h1>ngAnimate 테스트</h1>
	<input type="checkbox" ng-model="isMake"/><br/>
	<img class="in-animation out-animation" src="../resources/images/kim1.png" 
		ng-if="isMake" />
	<h1>ul 에 메세지 추가 하기</h1>
	<input type="text" ng-model="inputMsg" placeholder="메세지 입력..."/>
	<button ng-click="addClicked()">추가</button>
	<ul>
		<li class="in-animation" ng-repeat="tmp in msgList">{{tmp.msg}}</li>
	</ul>
</body>
</html>
