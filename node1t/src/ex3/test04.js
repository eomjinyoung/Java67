var http = require('http');
var url = require('url');
var mysql = require('mysql');

// 실습 목표: 게시판 만들기
// - 게시물 입력 요청 처리하기
//

var connection = mysql.createConnection({
    host    :'localhost',
    port : 3306,
    user : 'java67',
    password : 'java67',
    database:'java67db'
});

connection.connect();

function doForm(req, res) {
	res.writeHead(200, {'Content-Type': 'text/html;charset=UTF-8'});
	res.write('<html><head><title>test10</title></head>\n');
	res.write('<body>');
	res.write('<h1>새 글</h1>');
	res.write('<form action="add.do" method="post">');
	res.write('제목: <input type="text" name="title" size="50"><br>');
	res.write('내용: <textarea name="content" rows="6" cols="50"></textarea><br>');
	res.write('<input type="submit" value="등록"><br>');
	res.write('</form>');
	res.end('</body></html>\n');
}

function doAdd(req, res) {
	connection.query(
	  'insert into board2(title,content,cre_date) values(?,?,now())',
	  [req.getParameter('title'), req.getParameter('content')],
	  function(err, result){
		if (err){
		  console.log(err);
		  doError(req, res);
		  return;
		} 
		
		res.writeHead(200, {'Content-Type': 'text/html;charset=UTF-8'});
		res.write('<html><head><title>test10</title></head>\n');
		res.write('<body>');
		res.write('<h1>등록 결과</h1>');
		res.write('<p>등록 성공입니다!</p>');
		res.end('</body></html>\n');
	});
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

	// GET 요청은 URL에서 파라미터 값을 추출하고,
	// POST 요청은 message body에서 파라미터 값을 추출한다.
	var params;
	if (req.method == 'GET') {
		params = urlInfo.query;
	} else if (req.method == 'POST') {
		params = req.body;
	}
	
	var handler = urlMapper[urlInfo.pathname];
	if (handler) {
		// req에 파라미터 값을 꺼내는 함수를 추가한다. 이 객체를 핸들러에게 전달한다.
		req.getParameter = function(name) {
			return params[name];
		};
			
		handler(req, res);
	} else {
		doError(req, res);
	}
	
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');










