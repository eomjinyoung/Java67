
var ip = 'localhost';

var paramcno = getUrlParameter('cno');
var loc;
var roomname;

refreshBoardTable();

$('#addBtn').click(function(event) {
	var submitdata = prompt("사진 URL을 입력하세요", "url 입력");
	if (submitdata==null) {
		return false;
	}
	$.ajax('http://' + ip + ':3000/crphoto/add.do', {
		method: 'POST',
		dataType: 'json',
		data: {
			cno : paramcno,
			picurl:  submitdata
		},
		success: function(result) {
			alert("사진이 등록되었습니다!");
			clearSlide();
			refreshBoardTable();
		},
		error: function(xhr, textStatus, errorThrown) {
			alert('작업을 완료할 수 없습니다.\n' + 
				  '잠시 후 다시 시도하세요.\n' +
				  '계속 창이 뜬다면, 관리자에 문의하세요.(사내번호:1112)');
		}
	});
});


$('#deleteBtn').click(function(event) {
	clearList();
	var delpic = $('.active').html();
	
	if (delpic==undefined) {
		alert("삭제할 사진이 없습니다. 사진을 등록해주세요");
	}
	
	var src = delpic.split('"');
	var delcpno = src[3];
	
	
	$.ajax('http://' + ip + ':3000/crphoto/delete.do?cpno=' + delcpno, {
		method: 'GET',
		dataType: 'json',
		
		success: function(result) {
			alert("삭제되었습니다.");
			clearSlide();
			refreshBoardTable();		
		},
		error: function(xhr, textStatus, errorThrown) {
			alert('작업을 완료할 수 없습니다.\n' + 
				  '잠시 후 다시 시도하세요.\n' +
				  '계속 창이 뜬다면, 관리자에 문의하세요.(사내번호:1112)');
		}
	});
});
	


function refreshBoardTable() {
	$.ajax('http://' + ip + ':3000/crphoto/list.do?cno=' + paramcno, {
		method: 'GET',
		dataType: 'json',
		success: function(result) {
			getLocName();
			var rows = result.data;
		    var parent1 = $('.carousel-inner');
		    var parent2 = $('.carousel-indicators');
		    
		    if (rows[0]==undefined) {
		    	alert("사진이 없습니다. 등록해주세요");
		    }
		    for (var i in rows) {
		    	
		       if (rows[i] == rows[0]){
		    	   
		    	  parent2.append('<li data-target="#carousel-example-generic" data-slide-to="' + i + 
		    			   '"class="inNo active"></li>');
		    	   
		    	   parent1.append('<div class="item active" id = "' +rows[i].cpno + 
		    			   '"> <img src="' + rows[i].photo + '" id= "' + 
		    			   rows[i].cpno +'" alt="...">'+
			      		      '<div class="carousel-caption">'+
			            '</div></div>');
		       } else {
		      
		    	   parent2.append('<li data-target="#carousel-example-generic" data-slide-to="' + i + 
    			   '" class="inNo"></li>');
		    	   
		    	   parent1.append('<div class="item" id = "' +rows[i].cpno + 
		    			   '"> <img src="' + rows[i].photo + '" id = "'+
		    			  rows[i].cpno +'" alt="...">'+
	      		      '<div class="carousel-caption">'+'</div></div>');
		      }
		    }
		},
		error: function(xhr, textStatus, errorThrown) {
			alert('작업을 완료할 수 없습니다.\n' + 
				  '잠시 후 다시 시도하세요.\n' +
				  '계속 창이 뜬다면, 관리자에 문의하세요.(사내번호:1112)');
		}
	});
}

function clearSlide(){
  $('.item').remove();
  $('.inNo').remove();
}

function clearList(){
	  $('.inNo').remove();		
	}


function getUrlParameter(sParam){
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) 
    {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam) 
        {
            return sParameterName[1];
        }
    }
}  

function getLocName() {
	$.ajax('http://' + ip + ':3000/crphoto/getLocName.do', {
		method: 'post',
		dataType: 'json',
		data: {
			cno : paramcno
		},
		success: function(result) {
			var rows = result.data;
			loc = rows[0].loc;
			roomname = rows[0].room;
			$('#classname').text('<' + loc + '>  ' + roomname + '호 강의실');
		    },		
		error: function(xhr, textStatus, errorThrown) {
			alert('작업을 완료할 수 없습니다.\n' + 
				  '잠시 후 다시 시도하세요.\n' +
				  '계속 창이 뜬다면, 관리자에 문의하세요.(사내번호:1112)');
		}
	});
}









