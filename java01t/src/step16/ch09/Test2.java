package step16.ch09;

//실습 목표: 인터페이스 상속
// => 인터페이스도 상속 받을 수 있다.
public class Test2 {
  static interface Battery {
    void charge();
    float getState();
  }
  
  // 기존의 Battery 규칙에 새 규칙 추가 
  static interface AdvancedBattery extends Battery {
    void highSpeedCharge();
  }
  
  // 기존의 규칙에 새 규칙 추가
  static interface ExtensionBattery extends AdvancedBattery {
    void append(Battery battry);
  }
  
  // 인터페이스 구현 예:
  static class BitBattery1 implements Battery {
    @Override public void charge() {}
    @Override public float getState() {return 0;}
  }
  
  // AdvancedBattery 인터페이스가 상속 받은 메서드도 구현해야 한다!
  static class BitBattery2 implements AdvancedBattery {
    @Override public void charge() {}
    @Override public float getState() {return 0;}
    @Override public void highSpeedCharge() {}
  }
  
  static class BitBattery3 implements ExtensionBattery {
    @Override public void charge() {}
    @Override public float getState() {return 0;}
    @Override public void highSpeedCharge() {}
    @Override public void append(Battery battry) {}
  }
}











