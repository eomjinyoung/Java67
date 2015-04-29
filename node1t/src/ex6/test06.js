var app = require('./miniExpress.js');

var mysql = require('mysql');

// 실습 목표: AJAX 요청 처리하기
// - 클라이언트 코드: web01t/WebContent/step08/ex1/board08.html
// - /board/change.do 요청 처리
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
		
		res.writeHead(200, {
			'Content-Type': 'text/plain;charset=UTF-8',
			'Access-Control-Allow-Origin': '*'
		});
		res.end(JSON.stringify(result));
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
				'Content-Type': 'text/plain;charset=UTF-8',
				'Access-Control-Allow-Origin': '*'
			});
			res.end('ok');
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
					'Content-Type': 'text/plain;charset=UTF-8',
					'Access-Control-Allow-Origin': '*'
				});
				res.end('ok');
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










