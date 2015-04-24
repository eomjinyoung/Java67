// 실습 목표
console.log("실습목표", "board2 테이블의 데이터 update하기");

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
  'update board2 set title=?, content=?, cre_date=now() where bno = ?',
  ['바꾸자','바꿔바꿔...',12],
  function(err, result){
	if (err){
	  console.log(err);
	  return;
	} 
	
	console.log(result);
		
	connection.end();
});











