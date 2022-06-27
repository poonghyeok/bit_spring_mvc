<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#imgFileInput{
	visibility: hidden;
}

#icon_camera{
	width: 30px;
	height: 30px;
	cursor: pointer;
}
</style>
</head>
<body>
	
<!-- 단순 submit , method post, method="post" enctype="multipart/form-data" 은 필수다! -->
<!-- <form action="/chapter06_SpringWebMaven/user/upload" id = "uploadForm" method="post" enctype="multipart/form-data"> -->

<!-- ajax ver -->
<form id = "uploadFormAjax" name = "uploadFormAjax">
	<fieldset>
		<legend>단순 submit</legend>
			
		<%--<input type ="file" name="img">
		<input type ="file" name="img"> --%>
		<hr>
		다수 파일 한번에 업로드 
		<img alt="icon_camera.jpg" src="../img/icon_camera.jpg" id ="icon_camera">
		<input type ="file" name="img[]" multiple="multiple" id = "imgFileInput">
		<hr>
		<input type = "button" id = "uploadBtn" value="이미지 등록">
	</fieldset>

<!-- 단순 submit -->
</form>
<div id="uploadImage"></div>

<script type="text/javascript" src="http://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript" >
	$('#uploadBtn').click(function(){
		//1.단순 submit
		/* $('#uploadForm').submit(); */
		
		 var formData = new FormData($('#uploadFormAjax')[0]); //form 안의 모든 것을 의미한다. [0]은 뭐지 
		
		//2.ajax 통신 
		$.ajax({
			type : 'post',
			url : '/chapter06_SpringWebMaven/user/upload',
			enctype : 'multipart/form-data',
			processData : false,
			contentType : false,
			data : formData,
			success : function(data){
				alert('업로드 완료 ');
				$('#uploadImage').html(data);
				
			},
			error : function(err){
				console.log(err);
			}
		})
	})
	
	$('#icon_camera').click(function(){
		$('#imgFileInput').trigger('click');	
	})

</script>
</body>
</html>