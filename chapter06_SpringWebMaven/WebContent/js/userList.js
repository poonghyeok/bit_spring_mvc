/**
 * 
 */
/*try2 confirm*/
$(function(){
	$.ajax({
		type : 'get',
		url : '/chapter06_SpringWebMaven/user/getList',
		dataType : 'json', 
		success : function(data){
			console.log('GET LIST AJAX 진입!');
			$.each(data, function(index, items){
				$('<tr/>').append($('<td/>', {
								align :'center',
								text : items.name
							})
						).append($('<td/>' ,{
								align : 'center',
								text : items.id
							})
						).append($('<td/>' ,{
								align : 'center',
								text : items.pwd
							})
					).appendTo($('#userTable'));
			});
		},
		error : function(err1){
			console.log(err1);
		}
		
	})
})

/*try1*/
function jsonToPage(data){
	var page = '<html><head><meta charset="UTF-8"></head><body>';
	page += '<table>';
	for(var i = 0; i < data.length; i++){
		page += '<tr>';
		page += ('<td>'+data[i].name+'</td>');
		page += ('<td>'+data[i].id+'</td>');
		page += ('<td>'+data[i].pwd+'</td>');
		page += '</tr>';
	}
}

$('#imgRoot').click(function(){
	location.href = "/chapter06_SpringWebMaven";
})