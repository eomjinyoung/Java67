var http = require('http');

// 실습 목표: 응답 내용의 문자셋 지정
// - 요청과 응답에 대해 사용할 수 있는 메서드 
http.createServer(function(req, res) {
    res.writeHead(200, {
    		'Content-Type': 'text/html;charset=UTF-8',
    	});
    res.write('<html><head><title>test04</title></head>\n');
    res.write('<body><h1>test04</h1>\n');
    res.write('<p>안녕하세요!</p>\n');
    res.end('</body></html>\n');
    
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');










