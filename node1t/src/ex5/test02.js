var app = require('./miniExpress.js');
// 실습 목표: web01t/WebContent/step07/ex4/test01.html의 요청 처리
// - 모든 웹 브라우저에서 비동기 요청하는 것을 허락한다.
app.get('/hello', function(req, res) {
	res.writeHead(200, {
		'Content-Type': 'text/html;charset=UTF-8',
		'Access-Control-Allow-Origin': '*' /* 비동기 요청 허락 */
	});
	res.end('안녕하세요. ' + req.params['name'] + '님.\n');
});
app.listen(1337);










