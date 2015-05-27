package step06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 실습 목표: @Autowired 애노테이션 사용하기
 * - <property> 태그 대신 애노테이션을 사용하여 의존 객체 주입하기
 * - 1) 셋터 메서드에 선언
 * - 2) 인스턴스 변수에 선언
 *      => 캡슐화를 깨뜨리는 기법이라하여 비난을 받기도 한다. 
 * [사용법]
 * - 이 애노테이션을 스프링에서 처리하려면, BeanPostProcessor 구현체를 등록해야 한다. 
 * - @Autowired 애노테이션의 BeanPostProcessor 구현체?
 *   
 *        
 */

public class Test01 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            new String[] {"step06/application-context01.xml"});
    
    System.out.println(context.getBean("car1"));
    
    for (String beanName : context.getBeanDefinitionNames()) {
      System.out.println("==>" + beanName);
    }
  }

}













