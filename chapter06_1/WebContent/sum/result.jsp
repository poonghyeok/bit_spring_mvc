<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Result </title>
</head>
<body>
	<!-- 여기 x, y 어떻게 받지 -->
	<h3> Controller 를 타고 넘어온 결과 </h3>
	<c:set var="x" value='${result.get("x")}'></c:set> 
	<c:set var="y" value='${result.get("y")}'></c:set> 
	<c:set var="sum" value='${ x + y }'></c:set>
	결과 : ${x} + ${y} = ${sum}
	
</body>
</html>