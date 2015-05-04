/* 실습 목표: 압축한 bit.js를 사용하기
 * 서버측 코드: node01t/src/ex6/test07.js
 */
var ip = 'localhost';//'192.168.103.67'
refreshBoardTable();  



$('#addBtn').click(function(event) {
	$.ajax('http://' + ip + ':3000/student/add.do', {
		method: 'POST',
		dataType: 'json',
		data: {
			name: $('#name').val(),
			photo: $('#photo').val(),
			tel: $('#tel').val(),
			email: $('#email').val(),
			pwd: $('#pwd').val(),
			addr: $('#addr').val(),
			degree: $('#degree').val(),
			work: $('#work').val()
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

$('#changeBtn').click(function(event) {
	$.ajax('http://' + ip + ':3000/student/change.do', {
		method: 'POST',
		dataType: 'json',
		data: {
			no: $('#sno').text(),
			name: $('#name').val(),
			photo: $('#photo').val(),
			tel: $('#tel').val(),
			email: $('#email').val(),
			pwd: $('#pwd').val(),
			addr: $('#addr').val(),
			degree: $('#degree').val(),
			work: $('#work').val()
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

$('#searchBtn').click(function(event) {
	$.ajax('http://' + ip + ':3000/student/search.do', {
		method: 'POST',
		dataType: 'json',
		data: {
			name: '%' + $('#search').val() + '%',
		},
		success: function(result) {
			var rows = result.data;
		    var table = $('#boardTable');
		    
		    $('.dataRow').remove();
		    
		    for (var i in rows) {
		      $('<tr>')
		      		.attr('class', 'dataRow')
		      		.html('<td>' + rows[i].SNO + '</td>\n' +
		      				'<td><a href="#" onclick="detailInfo(event);" data-no="' + 
		      				rows[i].SNO + '">' + 
		      				rows[i].NAME + '</a></td>\n')
		      		.appendTo(table);
		    }
		    $('#search').val('');
		},
		error: function(xhr, textStatus, errorThrown) {
			alert('작업을 완료할 수 없습니다.\n' + 
				  '잠시 후 다시 시도하세요.\n' +
				  '계속 창이 뜬다면, 관리자에 문의하세요.(사내번호:1112)');
		}
	});
});
/*
$('#searchBtn').click(function(event) {
	alert($('#search').val());
	$.ajax('http://' + ip + ':3000/student/search.do?name=' + $('#search').val(), {
		method: 'GET',
		dataType: 'json',
		success: function(result) {
			console.log(result);
			var rows = result.data;
		    var table = $('#boardTable');
		    
		    $('.dataRow').remove();
		    
		    for (var i in rows) {
		      $('<tr>')
		      		.attr('class', 'dataRow')
		      		.html('<td>' + rows[i].sno + '</td>\n' +
		      				'<td><a href="#" onclick="detailInfo(event);" data-no="' + 
		      				rows[i].sno + '">' + 
		      				rows[i].name + '</a></td>\n')
		      		.appendTo(table);
		    }
		},
		error: function(xhr, textStatus, errorThrown) {
			alert('작업을 완료할 수 없습니다.\n' + 
				  '잠시 후 다시 시도하세요.\n' +
				  '계속 창이 뜬다면, 관리자에 문의하세요.(사내번호:1112)');
		}
	});
});
*/
$('#deleteBtn').click(function(event) {
	var no = $('#sno').text();
	$.ajax('http://' + ip + ':3000/student/delete.do?no=' + no, {
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
	$.ajax('http://' + ip + ':3000/student/detail.do?no=' + no, {
		method: 'GET',
		dataType: 'json',
		success: function(result) {
			var rows = result.data;
		    $('#sno').html( rows[0].sno);
		    $('#name').val( rows[0].name);
		    if (rows[0].photo != '') {
		        document.getElementById("photo1").src = rows[0].photo;
		    } else {
		    	console.log(rows[0].photo);
		    	document.getElementById("photo1").src = "http://golftour114.kr/img/no_image.jpg";
		    }
		    $('#photo').val( rows[0].photo);
		    $('#tel').val( rows[0].tel);
		    $('#email').val( rows[0].email);
		    $('#pwd').val( rows[0].pwd);
		    $('#addr').val( rows[0].addr);
		    $('#degree').val( rows[0].degree);
		    $('#work').val( rows[0].work);
		    
		    toDetailForm();
		    console.log(rows[0].photo);
		},
		error: function(xhr, textStatus, errorThrown) {
			alert('작업을 완료할 수 없습니다.\n' + 
				  '잠시 후 다시 시도하세요.\n' +
				  '계속 창이 뜬다면, 관리자에 문의하세요.(사내번호:1112)');
		}
	});
}

function refreshBoardTable() {
	$.ajax('http://' + ip + ':3000/student/list.do', {
		method: 'GET',
		dataType: 'json',
		success: function(result) {
			var rows = result.data;
		    var table = $('#boardTable');
		    
		    $('.dataRow').remove();
		    
		    for (var i in rows) {
		      $('<tr>')
		      		.attr('class', 'dataRow')
		      		.html('<td>' + rows[i].sno + '</td>\n' +
		      				'<td><a href="#" onclick="detailInfo(event);" data-no="' + 
		      				rows[i].sno + '">' + 
		      				rows[i].name + '</a></td>\n')
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

function enterBtn() {
	$('#searchBtn').click();
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
	document.getElementById("photo1").src = "http://golftour114.kr/img/no_image.jpg"
	refreshBoardTable();
}



function clearForm() {
	$('#cancelBtn').click();
}
















