package step02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 실습 목표: <constructor-arg>의 다양한 설정 방법
 *  
 */

public class Test02 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            new String[] {"step02/application-context02.xml"});

    System.out.printf("%s\n", context.getBean("car1"));
    System.out.printf("%s\n", context.getBean("car2"));
    System.out.printf("%s\n", context.getBean("car3"));
    System.out.printf("%s\n", context.getBean("car4"));
    System.out.printf("%s\n", context.getBean("car5"));
  }

}











