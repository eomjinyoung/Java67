var http = require('http');
var url = require('url'); //URL 분석 및 GET 요청의 데이터 분석
var querystring = require('querystring'); //POST 요청의 message body 데이터 분석
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

function callHandler(path, req, res, params) {
	var handler = urlMapper[path];
	if (handler) {
		// req에 파라미터 값을 꺼내는 함수를 추가한다. 이 객체를 핸들러에게 전달한다.
		req.getParameter = function(name) {
			return params[name];
		};
		handler(req, res);
	} else {
		doError(req, res);
	}
}

http.createServer(function(req, res) {
	// URL? /board/add.do?title=...&content=....
	var urlInfo = url.parse(req.url, true);

	// GET 요청은 URL에서 파라미터 값을 추출하고,
	// POST 요청은 message body에서 파라미터 값을 추출한다.
	var params;
	if (req.method == 'GET') {
		params = urlInfo.query;
		callHandler(urlInfo.pathname, req, res, params);
		
	} else if (req.method == 'POST') {
		// POST 요청은 message body이 데이터를 읽어야 한다.
		// 그런데 message body 데이터는 이벤트 처리하는 식으로 읽어야 한다.
		// 1) 웹 브라우저가 보낸 데이터의 일부를 읽을 때 마다 data 이벤트가 발생한다.
		//    이 이벤트가 발생할 때 마다 읽은 데이터를 임시 변수에 보관한다.
		//    보내는 데이터 적다면 한 번 호출로 끝나겠지만, 
		//    많다면 data 이벤트가 여러 번 발생할 것이다.
		//    그래서 data 이벤트가 발생할 때마다 그 값을 임시 변수에 보관하는 것이다.
		var messageBody = ''; // POST 요청의 message body 데이터를 임시 보관할 변수
		req.on('data', function(data) { // data 이벤트가 발생했을 때 호출될 메서드 등록 
 			messageBody += data;
 		});
 		
 		// 언제까지 읽어야 하는가? message body 데이터를 모두 읽으면 end 이벤트가 발생한다.
 		req.on('end', function() {// end 이벤트가 발생했을 때 호출될 메서드 등록
 			// 지금까지 읽은 message body 데이터를 분석하여 params에 객체로 보관한다.
 			// 직접 분석할까? 미칬나! -> 도구 써라! -> querystring
 			params = querystring.parse(messageBody);
 			callHandler(urlInfo.pathname, req, res, params);
 		});
	}
	
	
	
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');










