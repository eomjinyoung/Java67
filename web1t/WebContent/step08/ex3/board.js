/* 실습 목표: 엘리먼트를 찾는 코드를 단순화하자. 
 * - 1) AJAX 호출 부분을 별도의 함수로 정의하여 단순화 하자. 
 */
refreshBoardTable();

document.querySelector('#addBtn').onclick = function(event) {
	ajax('http://localhost:1337/board/add.do', {
		method: 'POST',
		data: {
			title: document.querySelector('#title').value,
			content: document.querySelector('#content').value
		},
		success: function(result) {
			refreshBoardTable();
			clearForm();
		},
		error: function(err) {
			alert('작업을 완료할 수 없습니다.\n' + 
				  '잠시 후 다시 시도하세요.\n' +
				  '계속 창이 뜬다면, 관리자에 문의하세요.(사내번호:1112)');
		}
	});
};

document.querySelector('#changeBtn').onclick = function(event) {
	ajax('http://localhost:1337/board/change.do', {
		method: 'POST',
		data: {
			no: document.querySelector('#bno').textContent,
			title: document.querySelector('#title').value,
			content: document.querySelector('#content').value
		},
		success: function(result) {
			refreshBoardTable();
			clearForm();
		},
		error: function(err) {
			alert('작업을 완료할 수 없습니다.\n' + 
				  '잠시 후 다시 시도하세요.\n' +
				  '계속 창이 뜬다면, 관리자에 문의하세요.(사내번호:1112)');
		}
	});
};

document.querySelector('#cancelBtn').onclick = function(event) {
	toNewForm();
};

document.querySelector('#deleteBtn').onclick = function(event) {
	var no = document.querySelector('#bno').textContent;
	ajax('http://localhost:1337/board/delete.do?no=' + no, {
		method: 'GET',
		success: function(result) {
			refreshBoardTable();
			clearForm();
		},
		error: function(err) {
			alert('작업을 완료할 수 없습니다.\n' + 
				  '잠시 후 다시 시도하세요.\n' +
				  '계속 창이 뜬다면, 관리자에 문의하세요.(사내번호:1112)');
		}
	});
};
	
function detailInfo(event) {
	var no = event.target.getAttribute('data-no');
	ajax('http://localhost:1337/board/detail.do?no=' + no, {
		method: 'GET',
		success: function(result) {
			var rows = result.data;
		    document.querySelector('#bno').innerHTML = rows[0].bno;
		    document.querySelector('#title').value = rows[0].title;
		    document.querySelector('#content').value = rows[0].content;
		    document.querySelector('#cdate').innerHTML = rows[0].cdate;
		    document.querySelector('#views').innerHTML = rows[0].views;
		    
		    toDetailForm();
		},
		error: function(err) {
			alert('작업을 완료할 수 없습니다.\n' + 
				  '잠시 후 다시 시도하세요.\n' +
				  '계속 창이 뜬다면, 관리자에 문의하세요.(사내번호:1112)');
		}
	});
}

function refreshBoardTable() {
	ajax('http://localhost:1337/board/list.do', {
		method: 'GET',
		success: function(result) {
			var rows = result.data;
		    var tr;
		    var table = document.querySelector('#boardTable');
		    
		    var trList = document.querySelectorAll('.dataRow');
		    for (var i = 0; i < trList.length; i++) {
		      table.removeChild(trList[i]);
		    }
		    
		    for (var i in rows) {
		      tr = document.createElement('tr');
		      tr.setAttribute('class', 'dataRow');
		      tr.innerHTML = '<td>' + rows[i].bno + '</td>\n' +
		         '<td><a href="#" onclick="detailInfo(event);" data-no="' + 
		         rows[i].bno + '">' + 
		         rows[i].title + '</a></td>\n' +
		         '<td>' + rows[i].cdate + '</td>\n';
		      table.appendChild(tr);
		    }
		},
		error: function(err) {
			alert('작업을 완료할 수 없습니다.\n' + 
				  '잠시 후 다시 시도하세요.\n' +
				  '계속 창이 뜬다면, 관리자에 문의하세요.(사내번호:1112)');
		}
	});
}

function toDetailForm() {
	var elementList = document.querySelectorAll('.detail-items');
    for (var i = 0; i < elementList.length; i++) {
    	  if (elementList[i] instanceof HTMLDivElement) {
    		  elementList[i].style.display = 'block';
    	  } else {
    		  elementList[i].style.display = 'inline';
    	  }
    }
    var elementList = document.querySelectorAll('.new-items');
    for (var i = 0; i < elementList.length; i++) {
        elementList[i].style.display = 'none';
    }
}

function toNewForm() {
	// 폼을 새 글 입력 폼으로 변경한다.
  var elementList = document.querySelectorAll('.new-items');
  for (var i = 0; i < elementList.length; i++) {
      if (elementList[i] instanceof HTMLDivElement) {
        elementList[i].style.display = 'block';
      } else {
        elementList[i].style.display = 'inline';
      }
  }
  var elementList = document.querySelectorAll('.detail-items');
  for (var i = 0; i < elementList.length; i++) {
    elementList[i].style.display = 'none';
  }
}

function clearForm() {
  // 폼의 입력 항목을 초기화시킨다.
  // 직접 코드로 초기화시키지 않고, reset 버튼을 눌렀다고 강제로 클릭 이벤트를 발생시킨다.
  // 1) 이벤트 정보를 담은 객체를 만든다.
  var clickEvent = new MouseEvent('click', { /* 이벤트 옵션 설정 */
	  bubbles: true,
	  cancelable: true,
	  view: window
  });
  
  // 2) 임의로 생성한 click 이벤트를 reset 버튼에 보낸다.
  document.querySelector('#cancelBtn').dispatchEvent(clickEvent);
}

// 공통함수: 여러 프로젝트에 사용할 수 있는 함수
function ajax(url, settings) {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
	  if (xhr.readyState == 4) { 
		  var result = JSON.parse(xhr.responseText);
		  if (result.status == 'success') {
			  if (settings.success) {
				  settings.success(result);
			  }
		  } else {
			  if (settings.error) {
				  settings.error(result.data);
			  }
		  }
	  }
	};
	xhr.open(settings.method, url, true);
	if (settings.method == 'POST') {
		xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		
		var params = '';
		if (settings.data) {
			for (var propName in settings.data) {
				if (params.length > 0) {
					params += '&';
				}
				params += propName + '=' + 
						  encodeURIComponent(settings.data[propName]);
			}
		}
		xhr.send(params);
		
	} else {
		xhr.send(null);
	}
}






























