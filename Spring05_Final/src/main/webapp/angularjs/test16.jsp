<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html ng-app="myApp">
<head>
<meta charset="UTF-8">
<title>/angularjs/test16.html</title>
<script src="../resources/js/angular.min.js"></script>
<script>
	var myApp=angular.module("myApp", []);
	
	myApp.controller("one", function($scope){
		$scope.template={name:"myTemplate", url:"include/header.html"};
	});	
</script>
</head>
<body ng-controller="one">
	<h1>include 테스트</h1>
	<div ng-include="template.url"></div>
</body>
</html>
