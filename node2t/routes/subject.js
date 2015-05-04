var express = require('express');
var router = express.Router();
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

router.post('/add.do', function(req, res) {
	connection.query(
		'insert into subjects(title) values(?)',
		[req.body['title']],
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

router.get('/list.do', function(req, res) {
	connection.query(
	  "select sno, title from subjects", 
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


router.get('/detail.do', function(req, res) {	
	connection.query(
	  "select title from subjects where sno=?",
	  [req.query['no']],
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

router.post('/modify.do', function(req, res) {
	console.log(req.body['title'] + req.body['no']);
	connection.query(
		'update subjects set title=? where sno=?',
		[req.body['title'], req.body['no']],
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

router.get('/delete.do', function(req, res) {
	connection.query(
			'delete from sub_trai where sno=?',
			[req.query['no']],
			function(err, result){
				if (err){
					console.log(err);
					doError(req, res, err);
					return;
				} 
			});
	
	connection.query(
		'delete from subjects where sno=?',
		[req.query['no']],
		function(err, result){
			if (err){
				console.log(err);
				doError(req, res, err);
				return;
			} 
			console.log("delete success : " + req.query['no']);
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

router.get('/', function(req, res) {
  res.send('과목 관리');
});



module.exports = router;
