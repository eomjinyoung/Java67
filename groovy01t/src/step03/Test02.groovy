package step03

/* 실습 목표: 변수 선언과 값 할당 */

// 1. 동적 타입 바인딩
// - 값을 할당할 때 변수의 타입이 결정된다.
def a = 20  
println a

a = "홍길동"
println a

b = "임꺽정"  //def를 생략해도 된다.
println b

println "-----------------------------------"

// 2. 정적 타입 바인딩
// - 변수를 선언할 때 타입을 고정시키는 것
int c = 20
println c

//c = "홍길동"   // 실행할 때 오류 발생!
//println c
println "-----------------------------------"

// 3. 문자열과 자동 형변환
String d = "홍길동"
d = 20      // 20이라는 숫자를 "20" 문자열로 변환하여 d 변수에 넣는다.
println d
println "-----------------------------------"

// 4. 자바 변수 선언 가능!
java.util.Date e = new java.util.Date()
println e

//Method m = null; // 클래스의 패키지를 임포트 하지 않아서 오류 발생!
Date f = new Date();  //java.util 패키지를 기본으로 임포트 한다.
Socket g = null;      // java.net 패키지를 기본으로 임포트 한다.
File h = null;        // java.io 패키지를 기본으로 임포트 한다.

println "-----------------------------------"











