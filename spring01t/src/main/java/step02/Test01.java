package step02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 실습 목표: 생성자 호출하기 */

public class Test01 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            new String[] {"step02/application-context01.xml"});

    System.out.printf("%s\n", context.getBean("car1"));
    System.out.printf("%s\n", context.getBean("car2"));
    System.out.printf("%s\n", context.getBean("car3"));
  }

}











