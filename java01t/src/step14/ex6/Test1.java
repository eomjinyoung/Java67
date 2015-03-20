package step14.ex6;

/* 예외 처리 문법
 * - 메서드에서 오류 상황을 호출자에게 알리는 방법
 * - 문법
 *   1) 오류 전달: throw [Throwable 객체];
 *   2) 메서드에 오류 타입을 선언해야 한다.
 *      void m() throws 오류타입1, 오류타입2, ... {
 *        ...
 *      }
 * - 예제
 *   void m() throws Throwable {
 *        ...
 *        throw new Throwable("오류 내용");
 *        ...
 *   }
 *
 * - 오류를 던지는 메서드를 호출할 때,
 *   try {
 *     오류를 던지는 메서드 호출
 *   } catch (오류타입1 변수) {
 *     오류 처리
 *   } catch (오류타입2 변수) {
 *     오류 처리
 *   } finally {
 *     마무리 작업
 *   }
 *   
 * 예외 처리 문법이 필요한 이유?
 * 1) 도입 전
 *   - 예외 상황을 리턴 값으로 호출자에게 전달하였다. => 상세 예외 상황을 전달할 수 없다.
 *   - 작업 코드와 예외 처리 코드가 마구 섞여 있었다. => 코드 가독성을 떨어 뜨린다.  
 *   - 심각한 오류인 경우 즉시 프로그램을 멈췄다. => 서버 프로그램에 적합하지 않았다.
 * 2) 도입 후
 *   - 예외 상황을 인스턴스에 담아 리턴한다. => 상세 정보 전달 가능.
 *   - try...catch 로 작업 코드와 예외 처리 코드 분리한다. => 가독성 좋다.
 *   - 시스템 예외를 잡을 수 있다. => 치명적인 예외가 발생하더라도 시스템을 멈출 필요가 없다. 
 *   
 * 예외 객체의 종류
 * Throwable
 *   - Error : JVM이 발생시키는 오류. try... catch...를 사용하지 않아도 된다.
 *             왜? 어차피 개발자가 처리할 문제가 아니니까.
 *             try... catch...를 사용하여 예외를 처리하든 안하든 컴파일할 때 따지지 않는다.
 *             개발자가 Error 예외에 대해서도 try... cath...를 사용한다면,
 *             그것은 프로그램을 종료하기 전에 기록을 남기기 위함이다.
 *             또는 아주 가벼운 예외이던가...
 *             개발자가 특별한 경우가 아니면, Error 계열의 예외를 던져서는 안된다.
 *             "시스템 예외"라고 한다.
 *   - Exception : 프로그램이 발생시키는 오류. 개발자가 발생시키는 오류. 
 *                 "애플리케이션 예외"라고 한다.
 *                 개발자가 오류의 특별한 상황을 호출자에게 알리기 위해 발생시킴.
 *                 호출자는 반드시 try... catch... 를 사용하여 처리해야 함.
 *                 왜? 오류 발생했다고 시스템 멈추지 말라! 계속 실행할 수 있도록 적절히 
 *                 처리하라는 뜻이다. 
 *     - RuntimeException : Exception 계열의 클래스인데도 불구하고, 
 *             Error의 경우처럼 try... catch...를 사용하지 않아도 된다.
 *             왜? 실행 중에 발생된 오류로서 예외 상황을 상위 호출자에게 바로 전달하기 위해.
 *             중간에 위치한 호출자들의 불편함을 줄이고 싶을 때 이 예외를 던진다.
 *   
 */

public class Test1 {

  // 개발자가 명시적으로 예외 상황에 대해 호출자에게 알린다.
  static int divide(int a, int b) throws Throwable {
    if (b == 0) 
      throw new Throwable("0로 나눌 수 없습니다.");
    
    return a / b;
  }
  
  // JVM에게 발생시키는 예외를 던지기
  // Error 계열의 예외는 메서드 선언에 어떤 타입의 오류를 던지는지 선언할 필요가 없다.
  // 프로그램에서 개발자가 Error를 던지는 경우는 없다. 다음 예는 그냥 테스트를 위해 만듦.
  static int divide2(int a, int b) {
    if (b == 0) 
      throw new Error("0로 나눌 수 없습니다.");
    
    return a / b;
  }
  
  public static void main(String[] args) {
    try {
      int result = divide(10, 0);
      //return; // return을 하기 전에 finally 블록을 먼저 실행한다.
      
    } catch (Throwable ex) {
      System.out.println(ex.getMessage());
      //return; // return을 하기 전에 finally 블록을 먼저 실행한다.
      
    } finally { //선택 블록
      // 오류가 나든 안나든 반드시 실행한다.
      // try 블록이나 catch 블록을 나가기 전에 반드시 실행한다.
      System.out.println("마무리 작업");
    }

    // Error 계열 예외를 던지는 메서드는 그냥 호출해도 된다. 
    // 다만, 예외가 발생하는 즉시 실행을 멈춘다.
    //int result = divide2(10, 0);
    
    // 다음과 같이 명시적으로 try... catch...를 사용하여 예외를 처리할 수도 있다.
    // => 예외 상황을 기록하고, 프로그램을 종료하기 전에 사용했던 자원을 해제하기 위해. 
    try {
      int r = divide2(10, 0);
    } catch (Error ex) {
      System.out.println("예외 상황 기록함...");
    } finally {
      System.out.println("DB 연결을 해제하거나, 네트웍 연결을 해제, 파일을 닥기...");
    }
    
  }

}








