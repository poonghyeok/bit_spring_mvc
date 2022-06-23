<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 단순 submit , method post, method="post" enctype="multipart/form-data" 은 필수다! -->
<form action="/chapter06_SpringWebMaven/user/upload" id = "uploadForm" method="post" enctype="multipart/form-data">
	<fieldset>
		<legend>단순 submit</legend>
		
		<input type ="file" name="img">
		<input type = "button" id = "uploadBtn" value="이미지 등록">
	</fieldset>


<!-- 단순 submit -->

</form>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" >
	$('#uploadBtn').click(function(){
		//1.단순 submit
		$('#uploadForm').submit();
		
		//2.ajax 통신 
	})

</script>
</body>
</html>