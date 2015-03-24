package step16.ch05;

// 상속:일반화를 통해 뽑은 클래스
// - Tico와 VolvoTruck의 공통 속성과 메서드를 추출하여 정의하였다.
public class Car {
  protected String model;
  protected int speed;

  public Car() {
    super();
  }

  public void dashboard() {
    System.out.printf("속도: %dkm/h\n", this.speed);
  }
  
  public void accelerate() {
    if (speed < 150)
      speed += 10;
    dashboard();
  }

  public void reduce() {
    if (speed > 0) 
      speed -= 10;
    dashboard();
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

}