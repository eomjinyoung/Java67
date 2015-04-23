var http = require('http');
var url = require('url');

// 실습 목표: 특정 웹 애플리케이션 경로에 대해서만 처리하기
//
http.createServer(function(req, res) {
	var urlInfo = url.parse(req.url, true);
	
	res.writeHead(200, {
		'Content-Type': 'text/html;charset=UTF-8',
	});
	res.write('<html><head><title>test09</title></head>\n');
	res.write('<body>');

	if (urlInfo.pathname == '/hello') {
		var name = urlInfo.query.name;
		
	    res.write('<h1>test09</h1>\n');
	    res.write('<p>안녕하세요! ' + name + '님</p>\n');
	    
	} else {
		res.write('<p>해당 URL을 지원하지 않습니다!</p>');
	}

	res.end('</body></html>\n');
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');










