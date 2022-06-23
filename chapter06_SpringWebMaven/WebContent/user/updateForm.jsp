<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
<h3>회원정보 수정하기 </h3>
<form name = "updateForm" id="updateForm" action="#">
	<fieldset>
		<legend>회원 검색</legend>
			<img alt="writeFormImg" src="../img/img1.png" style="width: 50px; cursor: pointer; display: block;" id="imgRoot">
			
			수정할 아이디 : <input type="text" id = "id" name="id">
			<input type="button" value="검색하기" id="searchButton">
			
	</fieldset>
</form>
<div id="idDiv"></div>
<form name = "dynamicUpdateForm" id="dynamicUpdateForm" action="#">
	<h4>회원정보 수정 폼</h4>
	<fieldset>
		<legend>회원가입</legend>
			이름 : <input type="text" id = "dynamicName" name="dynamicName">
			<div id="dynamicNameDiv"></div>
			
			아이디 : <input type="text" id = "dynamicId" name="dynamicId" readonly>
			<div id="dynamicIdDiv"></div>
			
			비밀번호 : <input type="password" id = "dynamicPwd" name="dynamicPwd">
			<div id="dynamicPwdDiv"></div>
			
			<input type="button" value="수정하기" id="dynamicUpdateButton">
			<input type="button" value="다시작성" id="dynamicResetButton">
	</fieldset>
</form>


<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../js/updateUser.js"></script>

</body>
</html>