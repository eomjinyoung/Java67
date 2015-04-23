var http = require('http');

// 실습 목표: 응답 내용 다루기
// - 요청과 응답에 대해 사용할 수 있는 메서드 
http.createServer(function(req, res) {
    res.writeHead(200, {
    		'Content-Type': 'text/plain',
    	});
    res.write('하하하하 ^^');
    res.end('Hello World\n');
    
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');










