var app = require('./miniExpress.js');

var mysql = require('mysql');

// 실습 목표: 게시물 삭제 처리
//
var connection = mysql.createConnection({
	host    :'localhost',
	port : 3306,
	user : 'java67',
	password : 'java67',
	database:'java67db'
});

connection.connect();

/* '/board/form.do' 요청이 들어왔을 때 호출될 함수를 등록한다.
 */
app.get('/board/form.do', function(req, res) {
	res.writeHead(200, {'Content-Type': 'text/html;charset=UTF-8'});
	res.write('<html><head><title>test10</title></head>\n');
	res.write('<body>');
	res.write('<h1>새 글</h1>');
	res.write('<form action="add.do" method="post">');
	res.write('제목: <input type="text" name="title" size="50"><br>');
	res.write('내용: <textarea name="content" rows="6" cols="50"></textarea><br>');
	res.write('<input type="submit" value="등록"><br>');
	res.write('</form>');
	res.end('</body></html>\n');
});

/* '/board/add.do' 요청이 들어왔을 때 호출될 함수를 등록한다.
 */
app.post('/board/add.do', function(req, res) {
	connection.query(
			'insert into board2(title,content,cre_date) values(?,?,now())',
			[req.params['title'], req.params['content']],
			function(err, result){
				if (err){
					console.log(err);
					doError(req, res);
					return;
				} 
				
				res.writeHead(200, {
					'Content-Type': 'text/html;charset=UTF-8',
					'Refresh': '1;url=list.do'
				});
				res.write('<html><head><title>test10</title></head>\n');
				res.write('<body>');
				res.write('<h1>등록 결과</h1>');
				res.write('<p>등록 성공입니다!</p>');
				res.end('</body></html>\n');
			});
});

app.get('/board/list.do', function(req, res) {
	connection.query(
	  "select bno, title, date_format(cre_date,'%Y-%m-%d') as cdate from board2", 
	  function(err,rows){
		if (err){
		  console.log(err);
		  doError(req, res);
		  return;
		} 
		
		res.writeHead(200, {'Content-Type': 'text/html;charset=UTF-8'});
		res.write('<html><head><title>test10</title></head>\n');
		res.write('<body>\n');
		res.write('<h1>게시글</h1>\n');
		res.write('<a href="form.do">새 글</a><br>\n');
		res.write('<table border="1">\n');
		res.write('<tr>\n');
		res.write('  <th>번호</th>\n');
		res.write('  <th>제목</th>\n');
		res.write('  <th>등록일</th>\n');
		res.write('</tr>\n');
		for (var i in rows) {
			res.write('<tr>\n');
			res.write('  <td>' + rows[i].bno + '</td>\n');
			res.write('  <td><a href="detail.do?no=' 
					+ rows[i].bno + '">' + rows[i].title + '</a></td>\n');
			res.write('  <td>' + rows[i].cdate + '</td>\n');
			res.write('</tr>\n');
		}
		res.write('</table>\n');
		res.end('</body></html>\n');
	});
});


app.get('/board/detail.do', function(req, res) {
	connection.query(
	  "select bno, title, content," +
	  " date_format(cre_date,'%Y-%m-%d') as cdate, views" +
	  " from board2 where bno=?",
	  [req.params['no']],
	  function(err,result){
		if (err){
		  console.log(err);
		  doError(req, res);
		  return;
		} 
		
		res.writeHead(200, {'Content-Type': 'text/html;charset=UTF-8'});
		res.write('<html><head><title>test10</title></head>\n');
		res.write('<body>\n');
		res.write('<h1>게시글 상세정보</h1>\n');
		res.write('<form action="change.do" method="post">\n');
		res.write('번호: <input type="text" name="no" size="5" readonly value="'
				+ result[0].bno + '"><br>\n');
		res.write('제목: <input type="text" name="title" size="50" value="'
				+ result[0].title + '"><br>\n');
		res.write('내용: <textarea name="content" rows="6" cols="50">'
				+ result[0].content + '</textarea><br>\n');
		res.write('등록일: ' + result[0].cdate + '<br>\n');
		res.write('조회수: ' + result[0].views + '<br>\n');
		res.write('<input type="submit" value="변경">\n');
		res.write('<input type="button" value="삭제"' 
				+ ' onclick="location.href=\'delete.do?no=' + result[0].bno 
				+ '\'"><br>\n');
		res.write('</form>\n');
		res.end('</body></html>\n');
	});
});

app.post('/board/change.do', function(req, res) {
	connection.query(
			'update board2 set title=?,content=? where bno=?',
			[req.params['title'], req.params['content'], req.params['no']],
			function(err, result){
				if (err){
					console.log(err);
					doError(req, res);
					return;
				} 
				
				res.writeHead(200, {
					'Content-Type': 'text/html;charset=UTF-8',
					'Refresh': '1;url=list.do'
				});
				res.write('<html><head><title>test10</title></head>\n');
				res.write('<body>');
				res.write('<h1>변경 결과</h1>');
				res.write('<p>변경 성공입니다!</p>');
				res.end('</body></html>\n');
			});
});

app.get('/board/delete.do', function(req, res) {
	connection.query(
			'delete from board2 where bno=?',
			[req.params['no']],
			function(err, result){
				if (err){
					console.log(err);
					doError(req, res);
					return;
				} 
				
				res.writeHead(200, {
					'Content-Type': 'text/html;charset=UTF-8',
					'Refresh': '1;url=list.do'
				});
				res.write('<html><head><title>test10</title></head>\n');
				res.write('<body>');
				res.write('<h1>삭제 결과</h1>');
				res.write('<p>삭제 성공입니다!</p>');
				res.end('</body></html>\n');
			});
});

function doError(req, res) {
	res.writeHead(200, {'Content-Type': 'text/html;charset=UTF-8'});
	res.write('<html><head><title>test10</title></head>\n');
	res.write('<body>');
	res.write('<h1>요청 처리 오류!</h1>');
	res.write('<p>작업 처리 중 오류가 발생했습니다.</p>');
	res.end('</body></html>\n');
}

app.listen(1337);










