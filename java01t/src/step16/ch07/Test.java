package step16.ch07;

/* 인터페이스 활용: 1단계
 * => 추상 클래스의 한계: 여러 개를 상속 받을 수 없다.
 *       
 */

/* 실습 시나리오
 * => 자동차를 테스트하는 공장이라고 가정하자.
 * => 이 공장은 자동차를 3번 가속하고, 2번 감속한다. 
 * => 그리고 그 자동차의 상태 정보를 출력한다.
 */
public class Test {

  public static void testCar(Car car) {
    System.out.println("---------------------------");
    System.out.printf("모델명: %s\n", car.getModel());
    
    car.accelerate();
    car.accelerate();
    car.accelerate();
    
    car.reduce();
    car.reduce();
    
    car.dashboard();
    
    System.out.println("---------------------------");
    
  }
  
  public static void main(String[] args) {
    Tico car1 = new Tico();
    car1.setModel("티코2015");
    car1.setCc(800);
    car1.setCapacity(5);
    
    VolvoTruck car2 = new VolvoTruck();
    car2.setModel("볼보FH");
    car2.setHp(540);
    car2.load(2000);
    
    testCar(car1);
    testCar(car2);
    
    ModelS car3 = new ModelS();
    car3.setModel("모델S");
    car3.setBattery(60);
    
    // ModelS는 Car와 다른 계열의 자동차다.
    // Tesla 계열의 전기 자동차이다.
    // 그래서 testCar()에서 그 자동차를 테스트 할 수 없다.
    
    // 해결책1: ModelS가 Car를 상속 받는다.
    // => 문제점: 기존의 Tesla 기능을 포기해야 한다.
    //
    // 해결책2: Tesla도 상속받고 Car도 상속받기.
    // => 문제점: 자바는 다중 상속을 지원하지 않는다.
    //
    // 해결책3: 테스트에 필요한 기능만 규칙으로 정의하자.
    // => ch08에서 확인하라!
    //testCar(car3); // 오류!
  }

}

























