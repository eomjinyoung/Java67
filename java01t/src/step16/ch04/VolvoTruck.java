package step16.ch04;


public class VolvoTruck {
  String  model;
  int     hp;
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
    int rs = 0;
    if (weight > 0 && weight < 10000) {
      rs = 2;
    } else if (weight >= 10000 && weight < 50000) {
      rs = 4;
    } else if (weight >= 50000) {
      rs = 6;
    } else {
      rs = 0;
    }
    
    if (speed < 200)
      speed += (10 - rs);
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
  public int getHp() {
    return hp;
  }
  public void setHp(int hp) {
    this.hp = hp;
  }
  public int getWeight() {
    return weight;
  }
  public void setWeight(int weight) {
    this.weight = weight;
  }
 
  
  
}
