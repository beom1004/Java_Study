$('input[name=email]').on('keyup', function(){
	let email = $(this).val();
	$.ajax({
		url : "emailCheck.do",
		type : "post",
		data : {"email" : email},
		dataType : 'text',
		success : function(result){
			if(result == 'false'){
				$('#emailCheck').text('사용 가능한 이메일입니다.');
			}else{
				$('#emailCheck').text('이미 사용중인 이메일입니다.');
			}
		},
		error : function(){
			$('#emailCheck').text('ajax error 발생.');
		}
	});
});

