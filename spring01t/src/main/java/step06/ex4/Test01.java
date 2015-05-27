package step06.ex4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 실습 목표: @Qualifier 애노테이션
 * - 같은 타입의 의존 객체가 여러 개 있을 경우,
 *   어떤 것을 선택해야 할지 알 수 없기 때문에 스프링에서는 오류를 발생시킨다.
 * - 해결책?
 *   @Qualifier 애노테이션을 사용하여 주입할 객체를 지정한다.
 * - 사용법
 *   @Qualifier 애노테이션을 처리할 BeanPostProcessor를 등록해야 한다.
 *   @Autowired와 @Qualifier 애노테이션 등에 대해 BeanPostProcessor를 자동 등록하는
 *   <context:annotation-config/> 태그를 추가하라!
 *   => 당연히 <beans> 태그에 context 네임스페이스를 선언해야 한다.        
 */

public class Test01 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            new String[] {"step06/ex4/application-context01.xml"});
    
    System.out.println(context.getBean("car1"));
    
    for (String beanName : context.getBeanDefinitionNames()) {
      System.out.println("==>" + beanName);
    }
  }

}













