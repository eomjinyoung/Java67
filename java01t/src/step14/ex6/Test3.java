package step14.ex6;

// Exception을 사용하여 예외를 호출자에게 전달하는 경우
// - m3()에서 발생된 예외를 main()에서 처리하려면,
//   m1(), m2() 처럼 중간 호출자도 메서드 선언부에 throws 문장을 선언해야 한다.
// - 명확해서 좋지만, 호출 단계가 많을 경우는 매우 불편하다.
// - 해결책: RuntimeException을 사용!
//   Test3.java를 참고하라.
public class Test3 {
  
  // m2()에서 발생된 예외를 상위 호출자에게 전달하고 싶다면, 직접 처리하지 말고
  // 그냥 메서드 선언부에 m2()가 발생시키는 예외를 선언하라!
  static void m1() throws Exception {
    m2();
  }
  
  static void m2() throws Exception {
    //m3()에서 발생된 예외를 main에서 처리하고 싶다면, 
    // 다음과 같이 이 메서드에서 예외를 처리하면 안된다.
    /*
    try {
      m3();
    } catch (Exception ex) {
      //m3()에서 발생된 예외 처리...
    }
    */
    
    // 그냥 호출하라. 
    // 대신 메서드 선언부에 이 메서드에서 어떤 예외가 발생할 수 있는지 선언하라.
    m3(); 
  }
  
  //m3()에서 예외를 던진다면? m2()에서 처리해야 함.
  // 어? m3()에서 예외를 던지지 않는데(throw 명령 없다),
  // 왜 m2()에서 예외를 처리해야 하는가?
  // => m3() 메서드 선언부에 Exception을 던진다고 되어 있기 때문이다.
  // => 진짜 예외를 던지고 안던지고 중요하지 않다. 메서드 선언부에 예외를 던진다고 선었했으면,
  //    호출자는 예외를 처리해야 한다.
  //
  // m2() 발생된 예외는 어떻게 처리하는가? m1()에서는 자신의 호출자에게 그냥 전달한다.
  static void m3() throws Exception {
    System.out.println("오호라...m3()");
    throw new Exception("m3()에서 던지는 예외!!!");
  }
  
  public static void main(String[] args) {
    // Exception을 사용할 때 불편한 점 실습
    // m3()에서 발생된 예외를 main()에서 처리하고자 할 때.
    try {
      m1();
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
  }

}








