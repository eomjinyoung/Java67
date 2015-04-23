var http = require('http');
var url = require('url');

// 실습 목표: 요청 URL 정보 추출하기
// - 요청과 응답에 대해 사용할 수 있는 메서드 
http.createServer(function(req, res) {
	console.log("------------------------------");
	//1) url 객체의 도움을 받아서 요청 URL을 해석하자!
	var urlInfo = url.parse(req.url);
	
	//2) 해석한 정보에서 전체 URL 정보 추출
	console.log("URL = ", urlInfo.href);
	
	//3) 해석한 정보에서 웹 애플리케이션 경로 정보 추출
	console.log("웹 애플리케이션 경로 = ", urlInfo.pathname);
	
	//4) 해석한 정보에서 웹 애플리케이션 경로를 뺀 정보 추출 
	console.log("search 스트링 = ", urlInfo.search);
	
	//5) Query String 추출
	console.log("쿼리 스트링 = ", urlInfo.query);
	
    res.writeHead(200, {
    		'Content-Type': 'text/html;charset=UTF-8',
    	});
    res.write('<html><head><title>test06</title></head>\n');
    res.write('<body><h1>test06</h1>\n');
    res.write('<p>안녕하세요!</p>\n');
    res.end('</body></html>\n');
    
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');










