package step04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 실습 목표: 스프링 팩토리 메서드를 사용하여 객체 생성하기*/

public class Test03 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            new String[] {"step04/application-context03.xml"});

    Object obj1 = context.getBean("obj1");
    System.out.println(obj1.getClass());
    System.out.println(obj1);
    
    Object obj2 = context.getBean("obj1");
    System.out.println(obj2.getClass());
    System.out.println(obj2);
    
    if (obj1 == obj2) {
      System.out.println("obj1 == obj2");
    } else {
      System.out.println("obj1 != obj2");
    }
    
  }

}





















