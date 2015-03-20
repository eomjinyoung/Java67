package step14.ex6;

// RuntimeException을 사용하는 경우
// - 최상위 호출자에게 오류를 쉽게 전달하고 싶을 때.
// - 중간 호출자에게 불편함 주는 것을 줄이기 위해.
// - 메서드에서 발생된 모든 예외를 특정 클래스에서 통합 처리하고자 할 때 적합한 예외다.
public class Test4 {
  
  // m1()에서도 m2()가 일반 메서드라고 생각한다.
  // => m2()에서 발생된 예외는 m1()을 호출한 자 "main()"에게 자동 전달된다.
  static void m1() {
    m2();
  }
  
  // m2()는 m3()가 예외를 던진다고 생각하지 않는다.
  // 왜? m3() 선언부에 throws 문장이 없기 때문이다.
  // => m3()에서 발생된 예외는 m2() 호출한 자 "m1()"에게 자동 전달된다.
  static void m2() {
    m3(); 
  }
  
  //RuntimeException은 메서드 선언부의 throws 문장에 추가하지 않아도 된다.
  //- 자동으로 호출자에게 전달된다.
  //- m3()의 호출자는 m3()가 RuntimeException 예외를 던지는 줄 모른다.
  static void m3() /*throws RuntimeException*/ {
    System.out.println("오호라...m3()");
    throw new RuntimeException("m3()에서 던지는 예외!!!");
  }
  
  public static void main(String[] args) {
    // m3()가 발생시킨 RuntimeException을 받고 싶다면 다음과 같이 try...catch...를
    // 사용한다.
    try {
      m1();
    } catch (RuntimeException ex) {
      System.out.println(ex.getMessage());
    }
    
    // m3()에서 발생시킨 예외를 받지 않아도 된다.
    // 대신, 프로그램은 즉시 멈출 것이다. 왜? 예외 발생하면 JVM은 멈춘다.
    // => 결론, m3()가 발생시킨 예외에 대해 JVM이 임의적으로 처리하는 것을 막고 싶다면,
    // 위에서 처럼 try... catch...를 사용하라!
    //
    // 즉, RuntimeException은 try... catch...를 사용하지 않기 위해 만든 문법이 아니라,
    // 중간 호출자가 예외 선언하는 불편을 해소하기 위해 만든 문법이다.
    // 그러니, 최종 호출자에서는 처리하는 것이 좋다.
    m1();
    
    System.out.println("프로그램 마무리 작업....");
  }

}








