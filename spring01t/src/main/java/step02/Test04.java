package step02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 실습 목표: <property> 를 사용하여 셋터 메서드 호출하기
 * - <bean>의 "p" 네임스페이스를 사용하여 프로퍼티 값 설정하기 
 *  
 */

public class Test04 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            new String[] {"step02/application-context04.xml"});

    System.out.printf("%s\n", context.getBean("car1"));
    System.out.printf("%s\n", context.getBean("car2"));
    System.out.printf("%s\n", context.getBean("car3"));
    System.out.printf("%s\n", context.getBean("car4"));
  }

}











