package step16.ch07;

public abstract class Tesla {
  String  model;
  int     battery;
  int     speed;
  
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
