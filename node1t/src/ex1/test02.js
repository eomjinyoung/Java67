var http = require('http');

// 실습 목표: 응답 헤더 다루기
// - 요청과 응답에 대해 사용할 수 있는 메서드 
http.createServer(function(req, res) {
	// 1) HTTP 응답 헤더 출력
	// 예)
	// HTTP/1.1 200 OK CRLF
	// Content-Type: text/plain CRLF
	// Refresh: 3;url=http://www.daum.net CRLF
	// ...
	// CRLF
	// Hello World CRLF <-- 본문(message body)
    res.writeHead(
    		200, // 응답 상태 코드(status code)
    		{	 // 응답 헤더 정보
	    		'Content-Type': 'text/plain',
	    		//'Refresh': '3;url=http://www.daum.net' 
	    		// 웹 브라우저에게 본문 출력 3초후 www.daum.net으로 다시 요청할 것을 요구함.
    	});
    
    // 2) HTTP 응답 본문(message body) 출력 
    res.end('Hello World\n');
    
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');










