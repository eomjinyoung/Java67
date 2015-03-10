package step05;

// 파라미터와 리턴 타입이 있는 메서드

public class Test06 {
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
  
  public static void main(String[] args) {
    int v1 = 10, v2 = 20;
    
    // 아규먼트를 넘기고 결과를 받는 메서드 호출 예
    int result = plus(v1, v2);
    
    System.out.println(result);
    
    //메서드의 아규먼트로 메서드를 호출하는 예 
    System.out.println(minus(v1, v2));
    System.out.println(multiple(v1, v2));
    System.out.println(divide(v1, v2));

  }

}











