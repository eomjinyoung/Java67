package step01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 실습 목표: 빈의 사용 범위를 지정하기
 * - singleton : 객체를 한 개만 생성한다. (기본 설정)
 * - prototype : 객체를 요청할 때마다 생성한다.
 * - request : 웹 애플리케이션에서 사용. ServletRequest에 보관.
 * - session : 웹 애플리케이션에서 사용. HttpSession에 보관
 * - application: 웹 애플리케이션에서 사용. ServletContext에 보관.
 *     
 * - prototype 객체는 getBean()을 호출했을 때 객체를 생성한다.
 */

public class Test05 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            new String[] {"step01/application-context05.xml"});

    System.out.println("scope이 singleton인 경우,------------------");
    System.out.printf("%s\n", context.getBean("car1"));
    System.out.printf("%s\n", context.getBean("car1"));
    System.out.printf("%s\n", context.getBean("car1"));
    
    System.out.println("scope이 prototype인 경우,------------------");
    System.out.println("=> getBean()을 호출할 때마다 객체를 생성한다.");
    System.out.printf("%s\n", context.getBean("car2"));
    System.out.printf("%s\n", context.getBean("car2"));
    System.out.printf("%s\n", context.getBean("car2"));
  }

}



























