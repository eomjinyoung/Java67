package step10.ex2;

// 계산기 기능 클래스
public class Calc {
  int result;
  
  public void plus(int a) {
    result += a;
  }
  
  public void minus(int a) {
    result -= a;
  }
  
  public void multiple(int a) {
    result *= a;
  }
  
  public void divide(int a) {
    result /= a;
  }
}
