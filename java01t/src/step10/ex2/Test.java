package step10.ex2;

// 다형적 변수의 활용 예
// - 기존 객체를 자식 객체로 대체할 수 있다.
public class Test {

  static void compute(Calc calc) {
    calc.plus(10);
    calc.multiple(2);
    calc.divide(0);
    System.out.printf("결과 = %d\n", calc.result);
  }
  
  public static void main(String[] args) {
    //Calc를 사용하여 계산을 수행한다. => 0으로 나눌 경우 시스템 오류 발생!
    //compute(new Calc());
    
    //기존 Calc 대신 나누기 기능을 교정한 Calc2를 사용하기로 함.
    compute(new Calc2());
    
    //compute()메서드에서 원하는 것은 Calc 인스턴스 이다.
    //그런데, Calc2는 Calc의 자식 클래스이므로, Calc 자리를 대체할 수 있다.
    //=> 다형적 변수 규칙에 따라 수퍼 클래스의 자리를 자식 클래스가 대체할 수 있다.
    
  }

}














