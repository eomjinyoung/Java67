package step16.ch04;


public class Tico {
  String  model;
  int     cc;
  int     capacity;
  int     speed; //km/h
  
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
