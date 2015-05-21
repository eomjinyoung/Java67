package step03

/* 실습목표: 조건문 사용 */

def a = 20

if (a < 20) {
  println "20 미만입니다."
} else if (a == 20) {
  println "20입니다."
} else {
  println "20 초과입니다."
}

println "---------------------------------"

// 조건 연산자
def b = 17
println ((b % 2) == 0 ? "짝수입니다":"홀수입니다")
println "---------------------------------"

// switch 
def x = "300"
def result = ""

switch (x) {
  case "aaa": result = "aaaa"; break
  case "123": result += "123"; break
  case [1, 20, 3.14, true, "ok"]: println "헐..."; break
  case 100..200: println "100~200 값이다."; break
  case Number: println "숫자이다"; break;
  default: println"해당 사항 없음!";
}
println result







