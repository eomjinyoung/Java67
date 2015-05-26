package step03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 실습 목표: List 및 Map 객체 주입하기 */

public class Test04 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            new String[] {"step03/application-context04.xml"});

    CompactDisc cd1 = (CompactDisc)context.getBean("cd1");
    System.out.printf("%s\n", cd1);
    
    CompactDisc cd2 = (CompactDisc)context.getBean("cd2");
    System.out.printf("%s\n", cd2);
    
    Car car1 = (Car)context.getBean("car1");
    System.out.printf("%s\n", car1);
  }

}











