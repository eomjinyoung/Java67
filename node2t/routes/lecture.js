var express = require('express');
var router = express.Router();
var app = express();
var mysql = require('mysql');


var connection = mysql.createConnection({
	host    :'localhost',
	port : 3306,
	user : 'java67',
	password : 'java67',
	database:'java67db'
});

connection.connect();

router.get('/', function(req, res) {
	res.writeHead(200, {
		'Content-Type': 'text/plain;charset=UTF-8',
		'Access-Control-Allow-Origin': '*'
	});
	  res.end('강의!!!');
	});


router.post('/add.do', function(req, res) {
	connection.query(
		'insert into lectures(title,st_date,ed_date,hours,days,capa,intro,cnt)' + 
		" values(?,?,?,?,?,?,?,0)",// cnt 기본값 = 0
		[req.body['title'], 
		 toMysqlDateForm(req.body['start_lec']),//날짜 mysql형식으로 변환
		 toMysqlDateForm(req.body['end_lec']),
		 req.body['lec_hours'], req.body['lec_days'], 
		 req.body['total'], req.body['intro']],
		function(err, result){
			if (err){
				console.log(err);
				doError(req, res, err);
				return;
			} 
			console.log(now_time() + '   add 완료');
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
	  "select lno, title, intro, capa, " +
	  "date_format(st_date,'%Y-%m-%d') as stdate, " +
	  "date_format(ed_date,'%Y-%m-%d') as enddate, " +
	  "hours, days, cnt, mno, cno" +
	  " from lectures", 
	  function(err,rows){
		if (err){
		  console.log(err);
		  doError(req, res, err);
		  return;
		} 
		
		console.log('/list.do 호출');

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
			  "SELECT T1.LNO lno, t1.title title, t1.intro intro, t1.capa capa, " +
			  "date_format(t1.st_date,'%Y-%m-%d') AS stdate, " +
			  "date_format(t1.ed_date,'%Y-%m-%d') AS enddate, " +
			  "t1.hours hours, t1.days days, t1.cnt cnt, t2.name mName, " + 
			  "t1.mno mno, T1.cno cno, t3.loc, t3.room, t4.tno tno, t5.name tName" +
			  " FROM LECTURES T1" +
			  " LEFT OUTER JOIN MANAGERS T2 ON T1.MNO=T2.MNO" +
			  " LEFT OUTER JOIN CLASSROOMS T3 ON T1.CNO=T3.CNO" +
			  " LEFT OUTER JOIN LEC_TRAI T4 ON T1.LNO=T4.LNO" +
			  " LEFT OUTER JOIN TRAINERS T5 ON T4.TNO=T5.TNO" +
			  " WHERE T1.LNO=?",
	  [req.query['no']],
	  function(err,result){
		if (err){
		  console.log(err);
		  doError(req, res, err);
		  return;
		} 
		console.log(now_time() + '   ' + result[0].lno + '번 : 상세 정보 출력');
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
	var mno=req.body['mno'], cno=req.body['cno'];
	if(mno == 'null') mno = null;
	if(cno == 'null') cno = null;
	connection.query(
		'update lectures set title=?, st_date=?, ed_date=?, hours=?, days=?, ' +
		'capa=?, intro=?, mno=?, cno=? where lno=?',
		[req.body['title'],
		 toMysqlDateForm(req.body['start_lec']),
		 toMysqlDateForm(req.body['end_lec']),
		 req.body['lec_hours'], req.body['lec_days'], req.body['total'],
		 req.body['intro'], mno, cno,
		 req.body['no']],
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
		'delete from lectures where lno=?',
		[req.query['lno']],
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

router.get('/managerlist.do', function(req, res) {
	connection.query(
	  "select mno, name, photo, tel, email from managers", 
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

router.get('/classroomlist.do', function(req, res) {
	connection.query(
	  "select cno, loc, room from classrooms", 
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

//////////////////////////////////////////////////////

function toMysqlDateForm(date) {
	return date + ' 00:00:00';
}

function now_time() {
	  var time_t = new Date();
	  var s =
		set_standard(time_t .getFullYear(), 4)+'-'+
		set_standard(time_t .getMonth() + 1, 2)+'-'+
		set_standard(time_t .getDate(), 2)+' '+
		set_standard(time_t .getHours(), 2)+':'+
		set_standard(time_t .getMinutes(), 2)+':'+
		set_standard(time_t .getSeconds(), 2);

	  return s;
}
function set_standard(time, digits) {
	  var zero = '';
	  time = time.toString();

	  if (time.length < digits) {
		for (i = 0; i < digits - time.length; i++)
		  zero += '0';
	  }
	  return zero + time;
}



module.exports = router;
