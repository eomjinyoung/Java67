var app = require('./miniExpress.js');

var mysql = require('mysql');

// 실습 목표: AJAX 요청 처리하기
// - 클라이언트 코드: web01t/WebContent/step08/ex1/board09.html
// - 서버에서 예외가 발생하면 클라이언트에게 알리기 
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
				doError(req, res, err);
				return;
			} 
			
			res.writeHead(200, {
				'Content-Type': 'text/plain;charset=UTF-8',
				'Access-Control-Allow-Origin': '*'
			});

			res.end(JSON.stringify({
			  status: 'success'
			}));
		});
});

app.get('/board/list.do', function(req, res) {
	connection.query(
	  "select bno, title, date_format(cre_date,'%Y-%m-%d') as cdate from board2", 
	  function(err,rows){
		if (err){
		  console.log(err);
		  doError(req, res, err);
		  return;
		} 

		res.writeHead(200, {
			'Content-Type': 'text/plain;charset=UTF-8',
			'Access-Control-Allow-Origin': '*'
		});

		res.end(JSON.stringify({
			  status: 'success',
			  data: rows
		}));
	});
});


app.get('/board/detail.do', function(req, res) {
	connection.query(
	  "update board2 set views=views + 1 where bno=?",
	  [req.params['no']],
	  function(err,result){
		  // 조회수 증가시킨 후 굳이 기다릴 필요가 없이 바로 상세정보를 가져와서
		  // 클라이언트로 보내면 된다.
		  // 따라서 여기에 특별히 코딩할게 없다.
	});
	
	connection.query(
	  "select bno, title, content," +
	  " date_format(cre_date,'%Y-%m-%d') as cdate, views" +
	  " from board2 where bno=?",
	  [req.params['no']],
	  function(err,result){
		if (err){
		  console.log(err);
		  doError(req, res, err);
		  return;
		} 
		
		res.writeHead(200, {
			'Content-Type': 'text/plain;charset=UTF-8',
			'Access-Control-Allow-Origin': '*'
		});
		res.end(JSON.stringify({
			  status: 'success',
			  data: result
		}));
	});
});

app.post('/board/change.do', function(req, res) {
	connection.query(
		'update board2 set title=?,content=? where bno=?',
		[req.params['title'], req.params['content'], req.params['no']],
		function(err, result){
			if (err){
				console.log(err);
				doError(req, res, err);
				return;
			} 
			
			res.writeHead(200, {
				'Content-Type': 'text/plain;charset=UTF-8',
				'Access-Control-Allow-Origin': '*'
			});
			res.end(JSON.stringify({
				  status: 'success'
			}));
		});
});

app.get('/board/delete.do', function(req, res) {
	connection.query(
		'delete from board2 where bno=?',
		[req.params['no']],
		function(err, result){
			if (err){
				console.log(err);
				doError(req, res, err);
				return;
			} 
			
			res.writeHead(200, {
				'Content-Type': 'text/plain;charset=UTF-8',
				'Access-Control-Allow-Origin': '*'
			});
			res.end(JSON.stringify({
				  status: 'success'
			}));
		});
});

function doError(req, res, err) {
	res.writeHead(200, {
		'Content-Type': 'text/html;charset=UTF-8',
		'Access-Control-Allow-Origin': '*'
	});
	res.end(JSON.stringify({
		status: 'failure',
		data: err
	}));
}

app.listen(1337);










