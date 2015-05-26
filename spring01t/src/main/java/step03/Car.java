package step03;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Car {
  String  model;
  int     capacity;
  Date    outDate;
  Engine  engine;
  Tire[]  tires;
  List<CompactDisc> jukebox;
  Map<String,String> options;
  
  @Override
  public String toString() {
    return "Car [model=" + model + ", capacity=" + capacity + ", outDate="
        + outDate + ", engine=" + engine + ", tires=" + Arrays.toString(tires)
        + ", jukebox=" + jukebox + ", options=" + options + "]";
  }

  public Car() {
    System.out.println("Car() 생성");
  }
  
  public Car(String model, int capacity) {
    System.out.println("Car(String,int) 생성");
    this.model = model;
    this.capacity = capacity;
  }
  
  public Car(int capacity, String model) {
    System.out.println("Car(int,String) 생성");
    this.model = model;
    this.capacity = capacity;
  }
  
  public String getModel() {
    return model;
  }
  public void setModel(String model) {
    System.out.println("setModel() 호출됨.");
    this.model = model;
  }
  public int getCapacity() {
    return capacity;
  }
  public void setCapacity(int capacity) {
    System.out.println("setCapacity() 호출됨.");
    this.capacity = capacity;
  }
  public Date getOutDate() {
    return outDate;
  }
  public void setOutDate(Date outDate) {
    System.out.println("setOutDate() 호출됨.");
    this.outDate = outDate;
  }
  public Engine getEngine() {
    return engine;
  }
  public void setEngine(Engine engine) {
    System.out.println("setEngine() 호출됨.");
    this.engine = engine;
  }
  public Tire[] getTires() {
    return tires;
  }
  public void setTires(Tire[] tires) {
    System.out.println("setTires() 호출됨.");
    this.tires = tires;
  }
  public List<CompactDisc> getJukebox() {
    return jukebox;
  }
  public void setJukebox(List<CompactDisc> jukebox) {
    System.out.println("setJukebox() 호출됨.");
    this.jukebox = jukebox;
  }
  public Map<String, String> getOptions() {
    return options;
  }
  public void setOptions(Map<String, String> options) {
    System.out.println("setOptions() 호출됨.");
    this.options = options;
  }
}










