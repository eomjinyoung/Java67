
$('body').on('click', '#popBtn', function(event) {

	var tno = event.target.getAttribute('data-addno');
	var lno = $("#lecno").val();
	
	$.ajax('add', {
		method: 'POST',
		data:{
			lno:lno,
			tno:tno
		},
		async: false,
		success: function(result) {
			location.href='list?lno='+lno;
		},
		error: function(xhr, textStatus, errorThrown) {
			alert('이미 등록되어 있습니다.');
		}
	});	
	
});

$('#confirm').click(function(event){
	location.href='../lecture/list'; // 강사관리 페이지로 리다이렉트 해야함..
});