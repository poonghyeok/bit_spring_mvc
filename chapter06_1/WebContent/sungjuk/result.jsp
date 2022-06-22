<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>spring 서블릿 성적구하기 결과 !</h3>
<table>
	
	<tr style="text-align: center;">
		<th colspan="2">${result.get("name")}님 성적</th>
	</tr>
	
	<tr>
		<td>총점</td>
		<td>${result.get("total")}</td>
	</tr>
	
	<tr>
		<td>평균</td>
		<td>${result.get("avg")}</td>
	</tr>
	

</table>

</body>
</html>