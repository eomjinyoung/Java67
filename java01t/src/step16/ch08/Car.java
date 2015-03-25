package step16.ch08;

// ICar 규칙에 따라 Car 클래스를 선언한다.
// => 이 클래스의 목적은 하위 클래스에 공통 속성과 기능을 상속해주는 용도이기 때문에 
//    추상 클래스로 선언한다.
// => 또한 ICar 규칙에 정의된 일부 기능을 구현하여, 서브 클래스 만들기 편하도록 물려 준다. 
public abstract class Car implements ICar {
  protected String model;
  protected int speed;

  public Car() {
    super();
  }

  public void dashboard() {
    System.out.printf("속도: %dkm/h\n", this.speed);
  }
  
  public void reduce() {
    if (speed > 0) 
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

}