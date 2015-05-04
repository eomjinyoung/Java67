getManager();

function getManager() {	
	var ip='localhost';
	$.urlParam = function(name){
	    var results = new RegExp('[\?&amp;]' + name + '=([^&amp;#]*)').exec(window.location.href);
	    return results[1] || 0;
	}
	
	$.ajax('http://'+ip+':3000/manager/detailManager.do?no='+$.urlParam('no'), {
		method: 'GET',
		dataType: 'json',
		
		success: function(result) {
			var rows = result.data;
			console.log(rows[0].photo);
			if (rows[0].photo=='') {
				rows[0].photo='/noimg.gif';
				}
			
		    $('#no').html( rows[0].mno);
		    $('#name').val( rows[0].name);
		    $('#password').val( rows[0].pwd);
		    $('#email').val( rows[0].email);
		    $('#tel').val( rows[0].tel);
		    $('#photo').attr("src", '/manager/img/'+rows[0].photo);
		    
		},
		error: function(xhr, textStatus, errorThrown) {
			console.log("클라이언트 : "+textStatus);
		}
	});
	
}

$('#updateBtn').click(function(event) {
	var ip='localhost';
	$.ajax('http://'+ip+':3000/manager/updateManager.do', {
		method: 'POST',
		dataType: 'json',
		data: {
			no: $('#no').text(),
			name: $('#name').val(),
			password: $('#password').val(),
			email: $('#email').val(),
			tel: $('#tel').val()
		},
		success: function(result) {
			location.replace('/manager/addResult.html?status=upok');
		},
		error: function(xhr, textStatus, errorThrown) {
			location.replace('/manager/addResult.html?status=upfail');
		}
	});
});

$('#listBtn').click(function(event) {
	location.replace('/manager/listManager.html');
});

$('#deleteBtn').click(function(event) {
	var ip='localhost';
	var no = $('#no').text();
	$.ajax('http://'+ip+':3000/manager/delete.do?no=' + no, {
		method: 'GET',
		dataType: 'json',
		success: function(result) {
			location.replace('/manager/addResult.html?status=deleteok');
		},
		error: function(xhr, textStatus, errorThrown) {
			location.replace('/manager/addResult.html?status=deletefail');
		}
	});
});