package step03

/* 실습 목표: 메서드와 클로저 사용 */

//1. 메서드 정의
// - 리턴 값 있음
def plus(a, b) {
  a + b  // 마지막 문장의 실행 값이 리턴된다.
}

println plus(10, 20)

// - 리턴 값 없음
def plus2(a, b) {
  println (a + b) // 마지막 문장의 실행 결과가 없다면 null을 리턴한다.
}

println plus2(10, 20)

println "-------------------------"

//2. 클로저 정의
def f1 = {a, b -> a + b}
// javascript: var f1 = function(a, b) { return a + b;}
println f1(10, 20)

// - 클로저 free 변수 => 자바스크립트의 바깥 함수의 변수
def pi = 3.14;
def f2 = {radius ->
  pi * radius * radius // pi를 free 변수라고 부른다.
}
println f2(20)

// - it 파라미터 => 자바스크립의 arguments 변수와 같다.
def f3 = {
  it[0] + it[1] // it를 사용하려면, 파라미터 값이 배열로 넘어와야 한다.
}
println f3([20, 60]) 

println "-------------------------"

//3. 파라미터 넘기는 다양한 방법
def f4(a, b) {
  a + b
}

// 메서드를 호출할 때 괄호()를 사용하여 그 안에 파라미터 값을 둔다.
def result = f4(10, 20);  
println result  

// 그루비에서는 메서드를 호출할 때 괄호()를 생략하고, 파라미터 값을 넘길 수 있다.
def result2 = f4 100, 200 
println result2

println "------------------------------------"
def f5(map) {
  for (entry in map) {
    println entry.key + ":" + entry.value
  }
}

// 맵 객체 넘기기
f5(["kor":100,"eng":80,"math":100])
println "------------------------------------"

// 맵 객체를 넘길 때 괄호()를 생략할 수 있다.
// 단 괄호를 생략할 때는 대괄호[]도 같이 제거해야 한다.
f5 "kor":100,"eng":80,"math":100
println "------------------------------------"


// 클로저 넘기기
def f6(cb) {
  cb(10, 20)
}

f6({a, b -> println (a + b)}) // 더하기를 계산하는 함수(클로저)를 넘긴다.
f6({a, b -> println (a - b)}) // 빼기를 계산하는 함수(클로저)를 넘긴다.
f6({a, b -> println (a * b)}) // 곱하기를 계산하는 함수(클로저)를 넘긴다.
f6({a, b -> println (a / b)}) // 나누기를 계산하는 함수(클로저)를 넘긴다.

f6 {a, b -> 
  println (a + b)
} // 함수 호출할 때 괄호 생략하기 
println "------------------------------------"

def f7(cb) {
  cb()
}

f7({
  a = 20
  b = 30
  println "결과=" + (a + b)
  println "하하하"
}) // 함수(클로저)를 파라미터로 넘기기

f7 {
  a = 70
  b = 80
  println "결과=" + (a + b)
  println "푸헐..."
}


















