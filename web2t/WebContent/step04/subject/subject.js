
var ip = '192.168.103.69:3000';
refreshBoardTable();

$('body').on('click','.modBtn' , function(event) {
	console.log("mod");
	var no = event.target.parentNode.parentNode.firstChild.innerHTML;
	$.ajax('http://' + ip + '/subject/modify.do', {
		method: 'POST',
		dataType: 'json',
		data: {
			no: no,
			title: $('#modSubject').val()
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

$('body').on('click','.delBtn' , function(event)  {
	console.log("del");
	var no = event.target.parentNode.parentNode.firstChild.innerHTML;
	console.log(no);
	$.ajax('http://' + ip + '/subject/delete.do?no=' + no, {
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

$('#addBtn').click(function(event) {
	console.log("addBtnClicked");
	$.ajax('http://' + ip + '/subject/add.do', {
		method: 'POST',
		dataType: 'json',
		data: {
			title: $('#title').val()
		},
		success: function(result) {
			refreshBoardTable();
			clearForm();
			$('#title').val('');
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


	
function detailInfo(event) {
	var no = event.target.getAttribute('data-no');
	$.ajax('http://' + ip + '/subject/detail.do?no=' + no, {
		method: 'GET',
		dataType: 'json',
		success: function(result) {
			var rows = result.data;
		    $('#sno').html( rows[0].bno);
		    $('#title').val( rows[0].title);
		    
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
	$.ajax('http://' + ip + '/subject/list.do', {
		method: 'GET',
		dataType: 'json',
		success: function(result) {
			var rows = result.data;
		    var table = $('#boardTable');
		    var trNum=0;
		    
		    $('.dataRow').remove();
		    
		    for (var i in rows) {
		      $('<tr data-no="'+rows[i].sno+'"onclick="clickedSubjectTr(event)">')
		      		.attr('class', 'dataRow')
		      		.html('<td id="'+ rows[i].sno+'">' + rows[i].sno + '</td>\n' +
		      				'<td>' + rows[i].title + '</td>\n' +
		      				'<td> \n' +
		      				'<button type="button" \n' +
		                    'class="modBtn btn btn-primary btn-sm new-items" style="display:none">v</button> \n'+
		                    '<button type="button" \n' +
		                    'class="delBtn btn btn-primary btn-sm new-items" style="display:none">x</button> \n'+
		      				'</td>')
		      		.appendTo(table);
		      trNum++;
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

function clickedSubjectTr(event) {
	console.log("event target = "+event.target);
	//window.event.cancelBubble=true;
	if (event.target.nodeName == "INPUT")
		return;
	var no = event.currentTarget.getAttribute('data-no');
	var tn = event.target.nodeName;
	var ctn = event.currentTarget.nodeName;
	console.log("ctarget tn = "+tn);
	console.log("target ctn = "+ctn);
	if ($('#modSubject').val()) {
		var rep = $('#modSubject').val();
		$('#modSubject').parent().append(rep);
		$('#modSubject').remove();
		}
	console.log(no);
	//var tv = event.target.nodeName;
	var tcv = event.currentTarget.nodeName;
	var modValue = event.currentTarget.childNodes[2].innerHTML;
	event.currentTarget.childNodes[2].innerHTML = 
		"<input id='modSubject' type='text' class='form-control' value='" + modValue +"'>";
	
	$('tr[class="dataRow"] > td > button').css('visibility','hidden').css('display','none');
	$('tr[data-no="'+no+'"]> td > button').css('visibility','visible').css('display','inline');
		
}








