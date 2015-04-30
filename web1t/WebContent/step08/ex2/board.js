/* 실습 목표: HTML로부터 자바스크립트 분리
 * 서버측 코드: node01t/src/ex6/test07.js
 */
refreshBoardTable();

document.querySelector('#addBtn').onclick = function(event) {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
	  if (xhr.readyState == 4) { // 서버로부터 응답 결과를 받았다.
		  var result = JSON.parse(xhr.responseText);
		  if (result.status == 'success') {
			  refreshBoardTable();
			  clearForm();
		  } else {
			  alert('작업을 완료할 수 없습니다.\n' + 
					  '잠시 후 다시 시도하세요.\n' +
					  '계속 창이 뜬다면, 관리자에 문의하세요.(사내번호:1112)');
			  //개발 담당자에게 메일을 쏜다!
		  }
	  }
	};
	xhr.open('POST', 'http://localhost:1337/board/add.do', true);
	xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
	
	var params = 'title=' + encodeURIComponent(
			                      document.querySelector('#title').value) + 
	             '&content=' + encodeURIComponent(
	            		            document.querySelector('#content').value); 
	xhr.send(params);
};

document.querySelector('#changeBtn').onclick = function(event) {
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function(){
    if (xhr.readyState == 4) { // 서버로부터 응답 결과를 받았다.
    	  	var result = JSON.parse(xhr.responseText);
    	  if (result.status == 'success') {
    		  refreshBoardTable();
    		  clearForm();
      } else {
        alert('작업을 완료할 수 없습니다.\n' + 
            '잠시 후 다시 시도하세요.\n' +
            '계속 창이 뜬다면, 관리자에 문의하세요.(사내번호:1112)');
        //개발 담당자에게 메일을 쏜다!
      }
    }
  };
  xhr.open('POST', 'http://localhost:1337/board/change.do', true);
  xhr.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
  
  var params = 'title=' + encodeURIComponent(
                            document.querySelector('#title').value) + 
               '&content=' + encodeURIComponent(
                              document.querySelector('#content').value) +
               '&no=' + document.querySelector('#bno').textContent; 
  xhr.send(params);
};

document.querySelector('#cancelBtn').onclick = function(event) {
	toNewForm();
};

document.querySelector('#deleteBtn').onclick = function(event) {
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function(){
    if (xhr.readyState == 4) { // 서버로부터 응답 결과를 받았다.
    	  var result = JSON.parse(xhr.responseText);
    	  if (result.status == 'success') {
    		  refreshBoardTable();
    		  clearForm();
      } else {
        alert('작업을 완료할 수 없습니다.\n' + 
            '잠시 후 다시 시도하세요.\n' +
            '계속 창이 뜬다면, 관리자에 문의하세요.(사내번호:1112)');
        //개발 담당자에게 메일을 쏜다!
      }
    }
  };
  var no = document.querySelector('#bno').textContent;
  xhr.open('GET', 'http://localhost:1337/board/delete.do?no=' + no, true);
  xhr.send(null);
};
	
function detailInfo(event) {
	var no = event.target.getAttribute('data-no');

	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
	  if (xhr.readyState == 4) { // 서버로부터 응답 결과를 받았다.
	    var result = JSON.parse(xhr.responseText);
	  
	    if (result.status == 'failure') {
        alert('작업을 완료할 수 없습니다.\n' + 
                  '잠시 후 다시 시도하세요.\n' +
                  '계속 창이 뜬다면, 관리자에 문의하세요.(사내번호:1112)');
        return;
      }
	  
	    var rows = result.data;
	    document.querySelector('#bno').innerHTML = rows[0].bno;
	    document.querySelector('#title').value = rows[0].title;
	    document.querySelector('#content').value = rows[0].content;
	    document.querySelector('#cdate').innerHTML = rows[0].cdate;
	    document.querySelector('#views').innerHTML = rows[0].views;
	    
	    //detail-items 클래스에 속해 있는 모든 엘리먼트를 찾아서, 화면에 보이게 한다.
	    //주의! querySelectAll()이 리턴하는 것은 배열이 아니라 NodeList 객체이다.
	    //따라서 for..in 문법을 사용하지 말라!
	    var elementList = document.querySelectorAll('.detail-items');
	    for (var i = 0; i < elementList.length; i++) {
	    	  //참고! 태그의 이름 알아내기: elementList[i].localName
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
	};
	xhr.open('GET', 'http://localhost:1337/board/detail.do?no=' + no, true);
	xhr.send(null);
}

function refreshBoardTable() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
	  if (xhr.readyState == 4) { // 서버로부터 응답 결과를 받았다.
	    var result = JSON.parse(xhr.responseText);
	  
	    if (result.status == 'failure') {
	      alert('작업을 완료할 수 없습니다.\n' + 
	                '잠시 후 다시 시도하세요.\n' +
	                '계속 창이 뜬다면, 관리자에 문의하세요.(사내번호:1112)');
	      return;
	    }
	    var rows = result.data;
	    var tr;
	    var table = document.querySelector('#boardTable');
	    
	    // dataRow에 소속된 기존 tr 태그를 삭제한다. 
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
	  }
	};
	xhr.open('GET', 'http://localhost:1337/board/list.do', true);
	xhr.send(null);
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