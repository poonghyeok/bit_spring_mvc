<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>스프링 서블릿 MVC 성적 구하기 !</h3>
<form name = "sumForm" id="sumForm" action="http://localhost:8080/chapter06_1/sungJuk/result.do" method="post">
	<fieldset>
		<legend> 입력 및 계산</legend>
			이름 : <input type="text" id = "name" name="name">
			국어 : <input type="text" id = "kor" name="kor">
			영어 : <input type="text" id = "eng" name="eng">
			수학 : <input type="text" id = "math" name="math">
			<input type="submit" value="계산하기">
	</fieldset>
</form>

</body>
</html>