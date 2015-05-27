package step06.ex2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 실습 목표: @Autowired 애노테이션 사용하기
 * - 인스턴스 변수에 선언하기
 *   
 *        
 */

public class Test01 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            new String[] {"step06/ex2/application-context01.xml"});
    
    System.out.println(context.getBean("car1"));
    
    for (String beanName : context.getBeanDefinitionNames()) {
      System.out.println("==>" + beanName);
    }
  }

}













