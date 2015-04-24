// 실습 목표
console.log("실습목표", "mysql 서버에서 board2 select하기");

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
  "select bno, title, date_format(cre_date,'%Y-%m-%d') as cdate from board2", 
  function(err,rows){
	if (err){
	  console.log(err);
	  return;
	} 
	
	for (var i in rows) {
	  console.log(rows[i].bno, rows[i].title, rows[i].cdate);
	}
		
	connection.end();
});











