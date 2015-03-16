package step10.ex3;

public class ChildOfB extends B {
  @Override
  public void print(int money, int customerLevel) {
    System.out.println("-----------------------");
    super.print(money, customerLevel);
    System.out.println("-----------------------");
  }
  
  // 수퍼 클래스의 final 메서드는 재정의 할 수 없다.
  // 다음은 문법 오류!
  /*
  public float interest(int level) {
    //...
  }
  */
}
