var app = require('./miniExpress.js');
// 실습 목표: web01t/WebContent/step07/ex4/test01.html의 요청 처리
//
app.get('/hello', function(req, res) {
	res.writeHead(200, {'Content-Type': 'text/html;charset=UTF-8'});
	res.end('안녕하세요. ' + req.params['name'] + '님.\n');
});
app.listen(1337);










