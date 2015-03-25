package step16.ch08;

/* 인터페이스 활용: 2단계
 * => testCar()에서 호출하는 메서드를 규칙으로 정의하자. 
 * => ICar 인터페이스를 정의하고, 
 *    testCar()에서 호출하는 메서드를 선언한다.
 *    . dashboard()
 *    . accelerate()
 *    . reduce()
 *    . stop()
 *       
 */

/* 실습 시나리오
 * => 자동차를 테스트하는 공장이라고 가정하자.
 * => 이 공장은 자동차를 3번 가속하고, 2번 감속한다. 
 * => 그리고 그 자동차의 상태 정보를 출력한다.
 * 
 * 시습 시나리오 추가!
 * => 전기 자동차의 충전 상태를 테스트한다. 
 * 
 * 밧데리 상태를 검사하기 위해 새로운 규칙을 정의한다.
 * 규칙명: Battery
 * 세부기능: charge() 와 getBatteryState()
 * 
 * 실습 목표:
 * => 인터페이스를 활용했을 때 유용한 점. => Battery, testBattery() 참고
 * => 다중 인터페이스의 구현 확인 => Tesla
 * 
 */
public class Test {

  public static void testBattery(Battery battery) {
    battery.charge(100);
    System.out.println("밧데리 상태 >>>>>>>>>>>>>>>>>>>>>>>");
    System.out.printf("잔여량: %.1f%%\n", battery.getBatteryState());
    System.out.println("<<<<<<<<<<<<<<<<<<<<");
  }
  
  public static void testCar(ICar car) {
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
    car3.setBattery(44);
    
    // ModelS는 Tesla의 서브 클래스다.
    // Tesla가 ICar 규칙을 따르기 때문에, Tesla를 상속 받은 서브 클래스도 
    // 그 규칙을 따른 것이 된다.
    // => Tesla의 서브클래스는 Tesla로부터 ICar를 구현한 메서드를 상속 받았기 때문이다.
    testCar(car3); // 테스트 가능!
    
    // ModelS는 밧데리를 사용하는 장비이기 때문에, 밧데리 검사도 수행할 수 있다.
    testBattery(car3);
    
    // SmartPhone은 밧데리 규칙에 따라 만든 장비이기 때문에, 테스트 할 수 있다.
    SmartPhone phone = new SmartPhone();
    testBattery(phone);
    
  }

}

























