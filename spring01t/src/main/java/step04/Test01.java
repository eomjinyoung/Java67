package step04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 실습 목표: 팩토리 메서드를 사용하여 객체 생성하기*/

public class Test01 {

  public static void main(String[] args) {
    // 1. 일반적인 팩토리 메서드 사용법
    Car car1 = CarFactory.createCar("c1");
    System.out.println(car1);

    // 2. 스프링 빈 컨테이너를 이용하여 팩토리 메서드 호출하기
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            new String[] {"step04/application-context01.xml"});

    Object obj1 = context.getBean("obj1");
    System.out.println(obj1.getClass());
    
    Object obj2 = context.getBean("obj2");
    System.out.println(obj2.getClass());
    
    System.out.println(obj2);
  }

}













