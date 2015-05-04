/* 실습 목표: jQuery 사용하기
 * 서버측 코드: node01t/src/ex6/test07.js
 */


// lectures table column명 ed_date -> end_date
// alter table lectures change ed_date end_date date; 

// ip = 서버 아이피
var ip = '127.0.0.1';
//var ip = '192.168.10.2';
//var ip = '121.166.177.31';

/*$(document).ready(function() {
	$(function() {
		$( "#accordion" ).accordion();
	});
});*/

refreshBoardTable();

$('#myModal').on('shown.bs.modal', function () {
	$('#myInput').focus()
});



$('#addBtn').click(function(event) {
	
	$.ajax('http://' + ip + ':3000/lecture/add.do', {
		method: 'POST',
		dataType: 'json',
		data: {
			title: $('#title').val(),
			start_lec: $('#start_lec').val(),
			end_lec: $('#end_lec').val(),
			lec_hours: $('#lec_hours').val(),
			lec_days: $('#lec_days').val(),
			total: $('#total').val(),
			intro: $('#intro').val()
			
		},
		
		success: function(result) {
			clearForm();
			reFreshPage();
		},
		error: function(xhr, textStatus, errorThrown) {
			alert('작업을 완료할 수 없습니다.\n' + 
				  '잠시 후 다시 시도하세요.\n' +
				  '계속 창이 뜬다면, 관리자에 문의하세요.(사내번호:1112)');
		}
	});
});

$('#changeBtn').click(function(event) {
	$.ajax('http://' + ip + ':3000/lecture/change.do', {
		method: 'POST',
		dataType: 'json',
		data: {
			no: $('#lno').text(),
			title: $('#title').val(),
			start_lec: $('#start_lec').val(),
			end_lec: $('#end_lec').val(),
			lec_hours: $('#lec_hours').val(),
			lec_days: $('#lec_days').val(),
			total: $('#total').val(),
			intro: $('#intro').val(),
			mno: $('#managerSelct').val(),
			cno: $('#classSelct').val()
		},
		success: function(result) {
			clearForm();
			reFreshPage();
			
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
	$.ajax('http://' + ip + ':3000/lecture/delete.do', {
		method: 'GET',
		data: {lno: $('#lno').text()},
		dataType: 'json',
		success: function(result) {
			clearForm();
			reFreshPage();
		},
		error: function(err) {
			alert('작업을 완료할 수 없습니다.\n' + 
				  '잠시 후 다시 시도하세요.\n' +
				  '계속 창이 뜬다면, 관리자에 문의하세요.(사내번호:1112)');
		}
	});
});

$('body').on('click', '.detailChangeBtn', function(event) {
	var no = event.target.getAttribute('data-no');
	detailInfo(no);
	$('#myModal2').click();
});

$('body').on('click', '.traiBtn', function(event) {
	var no = event.target.getAttribute('data-no');
	var url = 'http://' + ip + ':3000/lecteach/lecteach.html';
	location.href = url + '?no=' + no;

});

$('#myModal2').click(function() {
	clearForm();
});


//강사배정/수강신청버튼
$('#lecApplBtn').click(function(event) {
	var url = 'http://' + ip + ':3000/lecappl/lecappl.html';
	location.href = url;
});

$('#lecTraiBtn').click(function(event) {
	var url = 'http://' + ip + ':3000/lecteach/lecteach.html';
	location.href = url;
});

$('#managerBtn').click(function(event) {
	//매니저 변경
	//매니저목록 갱신
});

$('#classBtn').click(function(event) {
	//강의실 변경
});
	

function detailInfo(no) {
	$.ajax('http://' + ip + ':3000/lecture/detail.do?no=' + no, {
		method: 'GET',
		dataType: 'json',
		success: function(result) {
			var rows = result.data;
		    $('#lno').html( rows[0].lno);
		    $('#title').val( rows[0].title);
		    $('#start_lec').val( rows[0].stdate);
		    $('#end_lec').val( rows[0].enddate);
		    $('#lec_hours').val( rows[0].hours);
		    $('#lec_days').val( rows[0].days);
		    $('#total').val( rows[0].capa);
		    $('#cnt').val( rows[0].cnt);
		    $('#intro').val( rows[0].intro);
		    
		    
		    $('#trainer').html('미배정');
		    if (rows[0].tName) {
		    	$('#trainer').html( rows[0].tName);
		    }
		    
	    	$('#manager').html('없음');
		    if(rows[0].mno) {
		    	var mngSelectNo = 'option#mng' + rows[0].mno;
		    	$('#manager').html( rows[0].mName);
		    }
		    
		    $('#classroom').html('미배정');
		    if (rows[0].cno) {
		    	var clsSelectNo = 'option#cls' + rows[0].cno;
		    	$('#classroom').html( rows[0].loc + ' - ' + rows[0].room);
		    }
		    
		    
		    
		    toDetailForm();
		    
		    //매니저목록 갱신
		    refreshManagerSelect(mngSelectNo);
		    
		    
		    //강의실목록 갱신
		    refreshClassSelect(clsSelectNo);
		    
		    
		    
		    
		},
		error: function(err) {
			alert('작업을 완료할 수 없습니다.\n' + 
				  '잠시 후 다시 시도하세요.\n' +
				  '계속 창이 뜬다면, 관리자에 문의하세요.(사내번호:1112)');
		}
	});
}


function refreshBoardTable() {
	$.ajax('http://' + ip + ':3000/lecture/list.do', {
		method: 'GET',
		dataType: 'json',
		success: function(result) {
			var rows = result.data;
			var accordion = $('#accordion');
			
			accordion.empty();


			for (var i in rows) {
				$('<p>')
				.html(rows[i].title)
				.appendTo(accordion);

				
				$('<div>')
				.html(rows[i].intro + '<hr>')
				.addClass('introDiv')
				.attr('id', 'deBtn' + rows[i].lno)
				.appendTo(accordion);
				
				introDiv = $('div.introDiv#deBtn' + rows[i].lno);
	            $('<button>')
	            .html('상세/수정')
	            .addClass('detailChangeBtn')
	            .addClass("btn btn-info btn btn-primary btn-xs")
	            .attr('type',"button")
	            .attr('data-no', rows[i].lno)
	            .appendTo(introDiv);
	            
	            $('<span>').html('    ').appendTo(introDiv)
	            $('<button>')
	            .html('강사배정')
	            .addClass("traiBtn")
	            .addClass("btn btn-success btn btn btn-primary btn-xs")
	            .attr('type', "button")
	            .attr('data-no', rows[i].lno)
	            .appendTo(introDiv);
				
			}
			$(function() {
				$( "#accordion" ).accordion();
			});
			toNewForm();
		},
		error: function(err) {
			alert('작업을 완료할 수 없습니다.\n' + 
					'잠시 후 다시 시도하세요.\n' +
			'계속 창이 뜬다면, 관리자에 문의하세요.(사내번호:1112)');
		}
	});
}


function toDetailForm() {
	$('.new-items').css('display', 'none');
	$('span.detail-items, button.detail-items').css('display', 'inline');
	$('div.detail-items').css('display', 'block');
}

function toNewForm() {
	$('.detail-items').css('display', 'none');
	$('span.new-items, button.new-items').css('display', 'inline');
	$('div.new-items').css('display', 'block');
}

function clearForm() {
	$('#cancelBtn').click();
}

function refreshManagerSelect(mngSelectNo) {
	$.ajax('http://' + ip + ':3000/lecture/managerlist.do', {
		method: 'GET',
		dataType: 'json',
		success: function(result) {
			var rows = result.data;
			var select = $('#managerSelct');
			
			select.empty();
			$('<option>')
			.attr('value', 'null')
			.attr('id', 'mng0')
      		.html('없음')
      		.appendTo(select);
			
			for ( var i in rows) {
				$('<option>')
				.attr('value', rows[i].mno)
				.attr('id', 'mng' + rows[i].mno)
	      		.html(rows[i].name)
	      		.appendTo(select);
			}

		    $(mngSelectNo).attr('selected', 'selected');
			
			
			
		}
	});
}

function refreshClassSelect(clsSelectNo) {
	$.ajax('http://' + ip + ':3000/lecture/classroomlist.do', {
		method: 'GET',
		dataType: 'json',
		success: function(result) {
			var rows = result.data;
			var select = $('#classSelct');
			
			select.empty();
			$('<option>')
			.attr('value', 'null')
			.attr('id', 'cls0')
      		.html('미배정')
      		.appendTo(select);
			
			for ( var i in rows) {
				$('<option>')
				.attr('value', rows[i].cno)
				.attr('id', 'cls' + rows[i].cno)
	      		.html(rows[i].loc + '-' + rows[i].room)
	      		.appendTo(select);
			}
			
		    $(clsSelectNo).attr('selected', 'selected');
		}
	});
	
}

function reFreshPage() {
	location.reload(true);
}



/*
 * 
$(function() {
	$( "#accordion" ).accordion();
}); 

*/











