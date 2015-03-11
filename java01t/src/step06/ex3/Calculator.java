package step06.ex3;

//메서드를 분류한 후
//ex1.Test -> 계산과 관련된 메서드를 분류하여 정의함.
public class Calculator {
  //메서드 앞에 접근 범위에 대한 설정이 붙지 않았다. 즉, default이다.
  static int plus(int a, int b) {
    return a + b;
  }
  
  static int minus(int a, int b) {
    return a - b;
  }
  
  static int multiple(int a, int b) {
    return a * b;
  }
  
  static int divide(int a, int b) {
    return a / b;
  }
  
  //private - 클래스 안에서만 사용할 수 있다. 
  private static int remainder(int a, int b) {
    return a % b;
  }
}














