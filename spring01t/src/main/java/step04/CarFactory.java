package step04;

public class CarFactory {
  public static Car createCar(String model) {
    Car c = new Car();
    switch (model) {
    case "c1":
      c.setModel("티코");
      c.setCapacity(5);
      break;
    case "c2":
      c.setModel("아반테");
      c.setCapacity(5);
      break;
    default:
      c.setModel("소나타");
      c.setCapacity(5);
    }
    return c;
  }
}
