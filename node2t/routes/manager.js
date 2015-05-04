var express = require('express');
var router = express.Router();
var mysql = require('mysql');
var fs = require('fs');
var util = require("util"); 



var connection = mysql.createConnection({
	host    :'localhost',
	port : 3306,
	user : 'java67',
	password : 'java67',
	database:'java67db'
});
connection.connect();

router.post('/addManager.do', function(req, res,next) {
	console.log('Request :::: POST ::::: addManager.do');
	var fileName;
	//file
	if (req.files) {
		fileName=req.files.myFile.name;
		if (req.files.myFile.size === 0) {
		            return next(new Error("Hey, first would you select a file?"));
		}
		fs.exists(req.files.myFile.path, function(exists) { 
			if(exists) { 
				console.log("fileName : : : : : : : : : :"+req.files.myFile.name);
			} else { 
				fileName='noimg.gif';
			} 
		}); 
	} 
	
	fileName=req.files.myFile.name;
	connection.query(
		'insert into managers(name,email,pwd,photo,tel) values(?,?,?,?,?)',
		[req.body['name'], req.body['email'],req.body['password'],fileName,req.body['tel']],
		function(err, result){
			if (err){
				console.log("에러!"+err);
				doError(req, res, err);
				return;
			} 			
			res.writeHead(200, {
				'Content-Type': 'text/html;charset=UTF-8',
				'Access-Control-Allow-Origin': '*'
			});
			res.end("<script>location.replace('/manager/addResult.html?status=addok');</script>");
		});

	
});
router.get('/detailManager.do', function(req, res) {
	console.log('Request :::: GET ::::: detailManager.do');
	
	connection.query(
		'select mno , name , email , pwd , photo , tel from managers where mno=?',
		[req.query['no']],
		function(err, result){
			if (err){
				console.log("에러!"+err);
				doError(req, res, err);
				return;
			}
			res.writeHead(200, {
				'Content-Type': 'text/plain;charset=UTF-8',
				'Access-Control-Allow-Origin': '*'
			});
			res.end(JSON.stringify({
				data : result,
			  status: 'success'
			}));
		});

	
});
router.get('/listManager.do', function(req, res) {
	console.log('Request :::: GET ::::: listManager.do');
	connection.query(
	  "select mno, name, tel, email from managers", 
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
router.post('/updateManager.do', function(req, res) {
	console.log('Request :::: GET ::::: listManager.do');
	
	if(req.body['photo']==undefined){
		var qu = 'update managers set name=?,email=? , pwd =? , tel=? where mno=?';
		var pre =[req.body['name'], req.body['email'], req.body['password'], req.body['tel'], req.body['no']];
	}else {
		var qu = 'update managers set name=?,email=? , pwd =? , tel=? ,photo=? where mno=?';
		var pre =[req.body['name'], req.body['email'], req.body['password'], req.body['tel'],req.body['photo'], req.body['no']];
	}
		connection.query(
				qu,
				pre,
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
		'delete from managers where mno=?',
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
});


function doError(req,res,err) {
	res.writeHead(200, {
		'Content-Type': 'text/plain;charset=UTF-8',
		'Access-Control-Allow-Origin': '*'
	});
	res.write("오류발생'");
	res.end(JSON.stringify({
	  status: err
	}));
}



module.exports = router;
