/* 실습 목표: bit()에 자식 태그를 추가하고 제거하는 함수 추가하기
 * 서버측 코드: node01t/src/ex6/test07.js
 */

var $ = bit; //bit() 함수는 맨 아래에 정의되어 있다.

refreshBoardTable();

$('#addBtn').click(function(event) {
	ajax('http://localhost:1337/board/add.do', {
		method: 'POST',
		data: {
			title: $('#title').val(),
			content: $('#content').val()
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
});

$('#changeBtn').click(function(event) {
	ajax('http://localhost:1337/board/change.do', {
		method: 'POST',
		data: {
			no: $('#bno').text(),
			title: $('#title').val(),
			content: $('#content').val()
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
});

$('#cancelBtn').click(function(event) {
	toNewForm();
});

$('#deleteBtn').click(function(event) {
	var no = $('#bno').text();
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
});
	
function detailInfo(event) {
	var no = event.target.getAttribute('data-no');
	ajax('http://localhost:1337/board/detail.do?no=' + no, {
		method: 'GET',
		success: function(result) {
			var rows = result.data;
		    $('#bno').html( rows[0].bno);
		    $('#title').val( rows[0].title);
		    $('#content').val( rows[0].content);
		    $('#cdate').html( rows[0].cdate);
		    $('#views').html( rows[0].views);
		    
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
		    var table = $('#boardTable');
		    
		    $('.dataRow').remove();
		    
		    for (var i in rows) {
		      tr = document.createElement('tr');
		      tr.setAttribute('class', 'dataRow');
		      tr.innerHTML = '<td>' + rows[i].bno + '</td>\n' +
		         '<td><a href="#" onclick="detailInfo(event);" data-no="' + 
		         rows[i].bno + '">' + 
		         rows[i].title + '</a></td>\n' +
		         '<td>' + rows[i].cdate + '</td>\n';
		      table.append(tr);
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

function bit(selector) {
	var elementList = document.querySelectorAll(selector);
	
	// 엘리먼트의 값을 설정하거나 꺼내기 
	elementList.val = function(value) {
		if (arguments.length > 0) {
			for (var i = 0; i < this.length; i++) {
				this[i].value = value;
			}
		} else { // 파라미터 값이 없다는 것은 값을 달라는 의미! getter로서 동작해야 한다.
			// 첫 번째 엘리먼트의 값을 리턴한다.
			return this[0].value;
		}
	};
	
	// 엘리먼트의 속성을 설정하거나 속성의 값을 꺼낸다.
	elementList.attr = function(propName, value) {
		if (arguments.length == 2) {
			// 목록에 들어있는 모든 엘리먼트에 대해 속성을 설정한다.
			for (var i = 0; i < this.length; i++) {
				this[i].setAttribute(propName, value);
			}
		} else if (arguments.length == 1){ // 속성 이름만 주어진다면 그 속성의 값을 리턴한다.
			return this[0].getAttribute(propName);
		}
	};

	// 엘리먼트의 스타일을 지정한다.
	elementList.css = function(propName, value) {
		if (arguments.length == 2) {
			// 목록에 들어있는 모든 엘리먼트에 대해 속성을 설정한다.
			for (var i = 0; i < this.length; i++) {
				this[i].style[propName] = value;
			}
		} else if (arguments.length == 1){ // 속성 이름만 주어진다면 그 속성의 값을 리턴한다.
			return this[0].style[propName];
		}
	};
	
	// 엘리먼트의 컨텐츠를 리턴한다.
	elementList.text = function(value) {
		if (arguments.length == 1) {
			for (var i = 0; i < this.length; i++) {
				this[i].textContent = value;
			}
		} else if (arguments.length == 0){ 
			return this[0].textContent;
		}
	};
	
	// 엘리먼트의 컨텐츠를 리턴한다.
	elementList.html = function(value) {
		if (arguments.length == 1) {
			for (var i = 0; i < this.length; i++) {
				this[i].innerHTML = value;
			}
		} else if (arguments.length == 0){ 
			return this[0].innerHTML;
		}
	};
	
	// 엘리먼트의 클릭 이벤트 리스너 등록
	elementList.click = function(listener) {
		if (listener) { // 리스너가 주어지면 해당 리스너를 click 이벤트 처리자로 등록한다.
			for (var i = 0; i < this.length; i++) {
				this[i].addEventListener('click', listener);
			}
		} else { // 리스너 없이 click()을 호출한다면 click 이벤트를 발생시킨다. 
			var clickEvent = new MouseEvent('click', { /* 이벤트 옵션 설정 */
			  bubbles: true,
			  cancelable: true,
			  view: window
		    });
			for (var i = 0; i < this.length; i++) {
				this[i].dispatchEvent(clickEvent);
			}
		}
	};
	
	elementList.append = function(child) {
		for (var i = 0; i < this.length; i++) {
			this[i].appendChild(child);
		}
	};
	
	elementList.remove = function() {
		for (var i = 0; i < this.length; i++) {
			this[i].parentElement.removeChild(this[i]);
		}
	}
	
	return elementList;
}




























