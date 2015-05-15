package step22.ex8;

public class TicoFactory implements CarFactory {
  public Car createCar(String type) {
    Car c = new Car();
    switch (type) {
    case "gold":
      c.model = "티코 골드";
      c.cc = 800;
      c.options.put("air", "YES");
      c.options.put("airbag", "YES");
      c.options.put("sunroot", "YES");
      c.options.put("sidebag", "YES");
      c.options.put("chrom", "YES");
      break;
    default:
      c.model = "티코";
      c.cc = 800;
      c.options.put("air", "YES");
      c.options.put("airbag", "YES");
      c.options.put("sunroot", "NO");
      c.options.put("sidebag", "NO");
      c.options.put("chrom", "NO");
    }
    
    return c;
  }
}








