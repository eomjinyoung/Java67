package step10.ex3;

// 메서드에 final을 선언하여 오버라이딩 못하게 한다.
// - 재정의 하지 말아야 할 중요한 메서드에 대해 사용한다.
public class B {
  public void print(int money, int customerLevel) {
    float result = money + money * interest(customerLevel);
    System.out.printf("원금(%d), 총금액(%.1f)\n", money, result);
  }
  
  //자식 클래스에서 임의로 재정의 할 수 없게 만든다.
  //- 이자율을 구하는 메서드는 print()에서 사용한다.
  //- 서브 클래스에 이 메서드를 바꾸게 된다면 전혀 다른 결과를 내게 된다.
  //- 어떤 프로젝트에서는 특정 메서드를 함부로 바꿀 수 없도록 하기 위해
  //  재정의를 막는 경우가 있다.
  public final float interest(int level) {
    switch(level) {
    case 1:
      return 0.0175f;
    case 2:
      return 0.025f;
    case 3:
      return 0.05f;
    default:
      return 0.002f;
    }
  }
}
