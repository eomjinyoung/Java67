package step22.ex8;

public class TruckFactory implements CarFactory {
  public Car createCar(String type) {
    Truck c = new Truck();
    switch (type) {
    case "gold":
      c.model = "비트덤프 골드";
      c.cc = 12000;
      c.maxWeight = 10;
      c.weight = 2;
      c.options.put("air", "YES");
      c.options.put("airbag", "YES");
      break;
    default:
      c.model = "비트덤프";
      c.cc = 8000;
      c.maxWeight = 7;
      c.weight = 1;
      c.options.put("air", "YES");
      c.options.put("airbag", "YES");
    }
    
    return c;
  }
}
