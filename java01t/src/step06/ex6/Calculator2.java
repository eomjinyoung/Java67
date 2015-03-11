package step06.ex6;

/* 인스턴스 변수
 * - 데이터를 개별적으로 관리할 필요가 있을 때 사용.
 * 
 * 목표!
 * - 결과 데이터를 저장할 변수를 개별적으로 관리해야 한다.
 * 
 * 해결책!
 * - 인스턴스 변수로 선언하라!
 * - static 선언을 빼라!
 */
public class Calculator2 {
  //계산 결과를 저장할 변수는 개별적으로 관리되는 인스턴스 변수가 된다.
  //인스턴스 변수는 반드시 new 연산자를 통해 만들어야 한다.
  public int result;
 
  //결과 값을 담을 변수를 초기화시키는 메서드 
  public static void init(Calculator2 that, int value) {
    that.result = value;
  }
  
  public static void plus(Calculator2 that, int value) {
    that.result += value;
  }
  
  public static void minus(Calculator2 that, int value) {
    that.result -= value;
  }
  
  public static void multiple(Calculator2 that, int value) {
    that.result *= value;
  }
  
  public static void divide(Calculator2 that, int value) {
    that.result /= value;
  }
  
  public static void remainder(Calculator2 that, int value) {
    that.result %= value;
  }
}














