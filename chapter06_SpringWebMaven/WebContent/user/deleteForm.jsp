<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>회원 삭제 하기 </h3>
<form name = "deleteForm" id="deleteForm" action="#">
	<fieldset>
		<legend>회원 검색</legend>
			<img alt="writeFormImg" src="../img/img1.png" style="width: 50px; cursor: pointer; display: block;" id="imgRoot">
			
			삭제할 아이디 : <input type="text" id = "id" name="id">
			<input type="button" value="검색하기" id="searchButton">
			
	</fieldset>
</form>
<div id="idDiv"></div>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../js/deleteUser.js"></script>

</body>
</html>