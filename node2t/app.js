var express = require('express');
var app = express();
var bodyParser = require('body-parser');
var multer = require('multer');


var example = require('./routes/example');
var board = require('./routes/board');
var classroom = require('./routes/classroom')
var crphoto = require('./routes/crphoto')
var lecappl = require('./routes/lecappl')
var lecteach = require('./routes/lecteach')
var lecture = require('./routes/lecture')
var manager = require('./routes/manager')
var signup = require('./routes/signup')
var student = require('./routes/student')
var subject = require('./routes/subject')
var teacher = require('./routes/teacher')
var teachsub = require('./routes/teachsub')

app.use(bodyParser.urlencoded({ extended: true }));

//정적 파일이 있는 폴더를 등록한다.
//- app.use('/가상폴더', express.static('진짜폴더'));
//- 만약 가상폴더를 지정하지 않으면 기본 경로는 루트(/) 이다.
app.use(express.static('public'));

//노드 모듈 사용 설정
app.use(multer({
    dest: "./public/manager/img"
}));

//GET, POST 요청을 처리할 자바스크립트를 지정 
app.use('/example', example);
app.use('/board', board);
app.use('/classroom', classroom);
app.use('/crphoto', crphoto);
app.use('/lecappl', lecappl);
app.use('/lecteach', lecteach);
app.use('/lecture', lecture);
app.use('/manager', manager);
app.use('/signup', signup);
app.use('/student', student);
app.use('/subject', subject);
app.use('/teacher', teacher);
app.use('/teachsub', teachsub);

app.get('/', function (req, res) {
  res.send('Hello World!');
});

var server = app.listen(3000, '127.0.0.1', function () {

  var host = server.address().address;
  var port = server.address().port;

  console.log('Example app listening at http://%s:%s', host, port);

});