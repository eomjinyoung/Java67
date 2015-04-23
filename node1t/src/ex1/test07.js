var http = require('http');
var url = require('url');

// 실습 목표: 요청 파라미터 추출하기
// - 요청과 응답에 대해 사용할 수 있는 메서드 
http.createServer(function(req, res) {
	console.log("------------------------------");
	//그냥 분석하면 query string이 문자열로 추출된다.
	//- 쿼리 스트링을 파라미터 별로 추출하고 두 번째 파라미터를 true로 설정하라!
	var urlInfo = url.parse(req.url, true);
	
	console.log("웹 애플리케이션 경로 = ", urlInfo.pathname);
	
	// 테스트 URL: http://localhost:1337/calc/compute.do?v1=20&v2=30&op=plus
	// 파라미터 값 출력하기
	console.log("v1 = ", urlInfo.query.v1);
	console.log("v2 = ", urlInfo.query.v2);
	console.log("op = ", urlInfo.query.op);
	
    res.writeHead(200, {
    		'Content-Type': 'text/html;charset=UTF-8',
    	});
    res.write('<html><head><title>test07</title></head>\n');
    res.write('<body><h1>test07</h1>\n');
    res.write('<p>안녕하세요!</p>\n');
    res.end('</body></html>\n');
    
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');










