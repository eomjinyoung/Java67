package step03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 실습 목표: 컬렉션 주입하기 */

public class Test03 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            new String[] {"step03/application-context03.xml"});

    Car car1 = (Car)context.getBean("car1");
    System.out.printf("%s\n", car1);
    
    Car car2 = (Car)context.getBean("car2");
    System.out.printf("%s\n", car2);
  }

}











