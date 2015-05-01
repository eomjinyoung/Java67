var express = require('express');
var app = express();
var example = require('./routes/example');
var board = require('./routes/board');
var classroom = require('./routes/classroom')
var crphoto = require('./routes/crphoto')
var lecappl = require('./routes/lecappl')
var lecteach = require('./routes/lecteach')
var lecture = require('./routes/lecture')
var manager = require('./routes/manager')
var student = require('./routes/student')
var subject = require('./routes/subject')
var teacher = require('./routes/teacher')
var teachsub = require('./routes/teachsub')

//정적 파일이 있는 폴더를 등록한다.
//- app.use('/가상폴더', express.static('진짜폴더'));
//- 만약 가상폴더를 지정하지 않으면 기본 경로는 루트(/) 이다.
app.use(express.static('public'));
app.use('/example', example);
app.use('/board', board);
app.use('/classroom', classroom);
app.use('/crphoto', crphoto);
app.use('/lecappl', lecappl);
app.use('/lecteach', lecteach);
app.use('/lecture', lecture);
app.use('/manager', manager);
app.use('/student', student);
app.use('/subject', subject);
app.use('/teacher', teacher);
app.use('/teachsub', teachsub);

app.get('/', function (req, res) {
  res.send('Hello World!');
});

var server = app.listen(3000, function () {

  var host = server.address().address;
  var port = server.address().port;

  console.log('Example app listening at http://%s:%s', host, port);

});