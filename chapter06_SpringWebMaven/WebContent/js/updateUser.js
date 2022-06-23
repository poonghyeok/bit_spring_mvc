/**
 * 
 */
$(function(){
	$('#dynamicUpdateForm').hide();
})

$('#imgRoot').click(function(){
	location.href = "/chapter06_SpringWebMaven";
})

$('#searchButton').click(function(){
	$('#idDiv').empty();
	if($('#id').val()){
		$.ajax({
			type : 'post',
			url : '/chapter06_SpringWebMaven/user/getUser',
			data : {id : $('#id').val()},
			success : function(data){
				if(data == ''){
					$('#idDiv').html('검색한 아이디는 존재하지 않습니다.');
					$('#idDiv').attr('style','background-color:yellow; color:blue;');
				}else{
					$('#dynamicName').val(data.name);
					$('#dynamicId').val(data.id);
					$('#dynamicPwd').val(data.pwd);
					$('#dynamicUpdateForm').show();
				}
			},
			error : function(err){
				console.log(err);
			}
		})
	}else{
		$('#idDiv').html('아이디를 먼저 입력해주세요');
		$('#idDiv').attr('style','background-color:yellow; color:blue;');
}
})

$('#dynamicResetButton').on('click', function(){
	if(confirm('수정된 정보가 초기화 됩니다 정말 초기화 하시겠습니까?')){
		$('#searchButton').trigger('click');
	}
	/*if(confirm('수정된 정보가 초기화 됩니다 정말 초기화 하시겠습니까?')){
		$.ajax({
			type : 'post',
			url : '/chapter06_SpringWebMaven/user/getUser',
			data : {id : $('#id').val()},
			dataType : 'json',
			success : function(data){
				$('#dynamicName').val(data.name);
				$('#dynamicId').val(data.id);
				$('#dynamicPwd').val(data.pwd);
			},
			error : function(err){
				console.log(err);
			}
		})
	}*/
})

$('#dynamicUpdateButton').on("click", function(){
	console.log('updateButtonClicked..!');
	$('#dynamicNameDiv').empty();
	$('#dynamicIdDiv').empty();
	$('#dynamicPwdDiv').empty();
	
	/*왜 .is(:empty) 는 먹히지 않는가.*/
	if( !$('#dynamicName').val()){
		$('#dynamicNameDiv').html('이름을 입력해주세요 !');
		$('#dynamicNameDiv').attr("style", 'background-color:yellow; color:red');
	
	}else if( !$('#dynamicId').val()){
		$('#dynamicIdDiv').html('아이디를 입력해주세요 !');
		$('#idynamicIdDiv').attr("style", 'background-color:yellow; color:red;');
	
	}else if( !$('#dynamicPwd').val()){
		$('#dynamicPwdDiv').html('비밀번호를 입력해주세요 !');
		$('#dynamicPwdDiv').attr("style", 'background-color:yellow; color:red');
		
	}else{
		$.ajax({
			type : 'post',
			url : '/chapter06_SpringWebMaven/user/updateUser',
			data : { id : $('#dynamicId').val(), name : $('#dynamicName').val(), pwd : $('#dynamicPwd').val()},
			success : function(){
				alert('정보가  수정되었습니다...!'); 
				location.href = "/chapter06_SpringWebMaven/user/list";
			},
			error : function(err){
				console.log(err)
			}
		}); 
	}
})