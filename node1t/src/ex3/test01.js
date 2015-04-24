var http = require('http');
var url = require('url');

// 실습 목표: 게시판 만들기
// 0) 글 등록폼: /board/form.do
// 1) 글 등록: /board/add.do?title=값&content=값
// 2) 글 목록: /board/list.do
// 3) 글 조회: /board/detail.do?no=값
// 4) 글 변경: /board/change.do?no=값&title=값&content=값
// 5) 글 삭제: /board/delete.do?no=값
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










