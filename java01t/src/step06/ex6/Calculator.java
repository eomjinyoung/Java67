package step06.ex6;

/* 결과를 저장할 변수로 클래스 변수를 사용함
 * 
 */
public class Calculator {
  //계산 결과를 저장할 클래스 변수
  public static int result;
 
  //결과 값을 담을 변수를 초기화시키는 메서드 
  public static void init(int value) {
    result = value;
  }
  
  public static void plus(int value) {
    result += value;
  }
  
  public static void minus(int value) {
    result -= value;
  }
  
  public static void multiple(int value) {
    result *= value;
  }
  
  public static void divide(int value) {
    result /= value;
  }
  
  public static void remainder(int value) {
    result %= value;
  }
}














