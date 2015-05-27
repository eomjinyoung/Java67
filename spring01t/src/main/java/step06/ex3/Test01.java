package step06.ex3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/* 실습 목표: @Autowired 애노테이션의 required 속성
 * - @Autowired는 기본으로 필수 입력이다.
 * - 만약 주입할 의족 객체가 없으면 예외가 발생한다.
 * - 의존 객체가 없더라도 정상적으로 객체를 생성하려면?
 *   의존 객체에 대해 선택 사항으로 설정해야 한다.
 *   => @Autowired 애노테이션의 required 속성을 false로 설정하라!
 *      기본은 true이다.
 *        
 *        
 */

public class Test01 {

  public static void main(String[] args) {
    ApplicationContext context =
        new ClassPathXmlApplicationContext(
            new String[] {"step06/ex3/application-context01.xml"});
    
    System.out.println(context.getBean("car1"));
    
    for (String beanName : context.getBeanDefinitionNames()) {
      System.out.println("==>" + beanName);
    }
  }

}













