/* 실습 목표: ajax() 함수가 다른 라이브러리 함수와 이름 충돌나지 않도록 bit() 함수에 묶는다.
 */
function bit(str) {
	var elementList;
	
	if (str.charAt(0) == '<') { //예) str --> <tr> 라면, 
		var endIndex = str.indexOf('>');
		var tagName = str.substring(1, endIndex);
		elementList = [document.createElement(tagName)];
		
	} else {
		elementList = document.querySelectorAll(str);
	}
	
	// 엘리먼트의 값을 설정하거나 꺼내기 
	elementList.val = function(value) {
		if (arguments.length > 0) {
			for (var i = 0; i < this.length; i++) {
				this[i].value = value;
			}
			return this;
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
			return this;
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
			return this;
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
			return this;
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
			return this;
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
			return this;
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
			for (var j = 0; j < child.length; j++) {
				this[i].appendChild(child[j]);
			}
		}
		return this;
	};
	
	elementList.remove = function() {
		for (var i = 0; i < this.length; i++) {
			this[i].parentElement.removeChild(this[i]);
		}
		return this;
	}
	
	elementList.appendTo = function(parent) {
		for (var i = 0; i < this.length; i++) {
			for (var j = 0; j < parent.length; j++) {
				parent[j].appendChild(elementList[i]);
			}
		}
		return this;
	}
	
	return elementList;
}

// 자바스크립트는 함수도 객체로 다룬다.
bit.ajax = function(url, settings) {
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
};

var $ = bit; 



























