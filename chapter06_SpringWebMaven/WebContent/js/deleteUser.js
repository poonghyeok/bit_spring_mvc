/**
 * 
 */
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
				console.log(JSON.stringify(data));
				if(data == ''){
					$('#idDiv').html('검색한 아이디는 존재하지 않습니다.');
					$('#idDiv').attr('style','background-color:yellow; color:blue;');
				}else{
					if(confirm(data.name+' 을 정말로 삭제하시겠습니까?')){
						$.ajax({
							type : 'post',
							url : '/chapter06_SpringWebMaven/user/deleteUser',
							data : {id : data.id},
							success : function(){
								alert(data.name + ' 님 정보를 삭제하였습니다. 안녕히가세요.');
								location.href='/chapter06_SpringWebMaven';
							},
							error : function(error2){
								console.log(error2);
							}
						})
					}
				}
				
			},
			error : function(err){
				console.log(err);
			}
		})
	}else{
		$('#idDiv').html('삭제할 아이디를 먼저 입력해주세요..!');
		$('#idDiv').attr('style','background-color:yellow; color:blue;');
	}
})
