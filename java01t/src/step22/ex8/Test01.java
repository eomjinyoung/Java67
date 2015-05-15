package step22.ex8;

/* 실습 목표: 빌더 객체와 팩토리 객체를 이용하여 객체 생성하기.
 * - Builder 패턴, Factory Method 패턴
 * - Abstract Factory 패턴
 *   => 인터페이스나 추상 클래스를 이용하여 하위 클래스 기능의 
 *      개략적인 틀을 잡는다.
 *      하위 클래스에서 반드시 구현해야 하는 메서드는 추상 메서드로 만든다.
 *   => 하위 클래스를 만드는 개발자는 그 틀에 맞춰서 클래스를 정의한다.
 *   => 클래스를 사용하는 개발자도 그 틀에 맞춰서 사용한다. 
 */
public class Test01 {

  public static void main(String[] args) {
    // 1. 빌더 객체를 통해 팩토리를 얻는다.
    // - 팩토리를 사용하는 개발자는 팩토리 클래스의 구체적인 이름을 사용하지 않는다.
    // - 유지보수에 유연한 구조이다. 
    // - 왜? 나중에 다른 팩토리를 리턴하더라도 코드를 바꿀 필요가 없기 때문이다.
    // - 
    CarFactory factory = CarFactoryBuilder.build("truck");
     
    Car c1 = factory.createCar("gold");
    
    System.out.println(c1.model);

  }

}









