var http = require('http');

// 실습 목표: 요청 기본 정보 알아내기
// - 요청과 응답에 대해 사용할 수 있는 메서드 
http.createServer(function(req, res) {
	//1) 요청 헤더 정보를 알아내기
	console.log(req.headers);
	
	//2) HTTP 요청 방식 알아내기
	console.log("method = ", req.method);
	
	//3) 요청 URL 알아내기
	console.log("url = ", req.url);
	
    res.writeHead(200, {
    		'Content-Type': 'text/html;charset=UTF-8',
    	});
    res.write('<html><head><title>test05</title></head>\n');
    res.write('<body><h1>test05</h1>\n');
    res.write('<p>안녕하세요!</p>\n');
    res.end('</body></html>\n');
    
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');










