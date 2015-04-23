var http = require('http');
var url = require('url');

// 실습 목표: 이름을 파라미터로 받아서 인사하기
//
http.createServer(function(req, res) {
	console.log("------------------------------");
	var urlInfo = url.parse(req.url, true);
	var path = urlInfo.pathname;
	var name = urlInfo.query.name;
	
    res.writeHead(200, {
    		'Content-Type': 'text/html;charset=UTF-8',
    	});
    res.write('<html><head><title>test08</title></head>\n');
    res.write('<body><h1>test08</h1>\n');
    res.write('<p>안녕하세요! ' + name + '님</p>\n');
    res.end('</body></html>\n');
    
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');










