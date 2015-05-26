package step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 실습 목표: 빈(객체)의 이름을 지정하지 않기
 * - 빈 컨테이너에 보관할 때 다음의 형식의 이름으로 보관한다.
 *   패키지명 + 클래스명 + #인덱스    
 */

public class Test04 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            new String[] {"step01/application-context04.xml"});

    // 익명 빈 꺼내기
    System.out.printf("%s\n", context.getBean("step01.Car#0"));
    System.out.printf("%s\n", context.getBean("step01.Car#1"));
    System.out.printf("%s\n", context.getBean("step01.Car#2"));
    
    // 익명 빈의 경우
    // 첫 번째 빈의 별명은 인덱스가 붙지 않은 이름이다.
    System.out.printf("%s\n", context.getBean("step01.Car"));
    System.out.printf("%s\n", context.getBean("step01.Car"));
    System.out.printf("%s\n", context.getBean("step01.Car"));
    
    System.out.println("빈의 이름 출력하기-------------------"); 
    for (String beanName : context.getBeanDefinitionNames()) {
      System.out.println(beanName);
    }
    
    System.out.println("각 빈의 별명을 출력하기---------------");
    System.out.println("-----------> step01.Car#0 빈의 별명");
    for (String alias : context.getAliases("step01.Car#0")) {
      System.out.println(alias);
    }
    System.out.println("-----------> step01.Car#1 빈의 별명");
    for (String alias : context.getAliases("step01.Car#1")) {
      System.out.println(alias);
    }
    System.out.println("-----------> step01.Car#2 빈의 별명");
    for (String alias : context.getAliases("step01.Car#2")) {
      System.out.println(alias);
    }
  }

}



























