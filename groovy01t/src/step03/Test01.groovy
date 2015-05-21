package step03

/* 실습 목표: 클래스 이름을 지정하지 않고 난장에 그대로 스크립트 작성
 * 1) 클래스 이름은 그루비 소스 파일 이름을 사용한다.
 * 2) 바깥에 작성한 코드는 run() 메서드 안에 순서대로 삽입된다.
 * 3) 메서드 선언은 그대로 메서드 선언부에 놓인다.
 *  
 */

a = 10
print a
print "-->"
println plus(10, 20)

def plus(x, y) {
  x + y
}

println "오호라... "


/* 위의 코드는 다음 자바 코드와 같다.
 * [그루비 클래스 실행]
 * 1. 그루비 컴파일러(groovyc)
 * - .groovy --(groovyc)--> .java  --(javac)--> .class 컴파일한다.
 * 
 * 2. 실행 원리
 * - 자동 생성된 main() 메서드가 run() 메서드를 호출한다.
 *  
public class Test01 extends groovy.lang.Script {
  public static void main(String[] args) {
    run();
  }
  
  public Object run() {
    a = 10
    print a
    print "-->"
    println plus(10, 20)
    
    println "오호라... "
  }
  
  public Object plus(Object x, Object y) {
    return x + y;
  }
}
 */










