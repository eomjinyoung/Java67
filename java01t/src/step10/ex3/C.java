package step10.ex3;

// 값을 한 번 할당한 후, 변경하지 말아야 하는 경우.
// - 예) 파라미터 변수, 상수 변수
public class C {
  // 상수값도 final로 선언한다.
  // 또한, 인스턴스 마다 바꾸는 값이 아니기 때문에 static으로 만든다.
  static final int SILVER = 1;
  static final int GOLD = 2;
  static final int DIAMOND = 3;
  
  // 파라미터 변수는 보통 final을 선언하여 메서드 내에서 값을 변경하지 못하게 한다.
  public void print(final int money, final int customerLevel) {
    //파라미커 값을 임의적으로 바꿀 수 있다. 안돼~~~.
    //money = 200;  //문법오류! final 변수이기 때문이다. 
    
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
    case SILVER:
      return 0.0175f;
    case GOLD:
      return 0.025f;
    case DIAMOND:
      return 0.05f;
    default:
      return 0.002f;
    }
  }
}
