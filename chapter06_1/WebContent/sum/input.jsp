<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 강사님 : response body로 사용하겠어요~ -->
<h3>스프링 MVC 합 구하기 !</h3>
<form name = "sumForm" id="sumForm" action="http://localhost:8080/chapter06_1/result.do">
	<fieldset>
		<legend> 입력 및 계산</legend>
			X : <input type="text" id = "getX" name="x">
			Y : <input type="text" id = "getY" name="y">
			<input type="submit" value="계산하기">
	</fieldset>
</form>

 
</body>
</html>