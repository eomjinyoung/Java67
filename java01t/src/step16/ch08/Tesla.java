package step16.ch08;

// Tesla는 자동차이기 때문에 ICar 규칙에 따라 작성한다.
// 또한, Tesla는 밧데리를 사용하는 장비이기 때문에 Baterry 규칙을 준수한다.
// => 한 클래스가 여러 규칙을 준수하는(여러 개의 인터페이스를 구현하는) 경우를 보여주고 있다.
//
// => 다음과 같이 인터페이스는 다중 구현이 가능하다.
public abstract class Tesla implements ICar, Battery {
  String  model;
  int     battery;
  int     speed;
  
  @Override
  public void charge(int kwh) {
    battery = kwh;
  }
  
  @Override
  public float getBatteryState() {
    return (battery / 60.f) * 100;
  }
  
  public void dashboard() {
    System.out.printf("모델명: %s\n", model);
    System.out.printf("충전상태: %.1f%%\n", (battery/60.f) * 100);
    System.out.printf("속도: %dkm/h\n", speed);
  }
  
  public void accelerate() {
    speed += 15;
  }
  
  public void reduce() {
    speed -= 10;
  }
  
  public void stop() {
    speed = 0;
  }
  
  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    this.model = model;
  }
  public int getBattery() {
    return battery;
  }
  public void setBattery(int battery) {
    this.battery = battery;
  }
  public int getSpeed() {
    return speed;
  }
  public void setSpeed(int speed) {
    this.speed = speed;
  }
  
  
}
