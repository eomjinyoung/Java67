package step10.ex2;

//수퍼 클래스의 특정 메서드를 재정의한다.
public class Calc2 extends Calc {
  //Calc의 divide() 메서드를 0으로 나눌 수 없게 재정의한다.
  @Override
  public void divide(int a) {
    if (a == 0)
      return; //나누기 값이 0이면 즉시 메서드를 탈출한다. 즉, 아뭊것도 안한다.
    super.divide(a);
  }
}
