// 실습 목표
console.log("실습목표", "board2 테이블에서 delete하기");

var mysql = require('mysql');

var connection = mysql.createConnection({
    host    :'localhost',
    port : 3306,
    user : 'java67',
    password : 'java67',
    database:'java67db'
});

connection.connect();

connection.query(
  'delete from board2 where bno = ?',
  [13],
  function(err, result){
	if (err){
	  console.log(err);
	  return;
	} 
	
	console.log(result);
		
	connection.end();
});











