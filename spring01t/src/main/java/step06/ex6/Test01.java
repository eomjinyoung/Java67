package step06.ex6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 실습 목표: 빈을 자동으로 등록하기
 * - <bean> 태그를 사용하는 대신에 애노테이션을 사용하여 생성할 빈을 지정한다.
 * - @Component : 자동으로 생성할 빈에 대해 붙인다.
 * - @Repository: DAO와 같은 퍼시스턴스 역할을 수행하는 객체에 붙인다.
 * - @Service   : 비즈니스 로직을 수행하는 객체에 붙인다.
 * - @Controller: MVC 아키텍처에서 페이지 컨트롤러 객체에 붙인다.
 * - [사용법]
 *   애노테이션이 붙은 빈을 찾도록 설정한다.
 *   <context:component-scan base-package="빈을 찾기 위한 패키지"/>
 *   => 이 태그를 선언하면 <context:annotation-config> 태그는
 *      선언하지 않아도 된다.        
 */

public class Test01 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            new String[] {"step06/ex6/application-context01.xml"});
    
    // @Component 애노테이션으로 자동 생성한 빈은
    // 클래스 이름(첫 알파벳은 소문자)을 빈의 이름으로 사용한다.
    System.out.println(context.getBean("car"));
    
    for (String beanName : context.getBeanDefinitionNames()) {
      System.out.println("==>" + beanName);
    }
  }

}













