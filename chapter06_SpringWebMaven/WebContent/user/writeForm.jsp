<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Spring 회원가입 Maven</h3>
<form name = "writeForm" id="writeForm" action="#">
	<fieldset>
		<legend>회원가입</legend>
			<img alt="writeFormImg" src="../img/img1.png" style="width: 50px; cursor: pointer; display: block;" id="imgRoot">
			이름 : <input type="text" id = "name" name="name">
			<div id="nameDiv"></div>
			
			아이디 : <input type="text" id = "id" name="id">
			<div id="idDiv"></div>
			
			비밀번호 : <input type="password" id = "pwd" name="pwd">
			<div id="pwdDiv"></div>
			
			<input type="button" value="회원가입" id="writeButton">
			<input type="submit" value="제출">
			<input type="reset" value="다시작성" >
	</fieldset>
</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../js/user.js"></script>

</body>
</html>