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
		'insert into cr_photo(photo,cno) values(?,?)',
		[req.body['picurl'], req.body['cno']],
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
	  "select cpno, photo, cno from cr_photo where cno = ?", 
	  [req.query['cno']],
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

router.get('/delete.do', function(req, res) {
connection.query(
		'delete from cr_photo where cpno = ?',
		[req.query['cpno']],
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


router.post('/getLocName.do', function(req, res){
	connection.query(
			'select loc, room from classrooms where cno = ?',
			[req.body['cno']],
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
					  status: 'success',
					  	data : result
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

/*router.get('/seleclist.do?cno=', function(req, res) {
  res.send('강의실 사진 관리');
});*/


module.exports = router;



