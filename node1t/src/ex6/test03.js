var app = require('./miniExpress.js');

var mysql = require('mysql');

// 실습 목표: AJAX 요청 처리하기
// - 클라이언트 코드: web01t/WebContent/step08/ex1/board05.html
// - /board/add.do 요청 처리
//
var connection = mysql.createConnection({
	host    :'localhost',
	port : 3306,
	user : 'java67',
	password : 'java67',
	database:'java67db'
});

connection.connect();


app.post('/board/add.do', function(req, res) {
	connection.query(
			'insert into board2(title,content,cre_date) values(?,?,now())',
			[req.params['title'], req.params['content']],
			function(err, result){
				if (err){
					console.log(err);
					doError(req, res);
					return;
				} 
				
				res.writeHead(200, {
					'Content-Type': 'text/plain;charset=UTF-8',
					'Access-Control-Allow-Origin': '*'
				});
				res.end('ok');
			});
});

app.get('/board/list.do', function(req, res) {
	connection.query(
	  "select bno, title, date_format(cre_date,'%Y-%m-%d') as cdate from board2", 
	  function(err,rows){
		if (err){
		  console.log(err);
		  doError(req, res);
		  return;
		} 
		
		// 웹 브라우저로 JSON 문자열을 보낸다.
		// - Content-Type을 변경한다.
		res.writeHead(200, {
			'Content-Type': 'text/plain;charset=UTF-8',
			'Access-Control-Allow-Origin': '*'
		});
		res.end(JSON.stringify(rows));
	});
});


app.get('/board/detail.do', function(req, res) {
	connection.query(
	  "select bno, title, content," +
	  " date_format(cre_date,'%Y-%m-%d') as cdate, views" +
	  " from board2 where bno=?",
	  [req.params['no']],
	  function(err,result){
		if (err){
		  console.log(err);
		  doError(req, res);
		  return;
		} 
		
		res.writeHead(200, {'Content-Type': 'text/html;charset=UTF-8'});
		res.write('<html><head><title>test10</title></head>\n');
		res.write('<body>\n');
		res.write('<h1>게시글 상세정보</h1>\n');
		res.write('<form action="change.do" method="post">\n');
		res.write('번호: <input type="text" name="no" size="5" readonly value="'
				+ result[0].bno + '"><br>\n');
		res.write('제목: <input type="text" name="title" size="50" value="'
				+ result[0].title + '"><br>\n');
		res.write('내용: <textarea name="content" rows="6" cols="50">'
				+ result[0].content + '</textarea><br>\n');
		res.write('등록일: ' + result[0].cdate + '<br>\n');
		res.write('조회수: ' + result[0].views + '<br>\n');
		res.write('<input type="submit" value="변경">\n');
		res.write('<input type="button" value="삭제"' 
				+ ' onclick="location.href=\'delete.do?no=' + result[0].bno 
				+ '\'"><br>\n');
		res.write('</form>\n');
		res.end('</body></html>\n');
	});
});

app.post('/board/change.do', function(req, res) {
	connection.query(
			'update board2 set title=?,content=? where bno=?',
			[req.params['title'], req.params['content'], req.params['no']],
			function(err, result){
				if (err){
					console.log(err);
					doError(req, res);
					return;
				} 
				
				res.writeHead(200, {
					'Content-Type': 'text/html;charset=UTF-8',
					'Refresh': '1;url=list.do'
				});
				res.write('<html><head><title>test10</title></head>\n');
				res.write('<body>');
				res.write('<h1>변경 결과</h1>');
				res.write('<p>변경 성공입니다!</p>');
				res.end('</body></html>\n');
			});
});

app.get('/board/delete.do', function(req, res) {
	connection.query(
			'delete from board2 where bno=?',
			[req.params['no']],
			function(err, result){
				if (err){
					console.log(err);
					doError(req, res);
					return;
				} 
				
				res.writeHead(200, {
					'Content-Type': 'text/html;charset=UTF-8',
					'Refresh': '1;url=list.do'
				});
				res.write('<html><head><title>test10</title></head>\n');
				res.write('<body>');
				res.write('<h1>삭제 결과</h1>');
				res.write('<p>삭제 성공입니다!</p>');
				res.end('</body></html>\n');
			});
});

function doError(req, res) {
	res.writeHead(200, {'Content-Type': 'text/html;charset=UTF-8'});
	res.write('<html><head><title>test10</title></head>\n');
	res.write('<body>');
	res.write('<h1>요청 처리 오류!</h1>');
	res.write('<p>작업 처리 중 오류가 발생했습니다.</p>');
	res.end('</body></html>\n');
}

app.listen(1337);










