var express = require('express');
var router = express.Router();

// middleware specific to this router
/*
router.use(function timeLog(req, res, next) {
  console.log('Time: ', Date.now());
  next();
});
*/

router.get('/', function(req, res) {
  res.send('example/');
});

router.get('/okok', function(req, res) {
  res.send('example/okok');
});

router.get('/okok/test.do', function(req, res) {
  res.send('example/okok/test.do');
});

module.exports = router;
