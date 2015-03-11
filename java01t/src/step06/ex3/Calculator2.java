package step06.ex3;

// 다른 패키지에서도 메서드를 호출할 수 있도록 
// 접근 범위를 넓힌다.
// - public으로 지정한다.
public class Calculator2 {
  //메서드 앞에 접근 범위에 대한 설정이 붙지 않았다. 즉, default이다.
  public static int plus(int a, int b) {
    return a + b;
  }
  
  public static int minus(int a, int b) {
    return a - b;
  }
  
  public static int multiple(int a, int b) {
    return a * b;
  }
  
  public static int divide(int a, int b) {
    return a / b;
  }
  
  public static int remainder(int a, int b) {
    return a % b;
  }
}














