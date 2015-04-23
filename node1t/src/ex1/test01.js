//1. http 객체 가져오기 
// - require(객체명)
// - nodejs에서 제공하는 기본 객체는 www.nodejs.org/api 참조하라.
var http = require('http');

//2. HTTP 서버 생성하기
// - createServer(클라이언트의 요청이 들어 왔을 때 호출될 함수);
// - 클라이언트의 요청이 들어 왔을 때 호출될 함수? 요청 처리 리스너라 부른다.
// - 클라이언트가 이 웹 서버에게 HTTP 요청을 하면 이벤트가 발생하고,
//   nodejs는 이 이벤트를 처리할 함수를 호출한다.

//1) 요청 처리 함수를 만든다.
function requestListener(req, res) {
  res.writeHead(200, {'Content-Type': 'text/plain'});
  res.end('Hello World\n');
}

//2) HTTP 서버 역할을 수행할 객체를 만든다.
var httpServer = http.createServer(requestListener);

//3) 웹 서버를 가동한다.
httpServer.listen(1338, '127.0.0.1');

//4) 웹 서버 시작 후 사용자에게 간단한 안내 문구 출력한다.
console.log('Server running at http://127.0.0.1:1338/');

// 위 코드의 단축 코드 
/*
http.createServer(function handler(req, res) {
    res.writeHead(200, {'Content-Type': 'text/plain'});
    res.end('Hello World\n');
}).listen(1337, '127.0.0.1');
console.log('Server running at http://127.0.0.1:1337/');
*/










