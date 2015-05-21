package step03

/* 실습 목표: 반복문 사용 */

// while 문
def n = 0
while (n < 10) {
  print n + ","
  n++
}
println "\n---------------------------"

// for 문 
for (int i = 0; i < 10; i++) {print i + ","}
println "\n---------------------------"

for (i in 0..9) {print i + ","}
println "\n---------------------------"

for (i in [100, 90, 80, 70]) {print i + ","}
println "\n---------------------------"

for (entry in ["kor":100,"eng":90,"math":80]) {
  println entry.key + "=" + entry.value
}
println "\n---------------------------"

def scoreMap = ["kor":100,"eng":90,"math":80]
for (v in scoreMap.values()) {print v + ","}
println "\n---------------------------"

//문자열의 각 항목을 배열처럼 꺼낼 수 있다.
for (c in "ABCDE홍길동") {print c + ","}
println "\n---------------------------"

// eachXXX(클로저) 메서드
// 1) 클로저(closure)? 메서드
// 2) 클로저 작성 문법
//    {파라미터명, 파라미너명 -> 코드...}
// 3) 클로저는 실제 익명 중첩 클래스로 변환된다.
//    {a, b -> return a + b}
//    =>
//    new Object() {
//      public void 임의의메서드명(Object a, Object b) {
//        return a + b;
//      }
//    }
def scores = [100, 90, 80, 70, 60];
scores.each({element -> print element + ","})
println "\n---------------------------"

scores.eachWithIndex ({element, i -> 
  print element + "[" + i + "],"
})
println "\n---------------------------"

def scoreMap2 = ["kor":100,"eng":90,"math":80]
scoreMap2.each({key, value -> println key + ":" + value})
println "\n---------------------------"






















