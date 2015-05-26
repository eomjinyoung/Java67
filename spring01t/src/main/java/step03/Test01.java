package step03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 실습 목표: 의존 객체 주입하기 */

public class Test01 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            new String[] {"step03/application-context01.xml"});

    Car car1 = (Car)context.getBean("car1");
    Car car2 = (Car)context.getBean("car2");
    
    System.out.printf("%s\n", car1);
    System.out.printf("%s\n", car2);
    
    System.out.printf("%b\n", car1.getEngine() == car2.getEngine());
  }

}











