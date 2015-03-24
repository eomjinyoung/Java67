package step16.ch06;

// 이 클래스를 직접 사용하지 못하게 만든다.
// => 추상 클래스로 선언한다.
public abstract class Car {
  protected String model;
  protected int speed;

  public Car() {
    super();
  }

  public void dashboard() {
    System.out.printf("속도: %dkm/h\n", this.speed);
  }
  
  //서브 클래스에서 자신의 차종에 맞게끔 재정의해야 한다.
  //=> 추상 메서드로 선언한다.
  public abstract void accelerate();

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