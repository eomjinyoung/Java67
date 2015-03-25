package step16.ch08;

// Car를 상속 받는다.
// - dashboard()와 accelerate()는 이 클래스에 맞게끔 오버라이딩 한다.
// - load()와 dump() 기능을 추가한다.
//
public class VolvoTruck extends Car {
  int     hp;
  int     weight;
  
  //dashboard(): 기존 출력에다가 다른 출력 기능을 덧 붙일 때,
  @Override 
  public void dashboard() {
    super.dashboard(); // 기존의 속도 출력 기능은 그대로 활용!
    System.out.printf("중량: %dkg\n", this.weight); // 추가로 출력!
  }
  
  public void load(int weight) {
    this.weight += weight;
  }
  
  public void dump() {
    weight = 0;
  }
  
  // accelerate()는 이 클래스에 맞게끔 완전히 재정의한다.
  @Override
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
