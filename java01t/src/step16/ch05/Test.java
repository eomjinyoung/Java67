package step16.ch05;

/* 추상 클래스 활용: 2단계
 * => Tico와 VolvoTruck의 공통 속성 및 메서드를 뽑아서 수퍼 클래스 정의
 *    "상속:일반화(Generalization)"
 * => Car 클래스 정의   
 */

public class Test {

  public static void main(String[] args) {
    Tico car1 = new Tico();
    car1.setModel("티코2015");
    car1.setCc(800);
    car1.setCapacity(5);
    
    car1.accelerate();
    car1.accelerate();
    car1.accelerate();
    car1.accelerate();
    car1.accelerate();
    
    car1.reduce();
    car1.reduce();
    car1.reduce();
    car1.reduce();
    car1.reduce();

    System.out.println("----------------------");
    
    VolvoTruck car2 = new VolvoTruck();
    car2.setModel("볼보FH");
    car2.setHp(540);
    car2.load(0);
    
    car2.accelerate();
    car2.accelerate();
    car2.accelerate();
    car2.stop();
    
    car2.load(60000);
    car2.accelerate();
    car2.accelerate();
    car2.accelerate();
    
    car2.reduce();
    car2.reduce();
    car2.reduce();
  }

}














