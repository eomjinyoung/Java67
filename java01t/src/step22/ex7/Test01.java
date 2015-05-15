package step22.ex7;

/* 실습 목표: 팩토리를 이용한 객체 생성 (Factory Method Pattern)
 * - 객체 생성 과정이 복잡할 경우 팩토리를 통해 객체를 생성한다.
 */
public class Test01 {

  public static void main(String[] args) {
    // 1. 일반적인 객체 생성
    Car c1 = new Car();
    c1.model = "티코";
    c1.cc = 800;
    c1.options.put("air", "YES");
    c1.options.put("airbag", "YES");
    c1.options.put("sunroof", "NO");
    
    // 2. 팩토리를 통해 객체 생성 
    CarFactory factory = new CarFactory();
    Car c2 = factory.createCar("gold");
    System.out.println(c2.model);
    

  }

}









