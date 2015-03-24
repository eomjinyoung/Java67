package step16.ch06;

/* 추상 클래스 활용: 3단계
 * => 일반화 작업을 통해 뽑은 수퍼 클래스를 추상 클래스로 만들기.
 * => 어차피 서브 클래스에서 재정의해야 할 메서드라면, 추상 메서드로 선언하라!   
 */

public class Test {

  public static void main(String[] args) {
    // 어처구니가 없게시리, Car 클래스를 직접 사용하려 한다.
    // Car 클래스는 단지 서브 클래스의 공통 속성이나 기능을 상속해주는 용도인데도 불구하고.
    // 다음 명령이 불가능하게 만들라! => 추상 클래스로 선언하라!
    //Car car0 = new Car(); // 컴파일 오류!
    
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














