var express = require('express');
var router = express.Router();
var mysql = require('mysql');
// middleware specific to this router
/*
router.use(function timeLog(req, res, next) {
  console.log('Time: ', Date.now());
  next();
});
*/
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
		'insert into students(name, photo, tel, email, pwd, addr, degree, work) values(?,?,?,?,?,?,?,?)',
		[req.body['name'], req.body['photo'], req.body['tel'], req.body['email']
		, req.body['pwd'], req.body['addr'], req.body['degree'], req.body['work']],
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
	  "select sno, name from students", 
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

router.post('/search.do', function(req, res) {
	connection.query(
	  "select * from students where name like ?",
	  [req.body['name']],
	  function(err,rows){
		if (err){
		  console.log(err);
		  doError(req, res, err);
		  return;
		} 
		console.log(req.body['name']);

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
	  "select sno, name, photo, tel, email, pwd, addr, degree, work from students where sno=?",
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

router.post('/change.do', function(req, res) {
	connection.query(
		'update students set name=?, photo=?, tel=?, email=?, pwd=?, addr=?, degree=?, work=? where sno=?',
		[req.body['name'], req.body['photo'], req.body['tel'], req.body['email']
		, req.body['pwd'], req.body['addr'], req.body['degree'], req.body['work'], req.body['no']],
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
		'delete from students where sno=?',
		[req.query['no']],
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
	
	connection.query(
			'delete from lec_appl where sno=?',
			[req.query['no']],
			function(err, result){
				if (err){
					console.log(err);
					doError(req, res, err);
					return;
				} 
				
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

//router.listen(3000);


router.get('/', function(req, res) {
  res.send('학생 관리');
});



module.exports = router;
