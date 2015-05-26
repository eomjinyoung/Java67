package step05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 실습 목표: 원시 타입이 아닌, 다른 타입의 프로퍼티 값 설정하기 */

public class Test01 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            new String[] {"step05/application-context01.xml"});
    
    System.out.println(context.getBean("car1"));
    System.out.println(context.getBean("car2"));
  }

}













