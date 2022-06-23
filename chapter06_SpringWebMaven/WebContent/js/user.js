/**
 * 
 */
$('#writeButton').click(function(){
	alert("write button clicked..!");
	$('#nameDiv').empty();
	$('#idDiv').empty();
	$('#pwdDiv').empty();
	
	/*왜 .is(:empty) 는 먹히지 않는가.*/
	if( !$('#name').val()){
		$('#nameDiv').html('이름을 입력해주세요 !');
		$('#nameDiv').attr("style", 'background-color:yellow; color:red');
	
	}else if( !$('#id').val()){
		$('#idDiv').html('아이디를 입력해주세요 !');
		$('#idDiv').attr("style", 'background-color:yellow; color:red;');
	
	}else if( !$('#pwd').val()){
		$('#pwdDiv').html('비밀번호를 입력해주세요 !');
		$('#pwdDiv').attr("style", 'background-color:yellow; color:red');
		
	}else{
		$.ajax({
			type : 'post',
			url : '/chapter06_SpringWebMaven/user/write',
			data : $('#writeForm').serialize(),
			success : function(){
				alert('회원가입을 축하합니다..!'); 
				location.href = "/chapter06_SpringWebMaven/user/list";
			/*	$.ajax({
					type : 'get',
					url : '/chapter06_SpringWebMaven/user/list',
					dataType : 'json', 
					success : function(data){
						console.log('ajax2 진입!');
						document.write(jsonToPage(data));
					},
					error : function(err1){
						console.log(err1);
					}
				})*/
			},
			error : function(err){
				console.log(err)
			}
		}); 
	}
})

/*function jsonToPage(data){
	var page = '<html><head><meta charset="UTF-8"></head><body>';
	page += '<table>';
	for(var i = 0; i < data.length; i++){
		page += '<tr>';
		page += ('<td>'+data[i].name+'</td>');
		page += ('<td>'+data[i].id+'</td>');
		page += ('<td>'+data[i].pwd+'</td>');
		page += '</tr>';
	}
	
	page += '</table></body></html>';
		
	return page;
}
*/

$('#imgRoot').click(function(){
	location.href = "/chapter06_SpringWebMaven";
})

$('#id').focusout(function(){
	alert('#id focusout..!');
	if($('#id').val() !== ''){
		$.ajax({
			type : 'get',
			url : '/chapter06_SpringWebMaven/user/isAlready',
			data : { id : $('#id').val()},
			dataType : 'text', 
			success : function(result){
				if(result === 'non_exist'){
					$('#idDiv').html('사용가능한 아이디입니다.');
					$('#idDiv').attr('style','background-color:yellow; color:blue;');
				}else if(result == 'exist'){
					$('#idDiv').html('이미 존재하는 아이디입니다. 사용이 불가능합니다');
					$('#idDiv').attr('style','background-color:yellow; color:red;')
				}
			},
			error : function(err){
				console.log(err);
			}
		})
	}else{
		alert('아이디 먼저 입력해주세요 !');
	}

})
