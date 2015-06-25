/* 실습 목표: jQuery API 사용 
 * 서버측 코드: node01t/src/ex6/test07.js
 */
var ip = 'localhost:9999/web4t';
refreshBoardTable();

$('#addBtn').click(function(event) {
	$.ajax('http://' + ip + '/board/ajax/add.do', {
		method: 'POST',
		dataType: 'json',
		data: {
			title: $('#title').val(),
			content: $('#content').val()
		},
		success: function(result) {
			refreshBoardTable();
			clearForm();
		},
		error: function(xhr, textStatus, errorThrown) {
			alert('작업을 완료할 수 없습니다.\n' + 
				  '잠시 후 다시 시도하세요.\n' +
				  '계속 창이 뜬다면, 관리자에 문의하세요.(사내번호:1112)');
		}
	});
});

$('#changeBtn').click(function(event) {
	$.ajax('http://' + ip + '/board/ajax/change.do', {
		method: 'POST',
		dataType: 'json',
		data: {
			no: $('#bno').text(),
			title: $('#title').val(),
			content: $('#content').val()
		},
		success: function(result) {
			refreshBoardTable();
			clearForm();
		},
		error: function(xhr, textStatus, errorThrown) {
			alert('작업을 완료할 수 없습니다.\n' + 
				  '잠시 후 다시 시도하세요.\n' +
				  '계속 창이 뜬다면, 관리자에 문의하세요.(사내번호:1112)');
		}
	});
});

$('#cancelBtn').click(function(event) {
	toNewForm();
});

$('#deleteBtn').click(function(event) {
	var no = $('#bno').text();
	$.ajax('http://' + ip + '/board/ajax/delete.do?no=' + no, {
		method: 'GET',
		dataType: 'json',
		success: function(result) {
			refreshBoardTable();
			clearForm();
		},
		error: function(xhr, textStatus, errorThrown) {
			alert('작업을 완료할 수 없습니다.\n' + 
				  '잠시 후 다시 시도하세요.\n' +
				  '계속 창이 뜬다면, 관리자에 문의하세요.(사내번호:1112)');
		}
	});
});
	
function detailInfo(event) {
	var no = event.target.getAttribute('data-no');
	$.ajax('http://' + ip + '/board/ajax/detail.do?no=' + no, {
		method: 'GET',
		dataType: 'json',
		success: function(result) {
			var board = result.data;
		    $('#bno').html( board.no);
		    $('#title').val( board.title);
		    $('#content').val( board.content);
		    $('#cdate').html( board.createDate);
		    $('#views').html( board.views);
		    
		    toDetailForm();
		},
		error: function(xhr, textStatus, errorThrown) {
			alert('작업을 완료할 수 없습니다.\n' + 
				  '잠시 후 다시 시도하세요.\n' +
				  '계속 창이 뜬다면, 관리자에 문의하세요.(사내번호:1112)');
		}
	});
}

function refreshBoardTable() {
	$.ajax('http://' + ip + '/board/ajax/list.do', {
		method: 'GET',
		dataType: 'json',
		success: function(result) {
			var rows = result.data;
		    var table = $('#boardTable');
		    
		    $('.dataRow').remove();
		    
		    for (var i in rows) {
		      $('<tr>')
		      		.attr('class', 'dataRow')
		      		.html('<td>' + rows[i].no + '</td>\n' +
		      				'<td><a href="#" onclick="detailInfo(event);" data-no="' + 
		      				rows[i].no + '">' + 
		      				rows[i].title + '</a></td>\n' +
		      				'<td>' + rows[i].createDate + '</td>\n')
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

function toDetailForm() {
	$('span.detail-items, button.detail-items').css('display', 'inline');
	$('div.detail-items').css('display', 'block');
    $('.new-items').css('display', 'none');
}

function toNewForm() {
	$('span.new-items, button.new-items').css('display', 'inline');
	$('div.new-items').css('display', 'block');
	$('.detail-items').css('display', 'none');
}

function clearForm() {
	$('#cancelBtn').click();
}
















