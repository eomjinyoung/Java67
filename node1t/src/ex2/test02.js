// 실습 목표
console.log("실습목표", "mysql 서버에서 board2 테이블에 insert하기");

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
  'insert into board2(title,content,cre_date) values(?,?,now())',
  ['hahahaok2', '우헤헤2'],
  function(err, result){
	if (err){
	  console.log(err);
	  return;
	} 
	
	console.log(result);
		
	connection.end();
});











