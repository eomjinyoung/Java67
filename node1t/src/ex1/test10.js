var http = require('http');
var url = require('url');

// 실습 목표: 계산기 만들기
// - 요청 URL 형식
//   /calc?v1=값&v2=값&op=연산자명
//   연산자명: plus, minus, multiple, divide, remainder
// - 출력 결과
//   URL) /calc?v1=20&v2=30&op=multiple
//   출력) 20 * 30 = 600
//

function compute(v1, v2, op) {
  switch (op) {
  case 'plus': return v1 + v2; 
  case 'minus': return v1 - v2;
  case 'multiple': return v1 * v2;
  case 'divide': return v1 / v2;
  case 'remainder': return v1 % v2;
  default: throw "해당 연산자를 지원하지 않습니다.";
  }
}

function fromOpToNotation(op) {
  switch (op) {
  case 'plus': return '+';
  case 'minus': return '-';
  case 'multiple': return '*'; 
  case 'divide': return '/'; 
  case 'remainder': return '%';
  }
}

http.createServer(function(req, res) {
	var urlInfo = url.parse(req.url, true);
	
	res.writeHead(200, {
		'Content-Type': 'text/html;charset=UTF-8',
	});
	res.write('<html><head><title>test10</title></head>\n');
	res.write('<body>');

	if (urlInfo.pathname == '/calc') {
		var v1 = parseInt(urlInfo.query.v1);
		var v2 = parseInt(urlInfo.query.v2);
		

		try {
			var result = compute(v1, v2, urlInfo.query.op);
			var notation = fromOpToNotation(urlInfo.query.op);
			
			res.write('<h1>test10</h1>\n');
		    res.write(v1 + ' ' + notation + ' ' + v2 + ' = ' + result + '\n');
		    
		} catch (ex) {
			res.write('<h1>예외 발생!</h1>\n');
			res.write('<p>' + ex + '</p>\n');
		}
	    
	} else {
		res.write('<p>해당 URL을 지원하지 않습니다!</p>');
	}
	
	res.write('<p><a href="http://localhost:9999/web1t/step04/ex1/calcForm.html">다시 계산하기</a></p>\n');
	res.end('</body></html>\n');
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');










