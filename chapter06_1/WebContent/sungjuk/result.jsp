<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>spring 서블릿 성적구하기 결과 !</h3>
<table style="border: 1px solid;">
	
	<%-- <tr style="text-align: center;">
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
	 --%>
	 
	<h3> ModelAttribute로 DTO Mapping 시킨 결과</h3>
	<tr style="text-align: center;">
		<th colspan="2">${sungJukDTO.getName()}님 성적</th>
	</tr>
	
	<tr>
		<td>총점</td>
		<td>${sungJukDTO.getTotal()}</td>
	</tr>
	
	<tr>
		<td>평균</td>
		<td><fmt:formatNumber pattern="#.##" value="${sungJukDTO.getAvg()}"></fmt:formatNumber></td>
		<%-- <td>${String.format("%.3f",sungJukDTO.getAvg())}</td> --%>
		 <%-- lecver(taglib사용) : <fmt:formatNumber pattern="#.##"> --%>	
	</tr>
	

</table>

</body>
</html>