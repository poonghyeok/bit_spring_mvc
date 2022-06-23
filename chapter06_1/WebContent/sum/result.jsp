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
	<c:set var="x" value='${param.x}'></c:set> 
	<c:set var="y" value='${param.y}'></c:set> 
	<c:set var="sum" value='${ x + y }'></c:set>
	<%-- 결과 : ${x} + ${y} = ${sum}  --%>
	<%-- 결과 : ${calc.get("x")} + ${calc.get("y")} = ${calc.get("x") + calc.get("y")} --%>  
	
	<%-- DTO를 Model 객체에 넣어준 경우 :  결과 : ${sumDTO.x} + ${sumDTO.y} = ${sumDTO.x + sumDTO.y} --%>
	RequestParam으로 map에 넣어주고 map을 ModelMap 객체에 넣어준 경우
	<hr>
	public String result(@RequestParam Map map, ModelMap modelMap ) { <br>
	
	결과 : ${calc.get("x")} + ${calc.get("y")} = ${calc.get("x") + calc.get("y")}
	

</body>
</html> 	