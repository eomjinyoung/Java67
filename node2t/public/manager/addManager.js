var ip='localhost';
$('#upload').click(function(event) {
	alert("정말로 추가 하시겠습니까?");
		$.ajax('http://'+ip+':3000/manager/addManager.do', {
		method: 'POST',
		dataType: 'json',
		
		success: function(result) {
			location.replace('/manager/addResult.html?status=addok');
			clearForm();
		},
		error: function(xhr, textStatus, errorThrown) {
			console.log("클라이언트 : "+textStatus);
			location.replace('/manager/addResult.html?status=addok');
		}
	});
		
});
$('#listBtn').click(function(event) {
	location.replace('/manager/listManager.html');
		
});


function clearForm() {
	$('#cancelBtn').click();
}