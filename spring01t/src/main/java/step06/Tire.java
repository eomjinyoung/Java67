package step06;

public class Tire {
  String  maker;
  int     radius;
  int     width;
  
  @Override
  public String toString() {
    return "Tire [maker=" + maker + ", radius=" + radius + ", width=" + width
        + "]";
  }

  public Tire() {
    System.out.println("Tire() 생성");
  }

  public String getMaker() {
    return maker;
  }

  public void setMaker(String maker) {
    System.out.println("Tire.setMaker() 호출");
    this.maker = maker;
  }

  public int getRadius() {
    return radius;
  }

  public void setRadius(int radius) {
    System.out.println("Tire.setRadius() 호출");
    this.radius = radius;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    System.out.println("Tire.setWidth() 호출");
    this.width = width;
  }
  
  
}
