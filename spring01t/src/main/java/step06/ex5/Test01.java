package step06.ex5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 실습 목표: @Resource 애노테이션
 * - @Resource = @Autowired + @Qualifier
 * - JSR-250 명세에 정의된 애노테이션
 *         
 */

public class Test01 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            new String[] {"step06/ex5/application-context01.xml"});
    
    System.out.println(context.getBean("car1"));
    
    for (String beanName : context.getBeanDefinitionNames()) {
      System.out.println("==>" + beanName);
    }
  }

}













