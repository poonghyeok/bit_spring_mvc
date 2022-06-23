<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table{
	border-bottom: 1px solid black;
    border-top: 1px solid black;
	width : 50%;
	margin : auto;
    border-collapse: collapse;
}
th,tr,td{
	border-bottom: 1px solid black;
    border-top: 1px solid black;
}
h3{
text-align: center;
}
</style>
</head>
<body>
<h3>회원목록</h3>
<img alt="writeFormImg" src="../img/img1.png" style="align-content: center; width: 50px; cursor: pointer; display: inline;" id="imgRoot">
<table id = "userTable" name = "userTable">
 	<tr>
 	<th>이름</th>
 	<th>아이디</th>
 	<th>비밀번호</th>
 	</tr>
</table>
</body>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="../js/userList.js"></script>

</html>