var ip='localhost';
refreshListManager();
function refreshListManager() {
	
	$.ajax('http://'+ip+':3000/manager/listManager.do', {
		method: 'GET',
		dataType: 'json',
		 
		success: function(result) {
			var rows = result.data;
		    var table = $('#tbody');
		    
		    $('.dataRow').remove();
		    
		    for (var i in rows) {
		      $('<tr>')
		      		.attr('class', 'dataRow')
		      		.html('<td>' + rows[i].mno + '</td>\n' +
		      				'<td><a href="http://'+ip+':3000/manager/detailManager.html?no='+
		      				rows[i].mno + '">' + 
		      				rows[i].name + '</a></td>\n'+
		      				'<td>' + rows[i].email + '</td>\n'+
		      				'<td>' + rows[i].tel + '</td>\n')
		      		.appendTo(table);
		    }
		},
		error: function(xhr, textStatus, errorThrown) {
			alert('작업을 완료할 수 없습니다.\n' + 
				  '잠시 후 다시 시도하세요.\n' +
				  '계속 창이 뜬다면, 관리자에 문의하세요.(사내번호:1112)');
		}
	});
}

$('#addBtn').click(function(event) {
	location.replace('/manager/addManager.html');
});