package step16.ch06;

// Car 클래스의 추상 메서드인 accelerate()를 반드시 구현해야 한다.

public class Tico extends Car {
  int     cc;
  int     capacity;
  
  // 이 메서드는 추상 메서드이기 때문에, 
  // 다음과 같이 서브 클래스에서 반드시 구현해야 한다.
  @Override
  public void accelerate()  {
    if (speed < 150)
      speed += 10;
    dashboard();
  }
  
  public int getCc() {
    return cc;
  }
  public void setCc(int cc) {
    this.cc = cc;
  }
  public int getCapacity() {
    return capacity;
  }
  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }
  
  
}
