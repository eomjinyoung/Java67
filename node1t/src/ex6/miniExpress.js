var http = require('http');
var url = require('url');
var querystring = require('querystring'); 

var mapGetHandler = {};
var mapPostHandler = {};

exports.get = function(path, callback) {
	mapGetHandler[path] = callback;
};

exports.post = function(path, callback) {
	mapPostHandler[path] = callback;
};


exports.listen = function(port) {
	http.createServer(function(req, res) {
		var urlInfo = url.parse(req.url, true);
		
		var params;
		if (req.method == 'GET') {
			var handler = mapGetHandler[urlInfo.pathname];
			
			if (handler) {
				req.params = urlInfo.query;
				handler(req, res);
			} else {
				notSupported(req, res);
			}
		} else if (req.method == 'POST') {
			var messageBody = ''; 
			req.on('data', function(data) { 
	 			messageBody += data;
	 		});
	 		req.on('end', function() {
	 			req.params = querystring.parse(messageBody);
	 			var handler = mapPostHandler[urlInfo.pathname];
	 			
	 			if (handler) {
					handler(req, res);
				} else {
					notSupported(req, res);
				}
	 		});
		}
	}).listen(port, '192.168.103.67');
	console.log('Server running');
};

function notSupported(req, res) {
	res.writeHead(200, {'Content-Type': 'text/html;charset=UTF-8'});
	res.write('<html><head><title>mini express</title></head>\n');
	res.write('<body>');
	res.write('<p>해당 URL을 지원하지 않습니다.');
	res.end('</body></html>\n');
}










