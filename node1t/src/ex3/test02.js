var http = require('http');
var url = require('url');

// 실습 목표: 게시판 만들기
// - URL과 핸들러(URL 요청을 처리하는 함수)를 연결하기(매핑;mapping)
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

var urlMapper = {
	'/board/form.do': doForm,
	'/board/add.do': doAdd,
	'/board/list.do': doList,
	'/board/detail.do': doDetail,
	'/board/change.do': doChange,
	'/board/delete.do': doDelete,
};

http.createServer(function(req, res) {
	var urlInfo = url.parse(req.url, true);
	
	var handler = urlMapper[urlInfo.pathname];
	if (handler) {
		handler(req, res);
	} else {
		doError(req, res);
	}
	
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');










