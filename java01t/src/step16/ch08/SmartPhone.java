package step16.ch08;

// 스마트폰도 밧데리 규칙에 따라 구현한다.
// 이 객체도 밧데리 테스트를 할 수 있다.
public class SmartPhone implements Battery {
  int battery;
  String telNo;
  
  
  @Override
  public void charge(int kwh) {
    battery = kwh;
    
  }

  @Override
  public float getBatteryState() {
    float result = ((battery / 10.f) * 100);
    return (result > 100)? 100.f : result;
  }
  
}







