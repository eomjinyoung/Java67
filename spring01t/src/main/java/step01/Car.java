package step01;

import java.util.Date;

public class Car {
  String  model;
  int     capacity;
  Date    outDate;
  
  public Car() {
    System.out.println("Car() 생성");
  }
  
  public Car(String model, int capacity) {
    this.model = model;
    this.capacity = capacity;
  }
  
  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    this.model = model;
  }
  public int getCapacity() {
    return capacity;
  }
  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }
  public Date getOutDate() {
    return outDate;
  }
  public void setOutDate(Date outDate) {
    this.outDate = outDate;
  }
  
  
}
