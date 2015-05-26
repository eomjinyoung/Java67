package step02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 실습 목표: <constructor-arg> 대신 <bean>의 속성 사용하기
 *  
 */

public class Test03 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            new String[] {"step02/application-context03.xml"});

    System.out.printf("%s\n", context.getBean("car1"));
    System.out.printf("%s\n", context.getBean("car2"));
    System.out.printf("%s\n", context.getBean("car3"));
  }

}











