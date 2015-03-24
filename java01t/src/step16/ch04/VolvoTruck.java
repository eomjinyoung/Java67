package step16.ch04;


public class VolvoTruck {
  String  model;
  int     cc;
  int     speed; //km/h
  int     weight;
  
  public void dashboard() {
    System.out.printf("속도: %dkm/h\n", this.speed);
    System.out.printf("중량: %dkg\n", this.weight);
  }
  
  public void load(int weight) {
    this.weight += weight;
    dashboard();
  }
  
  public void dump() {
    weight = 0;
    dashboard();
  }
  
  public void accelerate() {
    if (speed < 200)
      speed += 5;
    dashboard();
  }
  
  public void reduce() {
    if (speed > 0) 
      speed -= 5;
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
  public int getWeight() {
    return weight;
  }
  public void setWeight(int weight) {
    this.weight = weight;
  }
 
  
  
}
