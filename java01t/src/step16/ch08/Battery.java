package step16.ch08;

// 밧데리 테스트를 위한 규칙 정의
public interface Battery {
  void charge(int kwh);
  float getBatteryState();
}
