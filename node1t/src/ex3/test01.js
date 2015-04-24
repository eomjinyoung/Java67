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

function doForm(req, res) {
	res.writeHead(200, {'Content-Type': 'text/html;charset=UTF-8'});
	res.write('<html><head><title>test10</title></head>\n');
	res.write('<body>');
	res.write('<h1>새 글</h1>');
	res.end('</body></html>\n');
}

function doAdd(req, res) {
	res.writeHead(200, {'Content-Type': 'text/html;charset=UTF-8'});
	res.write('<html><head><title>test10</title></head>\n');
	res.write('<body>');
	res.write('<h1>등록 결과</h1>');
	res.end('</body></html>\n');
}

function doList(req, res) {
	res.writeHead(200, {'Content-Type': 'text/html;charset=UTF-8'});
	res.write('<html><head><title>test10</title></head>\n');
	res.write('<body>');
	res.write('<h1>게시글</h1>');
	res.end('</body></html>\n');
}

function doDetail(req, res) {
	res.writeHead(200, {'Content-Type': 'text/html;charset=UTF-8'});
	res.write('<html><head><title>test10</title></head>\n');
	res.write('<body>');
	res.write('<h1>상세정보</h1>');
	res.end('</body></html>\n');
}

function doChange(req, res) {
	res.writeHead(200, {'Content-Type': 'text/html;charset=UTF-8'});
	res.write('<html><head><title>test10</title></head>\n');
	res.write('<body>');
	res.write('<h1>변경 결과</h1>');
	res.end('</body></html>\n');
}

function doDelete(req, res) {
	res.writeHead(200, {'Content-Type': 'text/html;charset=UTF-8'});
	res.write('<html><head><title>test10</title></head>\n');
	res.write('<body>');
	res.write('<h1>삭제 결과</h1>');
	res.end('</body></html>\n');
}

function doError(req, res) {
	res.writeHead(200, {'Content-Type': 'text/html;charset=UTF-8'});
	res.write('<html><head><title>test10</title></head>\n');
	res.write('<body>');
	res.write('<h1>요청 오류!</h1>');
	res.write('<p>해당 URL을 지원하지 않습니다!</p>');
	res.end('</body></html>\n');
}

http.createServer(function(req, res) {
	var urlInfo = url.parse(req.url, true);
	
	switch (urlInfo.pathname) {
	case '/board/form.do': doForm(req, res); break;
	case '/board/add.do': doAdd(req, res); break;
	case '/board/list.do': doList(req, res); break;
	case '/board/detail.do': doDetail(req, res); break;
	case '/board/change.do': doChange(req, res); break;
	case '/board/delete.do': doDelete(req, res); break;
	default: doError(req, res);
	}
	
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');










